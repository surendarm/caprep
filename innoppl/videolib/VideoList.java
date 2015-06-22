package com.innoppl.videolib;

public class VideoList {

	private String videoTitle, videoURL, videoDesc;

	private Integer videoID;

		public VideoList(Integer videoID, String videoTitle, String videoURL, String videoDesc) {
			this.setVideoID(videoID);
			this.setVideoTitle(videoTitle);
			this.setVideoURL(videoURL);
			this.setVideoDesc(videoDesc);
			
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

		public String getVideoDesc() {
			return videoDesc;
		}

		public void setVideoDesc(String videoDesc) {
			this.videoDesc = videoDesc;
		}

		public Integer getVideoID() {
			return videoID;
		}

		public void setVideoID(Integer videoID) {
			this.videoID = videoID;
		}
				
}
