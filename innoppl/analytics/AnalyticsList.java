package com.innoppl.analytics;

public class AnalyticsList {


	private String componentName; 
	
	private Integer positionID, okLabel, maybeLabel, attentionLabel;

		public AnalyticsList(Integer positionID, String componentName, Integer okLabel, Integer maybeLabel, Integer attentionLabel) {
			this.setComponentName(componentName);
			this.setOkLabel(okLabel);
			this.setMaybeLabel(maybeLabel);
			this.setAttentionLabel(attentionLabel);
			this.setPositionID(positionID);
		}

		public String getComponentName() {
			return componentName;
		}

		public void setComponentName(String componentName) {
			this.componentName = componentName;
		}

		public Integer getPositionID() {
			return positionID;
		}

		public void setPositionID(Integer positionID) {
			this.positionID = positionID;
		}

		public Integer getOkLabel() {
			return okLabel;
		}

		public void setOkLabel(Integer okLabel) {
			this.okLabel = okLabel;
		}

		public Integer getMaybeLabel() {
			return maybeLabel;
		}

		public void setMaybeLabel(Integer maybeLabel) {
			this.maybeLabel = maybeLabel;
		}

		public Integer getAttentionLabel() {
			return attentionLabel;
		}

		public void setAttentionLabel(Integer attentionLabel) {
			this.attentionLabel = attentionLabel;
		}
		
		
		
}
