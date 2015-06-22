package com.innoppl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;

import com.innoppl.dbconnect.SingleConnect;



public class ListData {

	private SingleConnect singleConnect = new SingleConnect();	
	private List<MyList> submissionData = new ArrayList<MyList>();
	private Integer userID=0;
	
	public ListData(){
		Session sess = Sessions.getCurrent();
		this.setUserID((Integer) sess.getAttribute("assist_user_id"));
		String searchVinVal = "", searchTagVal ="";
		searchVinVal = (String) sess.getAttribute("searchVinVal");
		searchTagVal = (String) sess.getAttribute("searchTagVal");
		Date startDate =  (Date) sess.getAttribute("searchStartDate");
		Date endDate =  (Date) sess.getAttribute("searchEndDate");
		Connection conn = null;
		conn = singleConnect.connectToDatabaseOrDie();
		String tempContent= "", firstName="", lastName ="", customerName ="", mobileNo ="", formDate="", formName ="", techName ="", vinNumber ="", makeVal ="", modelVal ="", tagNumber ="", timer="";
		int i =0, submissionID = 0;
		System.out.println(this.getUserID());
		try{
			Statement st = conn.createStatement();
			Statement innerSt = conn.createStatement();
		    ResultSet rs, innerRs;
		    if(startDate != null && !startDate.equals("") && endDate != null && !endDate.equals("")){
		    	rs = st.executeQuery("select * from form_submission_index where user_id="+this.getUserID()+" and created_date between '"+ startDate +"' and '" +endDate+"' order by form_submission_id desc" );
			}else{
				rs = st.executeQuery("select * from form_submission_index where user_id="+this.getUserID()+" order by form_submission_id desc");
			}
		    
		    i =0;
		    while( rs.next() ){
		    	timer = rs.getString("timer");
		    	if(rs.getString("form_name").equals("101 form")){
		    		formName = "oneHtml";
		    	}else if(rs.getString("form_name").equals("102 form")){
		    		formName = "twoHtml";
		    	}else if(rs.getString("form_name").equals("103 form")){
		    		formName = "threeHtml";
		    	}else if(rs.getString("form_name").equals("104 form")){
		    		formName = "fourHtml";
		    	}else{
		    		formName = "oneHtml";
		    	}
		    	submissionID = rs.getInt("form_submission_id");
		    	innerRs = innerSt.executeQuery("select * from form_submission_profile_data where form_submission_id =  "+ rs.getInt("form_submission_id"));
				while (innerRs.next()){
					tempContent = tempContent +" "+ innerRs.getString("profile_field") + "=\"" + innerRs.getString("profile_value") + "\"; "; 
				}
				firstName = parseValueFromHeader(tempContent, "first_name");
				lastName = parseValueFromHeader(tempContent, "last_name");
				customerName = firstName +" "+ lastName; 
				mobileNo = parseValueFromHeader(tempContent, "mobile_no");
				formDate = parseValueFromHeader(tempContent, "Date");
				techName = parseValueFromHeader(tempContent, "tech_name");
				vinNumber = parseValueFromHeader(tempContent, "vin");
				tagNumber = parseValueFromHeader(tempContent, "tag");
				makeVal = parseValueFromHeader(tempContent, "make");
				modelVal = parseValueFromHeader(tempContent, "model");
				i++;

				tempContent = "";
				if(searchVinVal != null && !searchVinVal.equals("")){
					if(vinNumber != null){
						if(vinNumber.equals(searchVinVal)){
							submissionData.add(new MyList(i, customerName, mobileNo, formDate, formName, submissionID, techName, vinNumber, makeVal, modelVal, tagNumber, timer));
						}
					}	
				}else if(searchTagVal != null && !searchTagVal.equals("")){
					if(tagNumber != null){
						if(tagNumber.equals(searchTagVal)){
							submissionData.add(new MyList(i, customerName, mobileNo, formDate, formName, submissionID, techName, vinNumber, makeVal, modelVal, tagNumber, timer));
						}
					}	
				}
				else{
					submissionData.add(new MyList(i, customerName, mobileNo, formDate, formName, submissionID, techName, vinNumber, makeVal, modelVal, tagNumber, timer));
				}	
		    	
		    }
		    sess.setAttribute("searchVinVal", null);
		    sess.setAttribute("searchTagVal", null);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	


	private static String parseValueFromHeader(String header, String parameterName) {
        String parameterValue = null;
        StringTokenizer st = new StringTokenizer(header, ";");
          while (st.hasMoreTokens()) {
              String token = st.nextToken();
              if (token.contains(parameterName)) {
                  int quoteIndex = token.indexOf("\"");
                  parameterValue = token.substring(quoteIndex+1,token.length()-1);
                  // logger.finer("parameter " + parameterName + " is "+ parameterValue);
                  break;
              }
          }
        return parameterValue;
    }
	
	public List<MyList> getSubmissionReports() {
		return submissionData;
	}

	public Integer getUserID() {
		return userID;
	}



	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	

	
}
