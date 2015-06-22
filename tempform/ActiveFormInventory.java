package com.tempform;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.innoppl.dbconnect.SingleConnect;

public class ActiveFormInventory {
	
	private String[] item = new String[125];
	private String selectedItem = "";

	private Integer userID = 0;
	private SingleConnect singleConnect = new SingleConnect();
	
	public ActiveFormInventory(int currentUserID) {
	 	Connection conn = null;
	 	conn = singleConnect.connectToDatabaseOrDie();
		this.setUserID(currentUserID);
		String activeForm = "";
		
		try{
			Statement st = conn.createStatement();
		    ResultSet rs;
	
		    rs = st.executeQuery("select * from user_active_form where user_id ="+this.getUserID());
		    
		    while( rs.next() ){
		    	activeForm = rs.getString("form_name");
		    }
		    if(activeForm.equals("101 Form") || activeForm.equals("101 form")){
		    	this.item[0] = "true";
		    	this.item[1] = "false";
		    	this.item[2] = "false";
		    	this.item[3] = "false";
		    }else if(activeForm.equals("102 Form") || activeForm.equals("102 form")){
		    	this.item[0] = "false";
		    	this.item[1] = "true";
		    	this.item[2] = "false";
		    	this.item[3] = "false";
		    }else if(activeForm.equals("103 Form") || activeForm.equals("103 form")){
		    	this.item[0] = "false";
		    	this.item[1] = "false";
		    	this.item[2] = "true";
		    	this.item[3] = "false";
		    }else if(activeForm.equals("104 Form") || activeForm.equals("104 form")){
		    	this.item[0] = "false";
		    	this.item[1] = "false";
		    	this.item[2] = "false";
		    	this.item[3] = "true";
		    }else{
		    	this.item[0] = "false";
		    	this.item[1] = "false";
		    	this.item[2] = "false";
		    	this.item[3] = "false";
		    }
		}
		catch (Exception e) {
			e.printStackTrace();
		    }
    }
	
	public void store(ActiveFormInventory activeFormInventory){
		Connection conn = null;
		conn = singleConnect.connectToDatabaseOrDie();
		int formID = 0, size=0;
		
		try{
			Statement st = conn.createStatement();
			ResultSet rs;
			rs = st.executeQuery("select * from user_forms where user_id = "+ this.getUserID() +" and form_name ='"+this.selectedItem+"'");
			while(rs.next()){
				formID = rs.getInt("user_form_id");	
			}
			rs = st.executeQuery("select * from user_active_form where user_id ="+this.getUserID());
			while(rs.next()){
				size++;
			}
			if(size > 0){
				System.out.println("tst 1");
				st.execute("update user_active_form set form_name='"+this.selectedItem+"' where user_id = "+this.getUserID());
				st.execute("update user_active_form set user_form_id="+ formID +" where user_id = "+this.getUserID());
			}else{
				st.execute("INSERT INTO user_active_form(user_id, user_form_id, form_name) VALUES " +
							"("+ this.getUserID() +","+ formID +",'"+ this.selectedItem +"')");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		    }
		    
		System.out.println("In Model: Stored");
		
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
	
	*/
	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	
	public String[] getItem() {
		return item;
	}

	public void setItem(String[] item) {
		this.item = item;
	}

	public String getSelectedItem() {
		return selectedItem;
	}

	public void setSelectedItem(String selectedItem) {
		this.selectedItem = selectedItem;
	}

}
