package com.innoppl.videolib;

git try


import java.sql.Connection;
import java.sql.Statement;

import com.innoppl.dbconnect.SingleConnect;

public class VideoLibAddInventory {
	
	private SingleConnect singleConnect = new SingleConnect();
	private String videoTitle = "";
	private String videoURL = "";
	private String videoDescription = "";

	private Integer userID = 0;
	
	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public VideoLibAddInventory(int currentUserID) {
	 	this.setUserID(currentUserID);
		System.out.println(this.getUserID());
    }
	
	public void store(VideoLibAddInventory videoLibAddInventory){
		Connection conn = null;
		conn = singleConnect.connectToDatabaseOrDie();
		
		try{
			
			Statement st = conn.createStatement();
			System.out.println(this.getVideoTitle());
			System.out.println(this.getVideoURL());
			System.out.println(this.getVideoDescription());
			
			st.execute("Insert into video_library (video_title, video_source, video_description) values"
					+ "('"+  this.getVideoTitle().replace("'", "''") +"','"+ this.getVideoURL().replace("'", "''") +"','"+ this.getVideoDescription().replace("'", "''") +"')");
			
		}
		catch (Exception e) {
		      e.printStackTrace();
		    }
		System.out.println("In Model: Stored");
	}
	

	public String getVideoTitle() {
		return videoTitle;
	}

	public void setVideoTitle(String videoTitle) {
		this.videoTitle = videoTitle;
	}

	public String getVideoURL() {
		return videoURL;
	}

	public void setVideoURL(String videoURL) {
		this.videoURL = videoURL;
	}

	public String getVideoDescription() {
		return videoDescription;
	}

	public void setVideoDescription(String videoDescription) {
		this.videoDescription = videoDescription;
	}

	
}
