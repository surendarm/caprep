package com.innoppl.videolib;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.innoppl.dbconnect.SingleConnect;

public class VideoLibEditInventory {
	
	private SingleConnect singleConnect = new SingleConnect();
	private String videoID = "";
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

	public VideoLibEditInventory(int currentUserID, String videoID) {
		Connection conn = null;
	 	conn = singleConnect.connectToDatabaseOrDie();
		this.setUserID(currentUserID);
	 	this.setVideoID(videoID);
		System.out.println(this.getUserID());
		System.out.println(this.getVideoID());
		
		try{
			Statement st = conn.createStatement();
		    ResultSet rs;
		    rs = st.executeQuery("select * from  video_library where video_library_id = "+this.getVideoID());
		    while( rs.next() ){
		    	this.setVideoURL(rs.getString("video_source"));
		    	this.setVideoTitle(rs.getString("video_title"));
		    	this.setVideoDescription(rs.getString("video_description"));
		    }
		}
		catch (Exception e) {
			e.printStackTrace();	
		    }
        
		
    }
	
	public void store(VideoLibEditInventory videoLibEditInventory){
		Connection conn = null;
		conn = singleConnect.connectToDatabaseOrDie();
		
		try{
			
			Statement st = conn.createStatement();
			System.out.println(this.getVideoTitle());
			System.out.println(this.getVideoURL());
			System.out.println(this.getVideoDescription());

			st.execute("Update video_library set video_title ='" + this.getVideoTitle().replace("'", "''") + "' where  video_library_id  ="+ this.getVideoID() +"");
			st.execute("Update video_library set video_source ='" + this.getVideoURL().replace("'", "''") + "' where  video_library_id  ="+ this.getVideoID() +"");
			st.execute("Update video_library set video_description ='" + this.getVideoDescription().replace("'", "''") + "' where  video_library_id  ="+ this.getVideoID() +"");
			
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

	public String getVideoID() {
		return videoID;
	}

	public void setVideoID(String videoID) {
		this.videoID = videoID;
	}
	
}
