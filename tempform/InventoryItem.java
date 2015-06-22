package com.tempform;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.innoppl.dbconnect.SingleConnect;

public class InventoryItem {

	private SingleConnect singleConnect = new SingleConnect();
	private String title;
	private String[] item = new String[125];
	private String[] itemLabel = new String[125];
	private String[] itemDesc1 = new String[125];
	private String[] itemDesc2 = new String[125];
	private String[] itemDesc3 = new String[125];
	private String[] itemStatus = new String[125];
	private Integer[] itemStatusId = new Integer[125];
	private Integer userID = 0;
	
	public Integer getUserID() {
		return userID;
	}


	public void setUserID(Integer userID) {
		this.userID = userID;
	}


	public InventoryItem(int currentUserID) {
		 	Connection conn = null;
		 	conn = singleConnect.connectToDatabaseOrDie();
			this.setUserID(currentUserID);
			int formID = 0, i = 0;
			String []optionArray;
			
			try{
				Statement st = conn.createStatement();
			    ResultSet rs;
			    rs = st.executeQuery("select * from user_forms where (form_name = '101 Form' or form_name = '101 Form 1' or form_name = '101 Form 2') and user_id = "+this.getUserID());
			    while( rs.next() ){
			    	formID = rs.getInt("user_form_id");
			    	System.out.println("Form ID: " + formID);
			    }
			    System.out.println(formID); 
			    rs = st.executeQuery("select distinct(c.component_id), c.component_name, sc.label, op.option_description, op.options_name, uc.status_id, uc.position_id from components c left join user_forms_components uc on c.component_id = uc.component_id left join sub_components sc on c.component_id = sc.component_id left join sub_components_options sco on sc.sub_component_id = sco.sub_component_id left join options op on sco.option_id = op.option_id where uc.user_form_id = "+ formID +" order by uc.position_id");
			    i = 0;
			    while( rs.next() ){
			    	this.title = rs.getString("component_name");
			    	this.item[i] =  rs.getString("component_name");
			    	this.itemLabel[i] = rs.getString("label");
			    	this.itemStatus[i] = rs.getString("status_id");
			    	this.itemStatusId[i] = rs.getInt("status_id");
			    	if(rs.getString("status_id").equalsIgnoreCase("1")){
			    		this.itemStatus[i] = "false";
			    	}else{
			    		this.itemStatus[i] = "true";
			    	}
			    	optionArray = null;
		    		optionArray = rs.getString("option_description").toString().split("\\^");
		    		if(isEmptyOrWhitespace(optionArray[0])){
						optionArray[0] = null;
					}
			    	for (int j = 0; j < optionArray.length; j ++){
			    		switch(j){
			    			case 0:
			    				this.itemDesc1[i] = optionArray[0]; 
			    				break;
			    			case 1:
			    				this.itemDesc2[i] = optionArray[1];
			    				break;
			    			case 2:
			    				this.itemDesc3[i] = optionArray[2];
			    				break;
			    			default:
			    				break;
			    			}
			    	}
			    i++;		
			    }
			    
			}
			catch (Exception e) {
				e.printStackTrace();
			    }
	        

	    }


	public void store(InventoryItem inventoryItem){
		Connection conn = null;
		conn = singleConnect.connectToDatabaseOrDie();
		String tempDesc = "";
		int formID= 0; //id = 4259;
		
		int i = 0;
		int j = 0;
		try{
			System.out.println("test me 1010");	
			Statement st = conn.createStatement();
			Statement ust = conn.createStatement();
			ResultSet rs;
			rs = st.executeQuery("select * from user_forms where (form_name = '101 Form' or form_name = '101 Form 1' or form_name = '101 Form 2') and user_id = "+this.getUserID());
			    while( rs.next() ){
			    	formID = rs.getInt("user_form_id");
			    	System.out.println("Form ID: " + formID);
			    }
			for(i=0,j=1;i<23;i++,j++){
				
				System.out.println("i Value : " + i);
				System.out.println("j Value : " + j);
				System.out.println("------------");
				
				rs = st.executeQuery("select distinct(c.component_id) as componentId, op.option_id as optionId from components c left join user_forms_components uc on c.component_id = uc.component_id left join sub_components sc on c.component_id = sc.component_id left join sub_components_options sco on sc.sub_component_id = sco.sub_component_id left join options op on sco.option_id = op.option_id where uc.user_form_id = "+ formID +" and uc.position_id = "+j);
				while ( rs.next() )
				{	
					System.out.println("i Val : " + i);
					System.out.println("j Val : " + j);
					System.out.println("------------");
					tempDesc = "";
					/*
					System.out.println(rs.getString("componentId"));
					System.out.println(rs.getString("optionId"));
					System.out.println(this.item[i]);
					System.out.println(this.itemLabel[i]);
					System.out.println(this.itemDesc1[i]);
					System.out.println(this.itemDesc2[i]);
					System.out.println(this.itemDesc3[i]);
					*/
					if(isEmptyOrWhitespace(this.itemDesc1[i])){
						this.itemDesc1[i] = null;
					}else if(this.itemDesc1[i].length() > 0){
						tempDesc = this.itemDesc1[i];
					}
					if(isEmptyOrWhitespace(this.itemDesc1[i])){
						this.itemDesc2[i] = null;
					}else if(this.itemDesc2[i].length() > 0){
						tempDesc  = tempDesc + "^" + this.itemDesc2[i];
					}
					if(isEmptyOrWhitespace(this.itemDesc1[i])){
						this.itemDesc3[i] = null;
					}else if(this.itemDesc3[i].length() > 0){
						tempDesc  = tempDesc + "^" + this.itemDesc3[i];
					}

					
						
					ust.execute("Update components set component_name ='" + this.item[i] +
							"' where component_id ="+ rs.getString("componentId") +"");
					ust.execute("Update sub_components set label ='" + this.itemLabel[i] +
							"' where component_id ="+ rs.getString("componentId") +"");
					ust.execute("Update options set option_description ='" + tempDesc +
							"' where option_id ="+ rs.getString("optionId") +"");
					ust.execute("Update user_forms_components set status_id ='" + this.itemStatusId[i] +
							"' where component_id ="+ rs.getString("componentId") +"");
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		    }
		    
		System.out.println("In Model: Stored 00");
		
	}
	
	public static String makeSafe(String s) {
	    return (s == null) ? "" : s;
	  }
	
	public static boolean isEmptyOrWhitespace(String s) {
	    s = makeSafe(s);
	    for (int i = 0, n = s.length(); i < n; i++) {
	      if (!Character.isWhitespace(s.charAt(i))) {
	        return false;
	      }
	    }
	    return true;
	  }
	/**
	private Connection connectToDatabaseOrDie()
	  {
	    Connection conn = null;
	    try
	    {
	      Class.forName("org.postgresql.Driver");
	      //String url = "jdbc:postgresql://127.0.0.1:5432/devassist";
	      //conn = DriverManager.getConnection(url,"postgres", "te$ts3rv650");
	      String url = "jdbc:postgresql://127.0.0.1:5432/citrus";
	      conn = DriverManager.getConnection(url,"postgres", "psqlpass");
	    }
	    catch (ClassNotFoundException e)
	    {
	      e.printStackTrace();
	      System.exit(1);
	    }
	    catch (SQLException e)
	    {
	      e.printStackTrace();
	      System.exit(2);
	    }
	    return conn;
	  }
	**/
	 
	public String getTitle(){
		return title;
	}

	public void setTitle(String title){
		this.title = title;
	}
	

	public String[] getItem() {
		return item;
	}


	public void setItem(String[] item) {
		this.item = item;
	}


	public String[] getItemLabel() {
		return itemLabel;
	}


	public void setItemLabel(String[] itemLabel) {
		this.itemLabel = itemLabel;
	}


	public String[] getItemDesc1() {
		return itemDesc1;
	}


	public void setItemDesc1(String[] itemDesc1) {
		this.itemDesc1 = itemDesc1;
	}


	public String[] getItemDesc2() {
		return itemDesc2;
	}


	public void setItemDesc2(String[] itemDesc2) {
		this.itemDesc2 = itemDesc2;
	}


	public String[] getItemDesc3() {
		return itemDesc3;
	}


	public void setItemDesc3(String[] itemDesc3) {
		this.itemDesc3 = itemDesc3;
	}


	public String[] getItemStatus() {
		return itemStatus;
	}


	public void setItemStatus(String[] itemStatus) {
		this.itemStatus = itemStatus;
	}


	public Integer[] getItemStatusId() {
		return itemStatusId;
	}


	public void setItemStatusId(Integer[] itemStatusId) {
		this.itemStatusId = itemStatusId;
	}


	

	
}
