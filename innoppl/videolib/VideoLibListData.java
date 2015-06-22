package com.innoppl.videolib;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;

import com.innoppl.dbconnect.SingleConnect;

public class VideoLibListData {

	private SingleConnect singleConnect = new SingleConnect();	
	private List<VideoList> submissionData = new ArrayList<VideoList>();
	private Integer userID=0;
	
	public VideoLibListData(){
		Session sess = Sessions.getCurrent();
		this.setUserID((Integer) sess.getAttribute("assist_user_id"));
		Connection conn = null;
		conn = singleConnect.connectToDatabaseOrDie();
		String videoTitle="";
		String videoURL=""; 
		String videoDesc="";
		int videoID = 0;
		System.out.println(this.getUserID());
		try{
			Statement st = conn.createStatement();
		    ResultSet rs;

		    rs = st.executeQuery("select * from video_library order by video_library_id");
		    
		    while( rs.next() ){
		    	
		    	videoID = rs.getInt("video_library_id");
		    	videoTitle = rs.getString("video_title");
		    	videoURL = rs.getString("video_source");
		    	videoDesc = rs.getString("video_description");

				submissionData.add(new VideoList(videoID, videoTitle, videoURL, videoDesc));
		    	
		    }
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public List<VideoList> getSubmissionReports() {
		return submissionData;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	

}
