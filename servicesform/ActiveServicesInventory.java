package com.servicesform;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.innoppl.dbconnect.SingleConnect;

public class ActiveServicesInventory {

	private String[] item = new String[100];
	
	private Integer userID = 0;
	
	private SingleConnect singleConnect = new SingleConnect();
	
	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	
	public ActiveServicesInventory(int currentUserID) {
		Connection conn = null;
		conn = singleConnect.connectToDatabaseOrDie();
		this.setUserID(currentUserID);
		//int userID = 50428;
		int i;

		for(i=0;i<8;i++)
			item[i] = "false";
		
		try{
			Statement st = conn.createStatement();
		    ResultSet rs = st.executeQuery("select * from user_services where user_id = "+ this.getUserID() +" order by service_id");
		    
		    while( rs.next() ){
		    	
		    	this.item[rs.getInt("service_id")] = rs.getString("service_active");
		    }
		    
		}
		catch (Exception e) {
		      e.printStackTrace();
		    }
        
		
	}
	
	/*
	public void store(ServicesInventory servicesInventory){
		Connection conn = null;
		conn = connectToDatabaseOrDie();
		int i = 0, j =0, count =0;
		int userID = 50428;

		try{
			Statement st = conn.createStatement();
			ResultSet rs;
			for(i=0,j=1;i<8;i++,j++){
				System.out.println(item[i]);
				rs = st.executeQuery("select * from user_services where user_id =" + userID + " and service_id ="+j);
				count = 0;
				while(rs.next()){
					count++;
				}
				if(count > 0){
					st.execute("update user_services set service_active = '"+item[i]+"' where user_id = "+ userID +" and service_id =" +j);
				}else{
					st.execute("insert into user_services(user_id, service_id, service_active) values ("+ userID +", "+ j +", '"+ item[i] +"')");
				}
			}
		    
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	*/
	/*
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
	public String[] getItem() {
		return item;
	}

	public void setItem(String[] item) {
		this.item = item;
	}
	

}
