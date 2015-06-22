package com.servicesform;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.innoppl.dbconnect.SingleConnect;

public class ServiceMileageDescriptionInventory {

	private SingleConnect singleConnect = new SingleConnect();
	private String title;
	private String[] item = new String[125];
	private String[] mainBlockPackageTitleData = new String[25];
	private String[] mainBlockOneData = new String[25];
	private String[] blockOneData = new String[25];
	private String[] mainBlockTwoData = new String[25];
	private String[] blockTwoData = new String[25];
	private String[] mainBlockThreeData = new String[25];
	private String[] blockThreeData = new String[25];
	private String[] mainBlockFourData = new String[25];
	private String[] blockFourData = new String[25];
	private String[] mainBlockFiveData = new String[25];
	private String[] blockFiveData = new String[25];
	private String[] mainBlockSixData = new String[25];
	private String[] blockSixData = new String[25];
	private String[] mainBlockSevenData = new String[25];
	private String[] blockSevenData = new String[25];
	private String[] mainBlockEightData = new String[25];
	private String[] blockEightData = new String[25];
	private String[] mainBlockNineData = new String[25];
	private String[] blockNineData = new String[25];
	private Integer serviceID = 0;

	public Integer getServiceID() {
		return serviceID;
	}

	public void setServiceID(Integer serviceID) {
		this.serviceID = serviceID;
	}

	public ServiceMileageDescriptionInventory(int sessionServiceID) {
		 	Connection conn = null;
		 	conn = singleConnect.connectToDatabaseOrDie();
			this.setServiceID(sessionServiceID);

			int i =0, j=0, k=0, l=0;
			String[] optionArray = null;

			try{
				Statement st = conn.createStatement();
			    ResultSet rs = st.executeQuery("select service_content, service_position_id from services_block_components where user_service_id ="+ this.getServiceID() +" order by service_position_id");
			    i = 0;
			    while( rs.next() ){
			    	this.item[i] =  rs.getString("service_content");
			    	i++;		
			    }
			    
			    rs = st.executeQuery("select service_content, service_position_id from services_block_components where user_service_id ="+ this.getServiceID() +" and (service_position_id >=301 and service_position_id <= 303) order by service_position_id");
				i=0;
				while (rs.next()){
					this.mainBlockPackageTitleData[i] = rs.getString("service_content");
					i++;
				}
			    
				rs = st.executeQuery("select service_content, service_position_id from services_block_components where user_service_id ="+ this.getServiceID() +" and (service_position_id >=311 and service_position_id <= 313) order by service_position_id");
				i=0;
				while (rs.next()){
					this.mainBlockOneData[i] = rs.getString("service_content");
					i++;
				}
				
				for(j=0;j<mainBlockOneData.length;j++){
					switch(j){
					case 0:
						this.blockOneData[0] =	this.mainBlockOneData[0];
						break;
					case 1:
						optionArray = null;
			    		optionArray = this.mainBlockOneData[1].toString().split("\\^");
			    		if(isEmptyOrWhitespace(optionArray[0])){
							optionArray[0] = null;
						}
				    	for (k = 0, l=1; k < optionArray.length; k ++,l++){
				    		this.blockOneData[l] = optionArray[k];
				    	}
				    	break;
					case 2:
						this.blockOneData[19] =	this.mainBlockOneData[2];
						break;
					}
				}
				
				rs = st.executeQuery("select service_content, service_position_id from services_block_components where user_service_id ="+ this.getServiceID() +" and (service_position_id >=321 and service_position_id <= 323) order by service_position_id");
				i=0;
				while (rs.next()){
					this.mainBlockTwoData[i] = rs.getString("service_content");
					i++;
				}
				
				for(j=0;j<mainBlockTwoData.length;j++){
					switch(j){
					case 0:
						this.blockTwoData[0] =	this.mainBlockTwoData[0];
						break;
					case 1:
						optionArray = null;
			    		optionArray = this.mainBlockTwoData[1].toString().split("\\^");
			    		if(isEmptyOrWhitespace(optionArray[0])){
							optionArray[0] = null;
						}
			    		for (k = 0, l=1; k < optionArray.length; k ++,l++){
			    			this.blockTwoData[l] = optionArray[k];
				    	}
				    	break;
					case 2:
						this.blockTwoData[19] =	this.mainBlockTwoData[2];
						break;
					}
				}
				
				rs = st.executeQuery("select service_content, service_position_id from services_block_components where user_service_id ="+ this.getServiceID() +" and (service_position_id >=331 and service_position_id <= 333) order by service_position_id");
				i=0;
				while (rs.next()){
					this.mainBlockThreeData[i] = rs.getString("service_content");
					i++;
				}
				
				for(j=0;j<mainBlockThreeData.length;j++){
					switch(j){
					case 0:
						this.blockThreeData[0] =	this.mainBlockThreeData[0];
						break;
					case 1:
						optionArray = null;
			    		optionArray = this.mainBlockThreeData[1].toString().split("\\^");
			    		if(isEmptyOrWhitespace(optionArray[0])){
							optionArray[0] = null;
						}
			    		for (k = 0, l=1; k < optionArray.length; k ++,l++){
			    			this.blockThreeData[l] = optionArray[k];
				    	}
				    	break;
					case 2:
						this.blockThreeData[19] =	this.mainBlockThreeData[2];
						break;	
					}
				}
				
				rs = st.executeQuery("select service_content, service_position_id from services_block_components where user_service_id ="+ this.getServiceID() +" and (service_position_id >=341 and service_position_id <= 343) order by service_position_id");
				i=0;
				while (rs.next()){
					this.mainBlockFourData[i] = rs.getString("service_content");
					i++;
				}
				
				for(j=0;j<mainBlockFourData.length;j++){
					switch(j){
					case 0:
						this.blockFourData[0] =	this.mainBlockFourData[0];
						break;
					case 1:
						optionArray = null;
			    		optionArray = this.mainBlockFourData[1].toString().split("\\^");
			    		if(isEmptyOrWhitespace(optionArray[0])){
							optionArray[0] = null;
						}
				    	for (k = 0,l=1; k < optionArray.length; k ++,l++){
				    		this.blockFourData[l] = optionArray[k];
				    	}
				    	break;
					case 2:
						this.blockFourData[19] =	this.mainBlockFourData[2];
						break;	
					}
				}
				
				rs = st.executeQuery("select service_content, service_position_id from services_block_components where user_service_id ="+ this.getServiceID() +" and (service_position_id >=351 and service_position_id <= 353) order by service_position_id");
				i=0;
				while (rs.next()){
					this.mainBlockFiveData[i] = rs.getString("service_content");
					i++;
				}
				
				for(j=0;j<mainBlockFiveData.length;j++){
					switch(j){
					case 0:
						this.blockFiveData[0] =	this.mainBlockFiveData[0];
						break;
					case 1:
						optionArray = null;
			    		optionArray = this.mainBlockFiveData[1].toString().split("\\^");
			    		if(isEmptyOrWhitespace(optionArray[0])){
							optionArray[0] = null;
						}
			    		for (k = 0,l=1; k < optionArray.length; k ++,l++){
				    		this.blockFiveData[l] = optionArray[k];
				    	}
				    	break;
					case 2:
						this.blockFiveData[19] =	this.mainBlockFiveData[2];
						break;	
					}
				}
				
				rs = st.executeQuery("select service_content, service_position_id from services_block_components where user_service_id ="+ this.getServiceID() +" and (service_position_id >=361 and service_position_id <= 363) order by service_position_id");
				i=0;
				while (rs.next()){
					this.mainBlockSixData[i] = rs.getString("service_content");
					i++;
				}
				
				for(j=0;j<mainBlockSixData.length;j++){
					switch(j){
					case 0:
						this.blockSixData[0] =	this.mainBlockSixData[0];
						break;
					case 1:
						optionArray = null;
			    		optionArray = this.mainBlockSixData[1].toString().split("\\^");
			    		if(isEmptyOrWhitespace(optionArray[0])){
							optionArray[0] = null;
						}
			    		for (k = 0,l=1; k < optionArray.length; k ++,l++){
				    		this.blockSixData[l] = optionArray[k];
				    	}
				    	break;
					case 2:
						this.blockSixData[19] =	this.mainBlockSixData[2];
						break;
					}
				}
				
				rs = st.executeQuery("select service_content, service_position_id from services_block_components where user_service_id ="+ this.getServiceID() +" and (service_position_id >=371 and service_position_id <= 373) order by service_position_id");
				i=0;
				while (rs.next()){
					this.mainBlockSevenData[i] = rs.getString("service_content");
					i++;
				}
				
				for(j=0;j<mainBlockSevenData.length;j++){
					switch(j){
					case 0:
						this.blockSevenData[0] =	this.mainBlockSevenData[0];
						break;
					case 1:
						optionArray = null;
			    		optionArray = this.mainBlockSevenData[1].toString().split("\\^");
			    		if(isEmptyOrWhitespace(optionArray[0])){
							optionArray[0] = null;
						}
			    		for (k = 0,l=1; k < optionArray.length; k ++,l++){
				    		this.blockSevenData[l] = optionArray[k];
				    	}
				    	break;
					case 2:
						this.blockSevenData[19] =	this.mainBlockSevenData[2];
						break;	
					}
				}
				
				rs = st.executeQuery("select service_content, service_position_id from services_block_components where user_service_id ="+ this.getServiceID() +" and (service_position_id >=381 and service_position_id <= 383) order by service_position_id");
				i=0;
				while (rs.next()){
					this.mainBlockEightData[i] = rs.getString("service_content");
					i++;
				}
				
				for(j=0;j<mainBlockEightData.length;j++){
					switch(j){
					case 0:
						this.blockEightData[0] =	this.mainBlockEightData[0];
						break;
					case 1:
						optionArray = null;
			    		optionArray = this.mainBlockEightData[1].toString().split("\\^");
			    		if(isEmptyOrWhitespace(optionArray[0])){
							optionArray[0] = null;
						}
			    		for (k = 0,l=1; k < optionArray.length; k ++,l++){
				    		this.blockEightData[l] = optionArray[k];
				    	}
				    	break;
					case 2:
						this.blockEightData[19] =	this.mainBlockEightData[2];
						break;	
					}
				}
				
				rs = st.executeQuery("select service_content, service_position_id from services_block_components where user_service_id ="+ this.getServiceID() +" and (service_position_id >=391 and service_position_id <= 393) order by service_position_id");
				i=0;
				while (rs.next()){
					this.mainBlockNineData[i] = rs.getString("service_content");
					i++;
				}
				
				for(j=0;j<mainBlockNineData.length;j++){
					switch(j){
					case 0:
						this.blockNineData[0] =	this.mainBlockNineData[0];
						break;
					case 1:
						optionArray = null;
			    		optionArray = this.mainBlockNineData[1].toString().split("\\^");
			    		if(isEmptyOrWhitespace(optionArray[0])){
							optionArray[0] = null;
						}
			    		for (k = 0,l=1; k < optionArray.length; k ++,l++){
				    		this.blockNineData[l] = optionArray[k];
				    	}
				    	break;
					case 2:
						this.blockNineData[19] =	this.mainBlockNineData[2];
						break;	
					}
				}
				
				
			}
			catch (Exception e) {
				e.printStackTrace();
			}
	        

	    }


	public void store(ServiceMileageDescriptionInventory serviceMileageDescriptionInventory){
		Connection conn = null;
		conn = singleConnect.connectToDatabaseOrDie();
		int i = 0;

		int[] blockPackageTitlePositions = new int[]{301, 302, 303};	
		int[] blockOnePositions = new int[]{311, 312, 313};
		int[] blockTwoPositions = new int[]{321, 322, 323};
		int[] blockThreePositions = new int[]{331, 332, 333};
		int[] blockFourPositions = new int[]{341, 342, 343};
		int[] blockFivePositions = new int[]{351, 352, 353};
		int[] blockSixPositions = new int[]{361, 362, 363};
		int[] blockSevenPositions = new int[]{371, 372, 373};
		int[] blockEightPositions = new int[]{381, 382, 383};
		int[] blockNinePositions = new int[]{391, 392, 393};
		
		try{
			System.out.println(this.title);
			System.out.println(this.mainBlockSevenData[1]);
			System.out.println(this.mainBlockEightData[1]);
			System.out.println(this.mainBlockNineData[1]);
			
			
			Statement st = conn.createStatement();
			Statement innerSt = conn.createStatement();
			ResultSet rs;
			

			for(i=0;i<blockPackageTitlePositions.length;i++){
				rs = st.executeQuery("select service_block_id from services_block_components where user_service_id =  "+ this.getServiceID() +
						" and service_position_id = "+blockPackageTitlePositions[i]);
				while ( rs.next() )
				{
					
					innerSt.execute("Update services_block_components set service_content='" + this.mainBlockPackageTitleData[i].replace("'", "''") +
							"' where service_block_id ="+ rs.getString("service_block_id") +"");
				}
			}
				
			for(i=0;i<blockOnePositions.length;i++){
				rs = st.executeQuery("select service_block_id from services_block_components where user_service_id =  "+ this.getServiceID() +
						" and service_position_id = "+blockOnePositions[i]);
				while ( rs.next() )
				{
					
					innerSt.execute("Update services_block_components set service_content='" + this.mainBlockOneData[i].replace("'", "''") +
							"' where service_block_id ="+ rs.getString("service_block_id") +"");
				}
			}
			
			for(i=0;i<blockTwoPositions.length;i++){
				rs = st.executeQuery("select service_block_id from services_block_components where user_service_id =  "+ this.getServiceID() +
						" and service_position_id = "+blockTwoPositions[i]);
				while ( rs.next() )
				{
					
					innerSt.execute("Update services_block_components set service_content='" + this.mainBlockTwoData[i].replace("'", "''") +
							"' where service_block_id ="+ rs.getString("service_block_id") +"");
				}
			}
			
			for(i=0;i<blockThreePositions.length;i++){
				rs = st.executeQuery("select service_block_id from services_block_components where user_service_id =  "+ this.getServiceID() +
						" and service_position_id = "+blockThreePositions[i]);
				while ( rs.next() )
				{
					
					innerSt.execute("Update services_block_components set service_content='" + this.mainBlockThreeData[i].replace("'", "''") +
							"' where service_block_id ="+ rs.getString("service_block_id") +"");
				}
			}
			
			for(i=0;i<blockFourPositions.length;i++){
				rs = st.executeQuery("select service_block_id from services_block_components where user_service_id =  "+ this.getServiceID() +
						" and service_position_id = "+blockFourPositions[i]);
				while ( rs.next() )
				{
					
					innerSt.execute("Update services_block_components set service_content='" + this.mainBlockFourData[i].replace("'", "''") +
							"' where service_block_id ="+ rs.getString("service_block_id") +"");
				}
			}
			
			for(i=0;i<blockFivePositions.length;i++){
				rs = st.executeQuery("select service_block_id from services_block_components where user_service_id =  "+ this.getServiceID() +
						" and service_position_id = "+blockFivePositions[i]);
				while ( rs.next() )
				{
					
					innerSt.execute("Update services_block_components set service_content='" + this.mainBlockFiveData[i].replace("'", "''") +
							"' where service_block_id ="+ rs.getString("service_block_id") +"");
				}
			}
			
			for(i=0;i<blockSixPositions.length;i++){
				rs = st.executeQuery("select service_block_id from services_block_components where user_service_id =  "+ this.getServiceID() +
						" and service_position_id = "+blockSixPositions[i]);
				while ( rs.next() )
				{
					
					innerSt.execute("Update services_block_components set service_content='" + this.mainBlockSixData[i].replace("'", "''") +
							"' where service_block_id ="+ rs.getString("service_block_id") +"");
				}
			}
			

			for(i=0;i<blockSevenPositions.length;i++){
				rs = st.executeQuery("select service_block_id from services_block_components where user_service_id =  "+ this.getServiceID() +
						" and service_position_id = "+blockSevenPositions[i]);
				while ( rs.next() )
				{
					
					innerSt.execute("Update services_block_components set service_content='" + this.mainBlockSevenData[i].replace("'", "''") +
							"' where service_block_id ="+ rs.getString("service_block_id") +"");
				}
			}
			

			for(i=0;i<blockEightPositions.length;i++){
				rs = st.executeQuery("select service_block_id from services_block_components where user_service_id =  "+ this.getServiceID() +
						" and service_position_id = "+blockEightPositions[i]);
				while ( rs.next() )
				{
					
					innerSt.execute("Update services_block_components set service_content='" + this.mainBlockEightData[i].replace("'", "''") +
							"' where service_block_id ="+ rs.getString("service_block_id") +"");
				}
			}
			

			for(i=0;i<blockNinePositions.length;i++){
				rs = st.executeQuery("select service_block_id from services_block_components where user_service_id =  "+ this.getServiceID() +
						" and service_position_id = "+blockNinePositions[i]);
				while ( rs.next() )
				{
					
					innerSt.execute("Update services_block_components set service_content='" + this.mainBlockNineData[i].replace("'", "''") +
							"' where service_block_id ="+ rs.getString("service_block_id") +"");
				}
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("In Model: Stored");
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

	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}

	

	public String[] getItem() {
		return item;
	}


	public void setItem(String[] item) {
		this.item = item;
	}


	public String[] getBlockOneData() {
		return blockOneData;
	}


	public void setBlockOneData(String[] blockOneData) {
		this.blockOneData = blockOneData;
	}


	public String[] getMainBlockOneData() {
		return mainBlockOneData;
	}


	public void setMainBlockOneData(String[] mainBlockOneData) {
		this.mainBlockOneData = mainBlockOneData;
	}


	public String[] getMainBlockTwoData() {
		return mainBlockTwoData;
	}


	public void setMainBlockTwoData(String[] mainBlockTwoData) {
		this.mainBlockTwoData = mainBlockTwoData;
	}


	public String[] getBlockTwoData() {
		return blockTwoData;
	}


	public void setBlockTwoData(String[] blockTwoData) {
		this.blockTwoData = blockTwoData;
	}


	public String[] getMainBlockThreeData() {
		return mainBlockThreeData;
	}


	public void setMainBlockThreeData(String[] mainBlockThreeData) {
		this.mainBlockThreeData = mainBlockThreeData;
	}


	public String[] getBlockThreeData() {
		return blockThreeData;
	}


	public void setBlockThreeData(String[] blockThreeData) {
		this.blockThreeData = blockThreeData;
	}


	public String[] getMainBlockFourData() {
		return mainBlockFourData;
	}


	public void setMainBlockFourData(String[] mainBlockFourData) {
		this.mainBlockFourData = mainBlockFourData;
	}


	public String[] getBlockFourData() {
		return blockFourData;
	}


	public void setBlockFourData(String[] blockFourData) {
		this.blockFourData = blockFourData;
	}


	public String[] getMainBlockFiveData() {
		return mainBlockFiveData;
	}


	public void setMainBlockFiveData(String[] mainBlockFiveData) {
		this.mainBlockFiveData = mainBlockFiveData;
	}


	public String[] getBlockFiveData() {
		return blockFiveData;
	}


	public void setBlockFiveData(String[] blockFiveData) {
		this.blockFiveData = blockFiveData;
	}


	public String[] getMainBlockSixData() {
		return mainBlockSixData;
	}


	public void setMainBlockSixData(String[] mainBlockSixData) {
		this.mainBlockSixData = mainBlockSixData;
	}


	public String[] getBlockSixData() {
		return blockSixData;
	}


	public void setBlockSixData(String[] blockSixData) {
		this.blockSixData = blockSixData;
	}


	public String[] getMainBlockPackageTitleData() {
		return mainBlockPackageTitleData;
	}


	public void setMainBlockPackageTitleData(String[] mainBlockPackageTitleData) {
		this.mainBlockPackageTitleData = mainBlockPackageTitleData;
	}


	public String[] getMainBlockSevenData() {
		return mainBlockSevenData;
	}


	public void setMainBlockSevenData(String[] mainBlockSevenData) {
		this.mainBlockSevenData = mainBlockSevenData;
	}


	public String[] getBlockSevenData() {
		return blockSevenData;
	}


	public void setBlockSevenData(String[] blockSevenData) {
		this.blockSevenData = blockSevenData;
	}


	public String[] getMainBlockEightData() {
		return mainBlockEightData;
	}


	public void setMainBlockEightData(String[] mainBlockEightData) {
		this.mainBlockEightData = mainBlockEightData;
	}


	public String[] getBlockEightData() {
		return blockEightData;
	}


	public void setBlockEightData(String[] blockEightData) {
		this.blockEightData = blockEightData;
	}


	public String[] getMainBlockNineData() {
		return mainBlockNineData;
	}


	public void setMainBlockNineData(String[] mainBlockNineData) {
		this.mainBlockNineData = mainBlockNineData;
	}


	public String[] getBlockNineData() {
		return blockNineData;
	}


	public void setBlockNineData(String[] blockNineData) {
		this.blockNineData = blockNineData;
	}

	
}