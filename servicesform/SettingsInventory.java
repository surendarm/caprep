package com.servicesform;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.innoppl.dbconnect.SingleConnect;

public class SettingsInventory {

	private SingleConnect singleConnect = new SingleConnect();
	private String headerImageOne = "", headerImageOneTemp1, headerImageOneTemp2;
	private String headerImageTwo = "", headerImageTwoTemp1, headerImageTwoTemp2;
	private String headerImageThree = "", headerImageThreeTemp1, headerImageThreeTemp2;
	private String franchiseeImage= "", franchiseeImageTemp1, franchiseeImageTemp2;
	
	private Integer userID = 0;
	
	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	
	public SettingsInventory(int currentUserID) {
	 	Connection conn = null;
	 	conn = singleConnect.connectToDatabaseOrDie();
		this.setUserID(currentUserID);
		System.out.println(this.getUserID());
		
		try{
			Statement st = conn.createStatement();
		    ResultSet rs;
		    rs = st.executeQuery("select * from user_settings_image where image_type='headerimageone' and user_id = "+this.getUserID());
		    while( rs.next() ){
		    	this.headerImageOne =  rs.getString("image_file_name");
		    }
		    if(!this.headerImageOne.equals("")){	
				this.headerImageOneTemp1 =	this.headerImageOne;
				this.headerImageOneTemp2 =	this.headerImageOne;
			}else{
				this.headerImageOneTemp1 =	this.headerImageOne;
				this.headerImageOneTemp2 =	"blank.png";
			}
		    
		    
		    rs = st.executeQuery("select * from user_settings_image where image_type='headerimagetwo' and user_id = "+this.getUserID());
		    while( rs.next() ){
		    	headerImageTwo =  rs.getString("image_file_name");
		    }
		    if(!this.headerImageTwo.equals("")){	
				this.headerImageTwoTemp1 =	this.headerImageTwo;
				this.headerImageTwoTemp2 =	this.headerImageTwo;
			}else{
				this.headerImageTwoTemp1 =	this.headerImageTwo;
				this.headerImageTwoTemp2 =	"blank.png";
			}
		    
		    rs = st.executeQuery("select * from user_settings_image where image_type='headerimagethree' and user_id = "+this.getUserID());
		    while( rs.next() ){
		    	headerImageThree =  rs.getString("image_file_name");
		    }
	    	if(!this.headerImageTwo.equals("")){	
					this.headerImageThreeTemp1 =	this.headerImageThree;
					this.headerImageThreeTemp2 =	this.headerImageThree;
				}else{
					this.headerImageThreeTemp1 =	this.headerImageThree;
					this.headerImageThreeTemp2 =	"blank.png";
				}
	    	
		    rs = st.executeQuery("select * from user_settings_image where image_type='franchiseeimage' and user_id = "+this.getUserID());
		    while( rs.next() ){
		    	franchiseeImage =  rs.getString("image_file_name");
		    }
		    if(!this.franchiseeImage.equals("")){	
				this.franchiseeImageTemp1 =	this.franchiseeImage;
				this.franchiseeImageTemp2 =	this.franchiseeImage;
			}else{
				this.franchiseeImageTemp1 =	this.franchiseeImage;
				this.franchiseeImageTemp2 =	"blank.png";
			}
		    
		}catch (Exception e) {
			e.printStackTrace();	
	    }
	}
	
	public void store(SettingsInventory settingsInventory){
		Connection conn = null;
		conn = singleConnect.connectToDatabaseOrDie();
		
		
		System.out.println(this.headerImageOne);
		System.out.println(this.headerImageTwo);
		System.out.println(this.headerImageThree);
		System.out.println(this.franchiseeImage);
		
		try{
			
			Statement st = conn.createStatement();
			ResultSet rs;
		    
			rs = st.executeQuery("select * from user_settings_image where image_type='headerimageone' and user_id = "+this.getUserID());
		    if(rs.next()){
		    	st.execute("Update user_settings_image set image_file_name='" + this.headerImageOne.replace("'", "''") +
						"' where image_type ='headerimageone' and user_id = "+this.getUserID());
		    }else{
		    	st.execute("Insert into user_settings_image (user_id, image_type, image_file_name) VALUES ("+ this.getUserID() +",'headerimageone','"+ this.headerImageOne.replace("'", "''") +"')");
		    }
			
		    rs = st.executeQuery("select * from user_settings_image where image_type='headerimagetwo' and user_id = "+this.getUserID());
		    if( rs.next() ){
		    	st.execute("Update user_settings_image set image_file_name='" + this.headerImageTwo.replace("'", "''") +
						"' where image_type ='headerimagetwo' and user_id = "+this.getUserID());
		    	System.out.println("1");
		    }else{
		    	st.execute("Insert into user_settings_image (user_id, image_type, image_file_name) VALUES ("+ this.getUserID() +",'headerimagetwo','"+ this.headerImageTwo.replace("'", "''") +"')");
		    	System.out.println("2");
		    }
		    
		    rs = st.executeQuery("select * from user_settings_image where image_type='headerimagethree' and user_id = "+this.getUserID());
		    if( rs.next() ){
		    	st.execute("Update user_settings_image set image_file_name='" + this.headerImageThree.replace("'", "''") +
						"' where image_type ='headerimagethree' and user_id = "+this.getUserID());
		    }else{
		    	st.execute("Insert into user_settings_image (user_id, image_type, image_file_name) VALUES ("+ this.getUserID() +",'headerimagethree','"+ this.headerImageThree.replace("'", "''") +"')");
		    }
			
			
		    rs = st.executeQuery("select * from user_settings_image where image_type='franchiseeimage' and user_id = "+this.getUserID());
		    if(rs.next()){
		    	st.execute("Update user_settings_image set image_file_name='" + this.franchiseeImage.replace("'", "''") +
						"' where image_type ='franchiseeimage' and user_id = "+this.getUserID());
		    }else{
		    	st.execute("Insert into user_settings_image (user_id, image_type, image_file_name) VALUES ("+ this.getUserID() +",'franchiseeimage','"+ this.franchiseeImage.replace("'", "''") +"')");
		    }
			
			
		}catch  (Exception e) {
		      e.printStackTrace();
		    }	
	}
	
	public String getHeaderImageOne() {
		return headerImageOne;
	}
	public void setHeaderImageOne(String headerImageOne) {
		this.headerImageOne = headerImageOne;
	}
	public String getHeaderImageTwo() {
		return headerImageTwo;
	}
	public void setHeaderImageTwo(String headerImageTwo) {
		this.headerImageTwo = headerImageTwo;
	}
	public String getHeaderImageThree() {
		return headerImageThree;
	}
	public void setHeaderImageThree(String headerImageThree) {
		this.headerImageThree = headerImageThree;
	}
	public String getFranchiseeImage() {
		return franchiseeImage;
	}
	public void setFranchiseeImage(String franchiseeImage) {
		this.franchiseeImage = franchiseeImage;
	}

	public String getHeaderImageOneTemp1() {
		return headerImageOneTemp1;
	}

	public void setHeaderImageOneTemp1(String headerImageOneTemp1) {
		this.headerImageOneTemp1 = headerImageOneTemp1;
	}

	public String getHeaderImageOneTemp2() {
		return headerImageOneTemp2;
	}

	public void setHeaderImageOneTemp2(String headerImageOneTemp2) {
		this.headerImageOneTemp2 = headerImageOneTemp2;
	}

	public String getHeaderImageTwoTemp1() {
		return headerImageTwoTemp1;
	}

	public void setHeaderImageTwoTemp1(String headerImageTwoTemp1) {
		this.headerImageTwoTemp1 = headerImageTwoTemp1;
	}

	public String getHeaderImageTwoTemp2() {
		return headerImageTwoTemp2;
	}

	public void setHeaderImageTwoTemp2(String headerImageTwoTemp2) {
		this.headerImageTwoTemp2 = headerImageTwoTemp2;
	}

	public String getHeaderImageThreeTemp1() {
		return headerImageThreeTemp1;
	}

	public void setHeaderImageThreeTemp1(String headerImageThreeTemp1) {
		this.headerImageThreeTemp1 = headerImageThreeTemp1;
	}

	public String getHeaderImageThreeTemp2() {
		return headerImageThreeTemp2;
	}

	public void setHeaderImageThreeTemp2(String headerImageThreeTemp2) {
		this.headerImageThreeTemp2 = headerImageThreeTemp2;
	}

	public String getFranchiseeImageTemp1() {
		return franchiseeImageTemp1;
	}

	public void setFranchiseeImageTemp1(String franchiseeImageTemp1) {
		this.franchiseeImageTemp1 = franchiseeImageTemp1;
	}

	public String getFranchiseeImageTemp2() {
		return franchiseeImageTemp2;
	}

	public void setFranchiseeImageTemp2(String franchiseeImageTemp2) {
		this.franchiseeImageTemp2 = franchiseeImageTemp2;
	}
	
	
	
}
