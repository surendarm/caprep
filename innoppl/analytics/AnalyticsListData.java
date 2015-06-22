package com.innoppl.analytics;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;

import com.innoppl.dbconnect.SingleConnect;

public class AnalyticsListData {

	private SingleConnect singleConnect = new SingleConnect();	
	private List<AnalyticsList> blockOneReportData = new ArrayList<AnalyticsList>();
	private List<AnalyticsList> blockTwoReportData = new ArrayList<AnalyticsList>();
	private List<AnalyticsList> blockThreeReportData = new ArrayList<AnalyticsList>();
	private List<AnalyticsList> blockFourZeroReportData = new ArrayList<AnalyticsList>();
	private List<AnalyticsList> blockFourOneReportData = new ArrayList<AnalyticsList>();
	private Integer userID=0;

	private String blockOneTitle, blockTwoTitle, blockThreeTitle, blockFourZeroTitle, blockFourOneTitle, periodValue, totalSubmissions;

	private String legendOne, legendTwo, legendThree; 
	

	@SuppressWarnings("resource")
	public AnalyticsListData(){
		Session sess = Sessions.getCurrent();
		this.setUserID((Integer) sess.getAttribute("assist_user_id"));
		Date startDate =  (Date) sess.getAttribute("analyticsSearchStartDate");
		Date endDate =  (Date) sess.getAttribute("analyticsSearchEndDate");
		sess.setAttribute("downloadFileName", null);


		//String userFormID = "3739", componentName ="", optionChosen = "";
		String userFormID ="", componentName ="", optionChosen = "";
		
		int oneC[] = new int[1000];
		int twoC[] = new int[1000];
		int threeC[] = new int[1000];
		int i =0;

		int[] blockOnePositions = new int[]{7, 8, 9, 10, 11, 12, 13, 14};
		int[] blockTwoPositions = new int[]{16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26};
		int[] blockThreePositions = new int[]{31, 32, 33, 34, 35, 36, 37, 38};
		int[] blockFourZeroPositions = new int[]{44, 45, 46, 47};
		int[] blockFourOnePositions = new int[]{53, 54, 55, 56};

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		String todaysDate = dateFormat.format(date);
		
		
		Connection conn = null;
		conn = singleConnect.connectToDatabaseOrDie();


		try{
			Statement st = conn.createStatement();
			Statement innerSt = conn.createStatement();
			ResultSet rs, innerRs;

			rs = st.executeQuery("select user_form_id from user_forms where user_id = "+this.getUserID()+" and form_name in ('103 form','103 Form')");
			while(rs.next()){
				userFormID = rs.getString("user_form_id");
			}
			
			if(userFormID.equals(null) || userFormID.equals("") || userFormID == ""){
				Executions.sendRedirect("/SelectForm.zul");
			}
			
			if(startDate != null && !startDate.equals("") && endDate != null && !endDate.equals("")){
				setPeriodValue("Analytics for period "+ dateFormat.format(startDate) + " - " + dateFormat.format(endDate));
			}else{
				setPeriodValue("Analytics for today - "+ dateFormat.format(date));
			}

			if(startDate != null && !startDate.equals("") && endDate != null && !endDate.equals("")){
				rs = st.executeQuery("select * from form_submission_index where user_id = "+this.getUserID()+" and form_name in ('103 form','103 Form') and created_date between '"+ startDate +"' and '" +endDate+"' order by form_submission_id desc ");

			}else{
				rs = st.executeQuery("select * from form_submission_index where user_id = "+this.getUserID()+" and form_name in ('103 form','103 Form')  and created_date = '"+ todaysDate +"' order by form_submission_id desc ");

			}
			i = 0;
			while(rs.next()){
				i++;
			}
			this.totalSubmissions = "Total Number of Inspections : " + i;


			if(startDate != null && !startDate.equals("") && endDate != null && !endDate.equals("")){
				rs = st.executeQuery("select * from form_submission_index where user_id = "+this.getUserID()+" and form_name in ('103 form','103 Form') and created_date between '"+ startDate +"' and '" +endDate+"' order by form_submission_id desc ");

			}else{
				rs = st.executeQuery("select * from form_submission_index where user_id = "+this.getUserID()+" and form_name in ('103 form','103 Form')  and created_date = '"+ todaysDate +"' order by form_submission_id desc ");

			}


			while(rs.next()){
				for(i=0;i<blockOnePositions.length;i++){

					innerRs= innerSt.executeQuery("select * from form_submission_component_data where " +
							"form_submission_id = " + rs.getInt("form_submission_id") +
							" and position_id = "+ blockOnePositions[i]);

					while( innerRs.next() ){
						optionChosen = innerRs.getString("option_description");
						if(optionChosen.equals("1")){
							oneC[blockOnePositions[i]]++;
						}else if(optionChosen.equals("2")){
							twoC[blockOnePositions[i]]++;
						}else if(optionChosen.equals("3")){
							threeC[blockOnePositions[i]]++;
						}
					}
				}
			}	


			for(i=0;i<blockOnePositions.length;i++){
				rs= st.executeQuery("select distinct(c.component_id), c.component_name, sc.label, op.option_description," +
						" op.options_name, uc.position_id from components c " +
						"left join user_forms_components uc on c.component_id = uc.component_id " +
						"left join sub_components sc on c.component_id = sc.component_id " +
						"left join sub_components_options sco on sc.sub_component_id = sco.sub_component_id " +
						"left join options op on sco.option_id = op.option_id " +
						"where uc.user_form_id = "+ userFormID +"and position_id="+blockOnePositions[i]);

				while( rs.next() ){
					componentName =  rs.getString("component_name");
				}

				blockOneReportData.add(new AnalyticsList(blockOnePositions[i], componentName, oneC[blockOnePositions[i]], twoC[blockOnePositions[i]], threeC[blockOnePositions[i]]));
			}

			/*
			 * 
			 * Block Two
			 */ 	


			if(startDate != null && !startDate.equals("") && endDate != null && !endDate.equals("")){
				rs = st.executeQuery("select * from form_submission_index where user_id = "+this.getUserID()+" and form_name in ('103 form','103 Form') and created_date between '"+ startDate +"' and '" +endDate+"' order by form_submission_id desc ");
			}else{
				rs = st.executeQuery("select * from form_submission_index where user_id = "+this.getUserID()+" and form_name in ('103 form','103 Form')  and created_date = '"+ todaysDate +"' order by form_submission_id desc ");
			}
			while(rs.next()){
				for(i=0;i<blockTwoPositions.length;i++){

					innerRs= innerSt.executeQuery("select * from form_submission_component_data where " +
							"form_submission_id = " + rs.getInt("form_submission_id") +
							" and position_id = "+ blockTwoPositions[i]);

					while( innerRs.next() ){
						optionChosen = innerRs.getString("option_description");
						if(optionChosen.equals("1")){
							oneC[blockTwoPositions[i]]++;
						}else if(optionChosen.equals("2")){
							twoC[blockTwoPositions[i]]++;
						}else if(optionChosen.equals("3")){
							threeC[blockTwoPositions[i]]++;
						}
					}
				}
			}	


			for(i=0;i<blockTwoPositions.length;i++){
				rs= st.executeQuery("select distinct(c.component_id), c.component_name, sc.label, op.option_description," +
						" op.options_name, uc.position_id from components c " +
						"left join user_forms_components uc on c.component_id = uc.component_id " +
						"left join sub_components sc on c.component_id = sc.component_id " +
						"left join sub_components_options sco on sc.sub_component_id = sco.sub_component_id " +
						"left join options op on sco.option_id = op.option_id " +
						"where uc.user_form_id = "+ userFormID +"and position_id="+blockTwoPositions[i]);

				while( rs.next() ){
					componentName =  rs.getString("component_name");
				}

				blockTwoReportData.add(new AnalyticsList(blockTwoPositions[i], componentName, oneC[blockTwoPositions[i]], twoC[blockTwoPositions[i]], threeC[blockTwoPositions[i]]));
			}


			/*
			 * 
			 * Block Three
			 * 	
			 */

			if(startDate != null && !startDate.equals("") && endDate != null && !endDate.equals("")){
				rs = st.executeQuery("select * from form_submission_index where user_id = "+this.getUserID()+" and form_name in ('103 form','103 Form') and created_date between '"+ startDate +"' and '" +endDate+"' order by form_submission_id desc ");
			}else{
				rs = st.executeQuery("select * from form_submission_index where user_id = "+this.getUserID()+" and form_name in ('103 form','103 Form')  and created_date = '"+ todaysDate +"' order by form_submission_id desc ");
			}
			while(rs.next()){
				for(i=0;i<blockThreePositions.length;i++){

					innerRs= innerSt.executeQuery("select * from form_submission_component_data where " +
							"form_submission_id = " + rs.getInt("form_submission_id") +
							" and position_id = "+ blockThreePositions[i]);

					while( innerRs.next() ){
						optionChosen = innerRs.getString("option_description");
						if(optionChosen.equals("1")){
							oneC[blockThreePositions[i]]++;
						}else if(optionChosen.equals("2")){
							twoC[blockThreePositions[i]]++;
						}else if(optionChosen.equals("3")){
							threeC[blockThreePositions[i]]++;
						}
					}
				}
			}	


			for(i=0;i<blockThreePositions.length;i++){
				rs= st.executeQuery("select distinct(c.component_id), c.component_name, sc.label, op.option_description," +
						" op.options_name, uc.position_id from components c " +
						"left join user_forms_components uc on c.component_id = uc.component_id " +
						"left join sub_components sc on c.component_id = sc.component_id " +
						"left join sub_components_options sco on sc.sub_component_id = sco.sub_component_id " +
						"left join options op on sco.option_id = op.option_id " +
						"where uc.user_form_id = "+ userFormID +"and position_id="+blockThreePositions[i]);

				while( rs.next() ){
					componentName =  rs.getString("component_name");
				}

				blockThreeReportData.add(new AnalyticsList(blockThreePositions[i], componentName, oneC[blockThreePositions[i]], twoC[blockThreePositions[i]], threeC[blockThreePositions[i]]));
			}


			/*
			 * 
			 * Block Four Zero
			 * 	
			 */


			if(startDate != null && !startDate.equals("") && endDate != null && !endDate.equals("")){
				rs = st.executeQuery("select * from form_submission_index where user_id = "+this.getUserID()+" and form_name in ('103 form','103 Form') and created_date between '"+ startDate +"' and '" +endDate+"' order by form_submission_id desc ");
			}else{
				rs = st.executeQuery("select * from form_submission_index where user_id = "+this.getUserID()+" and form_name in ('103 form','103 Form')  and created_date = '"+ todaysDate +"' order by form_submission_id desc ");
			}
			while(rs.next()){
				for(i=0;i<blockFourZeroPositions.length;i++){

					innerRs= innerSt.executeQuery("select * from form_submission_component_data where " +
							"form_submission_id = " + rs.getInt("form_submission_id") +
							" and position_id = "+ blockFourZeroPositions[i]);

					while( innerRs.next() ){
						optionChosen = innerRs.getString("option_description");
						if(optionChosen.equals("1")){
							oneC[blockFourZeroPositions[i]]++;
						}else if(optionChosen.equals("2")){
							twoC[blockFourZeroPositions[i]]++;
						}else if(optionChosen.equals("3")){
							threeC[blockFourZeroPositions[i]]++;
						}
					}
				}
			}	


			for(i=0;i<blockFourZeroPositions.length;i++){
				rs= st.executeQuery("select distinct(c.component_id), c.component_name, sc.label, op.option_description," +
						" op.options_name, uc.position_id from components c " +
						"left join user_forms_components uc on c.component_id = uc.component_id " +
						"left join sub_components sc on c.component_id = sc.component_id " +
						"left join sub_components_options sco on sc.sub_component_id = sco.sub_component_id " +
						"left join options op on sco.option_id = op.option_id " +
						"where uc.user_form_id = "+ userFormID +"and position_id="+blockFourZeroPositions[i]);

				while( rs.next() ){
					componentName =  rs.getString("component_name");
				}

				blockFourZeroReportData.add(new AnalyticsList(blockFourZeroPositions[i], componentName, oneC[blockFourZeroPositions[i]], twoC[blockFourZeroPositions[i]], threeC[blockFourZeroPositions[i]]));
			}


			/*
			 * 
			 * Block Four One
			 * 	
			 */


			if(startDate != null && !startDate.equals("") && endDate != null && !endDate.equals("")){
				rs = st.executeQuery("select * from form_submission_index where user_id = "+this.getUserID()+" and form_name in ('103 form','103 Form') and created_date between '"+ startDate +"' and '" +endDate+"' order by form_submission_id desc ");
			}else{
				rs = st.executeQuery("select * from form_submission_index where user_id = "+this.getUserID()+" and form_name in ('103 form','103 Form')  and created_date = '"+ todaysDate +"' order by form_submission_id desc ");
			}
			while(rs.next()){
				for(i=0;i<blockFourOnePositions.length;i++){

					innerRs= innerSt.executeQuery("select * from form_submission_component_data where " +
							"form_submission_id = " + rs.getInt("form_submission_id") +
							" and position_id = "+ blockFourOnePositions[i]);

					while( innerRs.next() ){
						optionChosen = innerRs.getString("option_description");
						if(optionChosen.equals("1")){
							oneC[blockFourOnePositions[i]]++;
						}else if(optionChosen.equals("2")){
							twoC[blockFourOnePositions[i]]++;
						}else if(optionChosen.equals("3")){
							threeC[blockFourOnePositions[i]]++;
						}
					}
				}
			}	


			for(i=0;i<blockFourOnePositions.length;i++){
				rs= st.executeQuery("select distinct(c.component_id), c.component_name, sc.label, op.option_description," +
						" op.options_name, uc.position_id from components c " +
						"left join user_forms_components uc on c.component_id = uc.component_id " +
						"left join sub_components sc on c.component_id = sc.component_id " +
						"left join sub_components_options sco on sc.sub_component_id = sco.sub_component_id " +
						"left join options op on sco.option_id = op.option_id " +
						"where uc.user_form_id = "+ userFormID +"and position_id="+blockFourOnePositions[i]);

				while( rs.next() ){
					componentName =  rs.getString("component_name");
				}

				blockFourOneReportData.add(new AnalyticsList(blockFourOnePositions[i], componentName, oneC[blockFourOnePositions[i]], twoC[blockFourOnePositions[i]], threeC[blockFourOnePositions[i]]));
			}


			rs= st.executeQuery("select distinct(c.component_id), c.component_name, sc.label, op.option_description," +
					" op.options_name, uc.position_id from components c " +
					"left join user_forms_components uc on c.component_id = uc.component_id " +
					"left join sub_components sc on c.component_id = sc.component_id " +
					"left join sub_components_options sco on sc.sub_component_id = sco.sub_component_id " +
					"left join options op on sco.option_id = op.option_id " +
					"where uc.user_form_id = "+ userFormID +"and position_id in(5)");

			while( rs.next() ){
				this.blockOneTitle= rs.getString("component_name");
			}


			rs= st.executeQuery("select distinct(c.component_id), c.component_name, sc.label, op.option_description," +
					" op.options_name, uc.position_id from components c " +
					"left join user_forms_components uc on c.component_id = uc.component_id " +
					"left join sub_components sc on c.component_id = sc.component_id " +
					"left join sub_components_options sco on sc.sub_component_id = sco.sub_component_id " +
					"left join options op on sco.option_id = op.option_id " +
					"where uc.user_form_id = "+ userFormID +"and position_id in(15)");

			while( rs.next() ){
				this.blockTwoTitle= rs.getString("component_name");
			}


			rs= st.executeQuery("select distinct(c.component_id), c.component_name, sc.label, op.option_description," +
					" op.options_name, uc.position_id from components c " +
					"left join user_forms_components uc on c.component_id = uc.component_id " +
					"left join sub_components sc on c.component_id = sc.component_id " +
					"left join sub_components_options sco on sc.sub_component_id = sco.sub_component_id " +
					"left join options op on sco.option_id = op.option_id " +
					"where uc.user_form_id = "+ userFormID +"and position_id in(30)");

			while( rs.next() ){
				this.blockThreeTitle= rs.getString("component_name");
			}


			rs= st.executeQuery("select distinct(c.component_id), c.component_name, sc.label, op.option_description," +
					" op.options_name, uc.position_id from components c " +
					"left join user_forms_components uc on c.component_id = uc.component_id " +
					"left join sub_components sc on c.component_id = sc.component_id " +
					"left join sub_components_options sco on sc.sub_component_id = sco.sub_component_id " +
					"left join options op on sco.option_id = op.option_id " +
					"where uc.user_form_id = "+ userFormID +"and position_id in(40)");

			while( rs.next() ){
				this.blockFourZeroTitle= rs.getString("component_name");
			}


			rs= st.executeQuery("select distinct(c.component_id), c.component_name, sc.label, op.option_description," +
					" op.options_name, uc.position_id from components c " +
					"left join user_forms_components uc on c.component_id = uc.component_id " +
					"left join sub_components sc on c.component_id = sc.component_id " +
					"left join sub_components_options sco on sc.sub_component_id = sco.sub_component_id " +
					"left join options op on sco.option_id = op.option_id " +
					"where uc.user_form_id = "+ userFormID +"and position_id in(52)");

			while( rs.next() ){
				this.blockFourOneTitle= rs.getString("component_name");
			}


			rs= st.executeQuery("select distinct(c.component_id), c.component_name, sc.label, op.option_description," +
					" op.options_name, uc.position_id from components c " +
					"left join user_forms_components uc on c.component_id = uc.component_id " +
					"left join sub_components sc on c.component_id = sc.component_id " +
					"left join sub_components_options sco on sc.sub_component_id = sco.sub_component_id " +
					"left join options op on sco.option_id = op.option_id " +
					"where uc.user_form_id = "+ userFormID +"and position_id in(2)");

			while( rs.next() ){
				this.legendOne= rs.getString("component_name");
			}

			

			rs= st.executeQuery("select distinct(c.component_id), c.component_name, sc.label, op.option_description," +
					" op.options_name, uc.position_id from components c " +
					"left join user_forms_components uc on c.component_id = uc.component_id " +
					"left join sub_components sc on c.component_id = sc.component_id " +
					"left join sub_components_options sco on sc.sub_component_id = sco.sub_component_id " +
					"left join options op on sco.option_id = op.option_id " +
					"where uc.user_form_id = "+ userFormID +"and position_id in(3)");

			while( rs.next() ){
				this.legendTwo = rs.getString("component_name");
			}

			

			rs= st.executeQuery("select distinct(c.component_id), c.component_name, sc.label, op.option_description," +
					" op.options_name, uc.position_id from components c " +
					"left join user_forms_components uc on c.component_id = uc.component_id " +
					"left join sub_components sc on c.component_id = sc.component_id " +
					"left join sub_components_options sco on sc.sub_component_id = sco.sub_component_id " +
					"left join options op on sco.option_id = op.option_id " +
					"where uc.user_form_id = "+ userFormID +"and position_id in(4)");

			while( rs.next() ){
				this.legendThree = rs.getString("component_name");
			}

			
			
			

		}catch(Exception e){
			e.printStackTrace();
		}
	}




	public List<AnalyticsList> getBlockOneReports() {
		return blockOneReportData;
	}

	public List<AnalyticsList> getBlockTwoReports() {
		return blockTwoReportData;
	}

	public List<AnalyticsList> getBlockThreeReports() {
		return blockThreeReportData;
	}

	public List<AnalyticsList> getBlockFourZeroReports() {
		return blockFourZeroReportData;
	}

	public List<AnalyticsList> getBlockFourOneReports() {
		return blockFourOneReportData;
	}



	public String getBlockOneTitle() {
		return blockOneTitle;
	}



	public void setBlockOneTitle(String blockOneTitle) {
		this.blockOneTitle = blockOneTitle;
	}



	public String getBlockTwoTitle() {
		return blockTwoTitle;
	}



	public void setBlockTwoTitle(String blockTwoTitle) {
		this.blockTwoTitle = blockTwoTitle;
	}



	public String getBlockThreeTitle() {
		return blockThreeTitle;
	}



	public void setBlockThreeTitle(String blockThreeTitle) {
		this.blockThreeTitle = blockThreeTitle;
	}



	public String getBlockFourZeroTitle() {
		return blockFourZeroTitle;
	}



	public void setBlockFourZeroTitle(String blockFourZeroTitle) {
		this.blockFourZeroTitle = blockFourZeroTitle;
	}



	public String getBlockFourOneTitle() {
		return blockFourOneTitle;
	}



	public void setBlockFourOneTitle(String blockFourOneTitle) {
		this.blockFourOneTitle = blockFourOneTitle;
	}



	public Integer getUserID() {
		return userID;
	}



	public void setUserID(Integer userID) {
		this.userID = userID;
	}


	public String getTotalSubmissions() {
		return totalSubmissions;
	}


	public void setTotalSubmissions(String totalSubmissions) {
		this.totalSubmissions = totalSubmissions;
	}


	public String getPeriodValue() {
		return periodValue;
	}


	public void setPeriodValue(String periodValue) {
		this.periodValue = periodValue;
	}




	public String getLegendOne() {
		return legendOne;
	}




	public void setLegendOne(String legendOne) {
		this.legendOne = legendOne;
	}




	public String getLegendTwo() {
		return legendTwo;
	}




	public void setLegendTwo(String legendTwo) {
		this.legendTwo = legendTwo;
	}




	public String getLegendThree() {
		return legendThree;
	}




	public void setLegendThree(String legendThree) {
		this.legendThree = legendThree;
	}





}
