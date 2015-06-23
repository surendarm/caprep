package com.innoppl;

GIT session my list eddited by Suren

public class MyList {

	private String customerName, mobileNo, formDate, formName, techName, vinNumber, makeVal, modelVal, tagNumber, timer;

	private Integer serial, submissionID;

		public MyList(Integer serial, String customerName, String mobileNo, String formDate, String formName, Integer submissionID, String techName, String vinNumber, String makeVal, String modelVal, String tagNumber, String timer) {
			this.customerName = customerName;
			this.mobileNo = mobileNo;
			this.formDate = formDate;
			this.serial = serial;
			this.setFormName(formName);
			this.setSubmissionID(submissionID);
			this.setTechName(techName);
			this.setVinNumber(vinNumber);
			this.setTagNumber(tagNumber);
			this.setMakeVal(makeVal);
			this.setModelVal(modelVal);
			this.setTimer(timer);
		}
		
		public Integer getSerial() {
			return serial;
		}

		public void setSerial(Integer serial) {
			this.serial = serial;
		}
		
		public String getCustomerName() {
			return customerName;
		}

		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}

		public String getMobileNo() {
			return mobileNo;
		}

		public void setMobileNo(String mobileNo) {
			this.mobileNo = mobileNo;
		}

		public String getFormDate() {
			return formDate;
		}

		public void setFormDate(String formDate) {
			this.formDate = formDate;
		}

		public String getFormName() {
			return formName;
		}

		public void setFormName(String formName) {
			this.formName = formName;
		}

		public Integer getSubmissionID() {
			return submissionID;
		}

		public void setSubmissionID(Integer submissionID) {
			this.submissionID = submissionID;
		}

		public String getTechName() {
			return techName;
		}

		public void setTechName(String techName) {
			this.techName = techName;
		}

		public String getVinNumber() {
			return vinNumber;
		}

		public void setVinNumber(String vinNumber) {
			this.vinNumber = vinNumber;
		}

		public String getModelVal() {
			return modelVal;
		}

		public void setModelVal(String modelVal) {
			this.modelVal = modelVal;
		}

		public String getMakeVal() {
			return makeVal;
		}

		public void setMakeVal(String makeVal) {
			this.makeVal = makeVal;
		}

		public String getTagNumber() {
			return tagNumber;
		}

		public void setTagNumber(String tagNumber) {
			this.tagNumber = tagNumber;
		}

		public String getTimer() {
			return timer;
		}

		public void setTimer(String timer) {
			this.timer = timer;
		}
		
}
