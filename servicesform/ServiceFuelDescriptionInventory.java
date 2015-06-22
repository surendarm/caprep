package com.servicesform;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.innoppl.dbconnect.SingleConnect;



public class ServiceFuelDescriptionInventory {

	private SingleConnect singleConnect = new SingleConnect();
	private String title;
	private String[] item = new String[125];
	private String[] mainBlockOneData = new String[25];
	private String[] blockOneData = new String[25];
	private String[] mainBlockTwoData = new String[25];
	private String[] blockTwoData = new String[25];
	private String[] mainBlockFuelThreeData = new String[25];
	private String[] blockFuelThreeData = new String[25];
	private String[] mainBlockThreeData = new String[25];
	private String[] blockThreeData = new String[25];
	private String[] mainBlockFourData = new String[25];
	private String[] blockFourData = new String[25];
	private String[] mainBlockFiveData = new String[25];
	private String[] blockFiveData = new String[25];
	private String[] mainBlockSixData = new String[25];
	private String[] blockSixData = new String[25];
	private Integer serviceID = 0;

	public Integer getServiceID() {
		return serviceID;
	}

	public void setServiceID(Integer serviceID) {
		this.serviceID = serviceID;
	}
	
	 public ServiceFuelDescriptionInventory(int sessionServiceID) {
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
			    
				rs = st.executeQuery("select service_content, service_position_id from services_block_components where user_service_id ="+ this.getServiceID() +" and (service_position_id >=101 and service_position_id <= 103) order by service_position_id");
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
						if(!this.mainBlockOneData[2].equals("")){	
							this.blockOneData[19] =	this.mainBlockOneData[2];
							this.blockOneData[20] =	this.mainBlockOneData[2];
						}else{
							this.blockOneData[19] =	this.mainBlockOneData[2];
							this.blockOneData[20] =	"blank.png";
						}
						break;
					}
				}
				
				rs = st.executeQuery("select service_content, service_position_id from services_block_components where user_service_id ="+ this.getServiceID() +" and (service_position_id >=111 and service_position_id <= 113) order by service_position_id");
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
						if(!this.mainBlockTwoData[2].equals("")){	
							this.blockTwoData[19] =	this.mainBlockTwoData[2];
							this.blockTwoData[20] =	this.mainBlockTwoData[2];
						}else{
							this.blockTwoData[19] =	this.mainBlockTwoData[2];
							this.blockTwoData[20] =	"blank.png";
						}
						break;
					}
				}
				
				
				rs = st.executeQuery("select service_content, service_position_id from services_block_components where user_service_id ="+ this.getServiceID() +" and (service_position_id >=131 and service_position_id <= 133) order by service_position_id");
				i=0;
				while (rs.next()){
					this.mainBlockFuelThreeData[i] = rs.getString("service_content");
					i++;
				}
				
				for(j=0;j<mainBlockFuelThreeData.length;j++){
					switch(j){
					case 0:
						this.blockFuelThreeData[0] =	this.mainBlockFuelThreeData[0];
						break;
					case 1:
						optionArray = null;
			    		optionArray = this.mainBlockFuelThreeData[1].toString().split("\\^");
			    		if(isEmptyOrWhitespace(optionArray[0])){
							optionArray[0] = null;
						}
			    		for (k = 0, l=1; k < optionArray.length; k ++,l++){
			    			this.blockFuelThreeData[l] = optionArray[k];
				    	}
				    	break;
					case 2:
						if(!this.mainBlockFuelThreeData[2].equals("")){	
							this.blockFuelThreeData[19] =	this.mainBlockFuelThreeData[2];
							this.blockFuelThreeData[20] =	this.mainBlockFuelThreeData[2];
						}else{
							this.blockFuelThreeData[19] =	this.mainBlockFuelThreeData[2];
							this.blockFuelThreeData[20] =	"blank.png";
						}
						break;
					}
				}
				
				
				rs = st.executeQuery("select service_content, service_position_id from services_block_components where user_service_id ="+ this.getServiceID() +" and (service_position_id >=121 and service_position_id <= 122) order by service_position_id");
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
					}
				}
				
				rs = st.executeQuery("select service_content, service_position_id from services_block_components where user_service_id ="+ this.getServiceID() +" and (service_position_id >=201 and service_position_id <= 205) order by service_position_id");
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
						if(!this.mainBlockFourData[2].equals("")){	
							this.blockFourData[19] =	this.mainBlockFourData[2];
							this.blockFourData[22] =	this.mainBlockFourData[2];
						}else{
							this.blockFourData[19] =	this.mainBlockFourData[2];
							this.blockFourData[22] =	"blank.png";
						}
						break;
					case 3:
						this.blockFourData[20] =	this.mainBlockFourData[3];
						break;
					case 4:
						this.blockFourData[21] =	this.mainBlockFourData[4];
						break;	
					}
				}
				
				rs = st.executeQuery("select service_content, service_position_id from services_block_components where user_service_id ="+ this.getServiceID() +" and (service_position_id >=211 and service_position_id <= 215) order by service_position_id");
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
						if(!this.mainBlockFiveData[2].equals("")){	
							this.blockFiveData[19] =	this.mainBlockFiveData[2];
							this.blockFiveData[22] =	this.mainBlockFiveData[2];
						}else{
							this.blockFiveData[19] =	this.mainBlockFiveData[2];
							this.blockFiveData[22] =	"blank.png";
						}
						break;
					case 3:
						this.blockFiveData[20] =	this.mainBlockFiveData[3];
						break;
					case 4:
						this.blockFiveData[21] =	this.mainBlockFiveData[4];
						break;	
					}
				}
				
				rs = st.executeQuery("select service_content, service_position_id from services_block_components where user_service_id ="+ this.getServiceID() +" and (service_position_id >=221 and service_position_id <= 225) order by service_position_id");
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
						if(!this.mainBlockSixData[2].equals("")){	
							this.blockSixData[19] =	this.mainBlockSixData[2];
							this.blockSixData[22] =	this.mainBlockSixData[2];
						}else{
							this.blockSixData[19] =	this.mainBlockSixData[2];
							this.blockSixData[22] =	"blank.png";
						}
						break;
					case 3:
						this.blockSixData[20] =	this.mainBlockSixData[3];
						break;
					case 4:
						this.blockSixData[21] =	this.mainBlockSixData[4];
						break;	
					}
				}
				
				
			}
			catch (Exception e) {
				e.printStackTrace();
			}
	        

	    }


	public void store(ServiceFuelDescriptionInventory serviceFuelDescriptionInventory){
		Connection conn = null;
		conn = singleConnect.connectToDatabaseOrDie();
		int i = 0;

		int[] blockOnePositions = new int[]{101, 102, 103};
		int[] blockTwoPositions = new int[]{111, 112, 113};
		int[] blockFuelThreePositions = new int[]{131, 132, 133};
		int[] blockThreePositions = new int[]{121, 122};
		int[] blockFourPositions = new int[]{201, 202, 203, 204, 205};
		int[] blockFivePositions = new int[]{211, 212, 213, 214, 215};
		int[] blockSixPositions = new int[]{221, 222, 223, 224, 225};
		
		try{
			
			Statement st = conn.createStatement();
			Statement innerSt = conn.createStatement();
			ResultSet rs;
			
			for(i=0;i<blockOnePositions.length;i++){
				rs = st.executeQuery("select service_block_id from services_block_components where user_service_id =  "+ this.getServiceID() +
						" and service_position_id = "+blockOnePositions[i]);
				while ( rs.next() )
				{
					
					innerSt.execute("Update services_block_components set service_content='" + this.mainBlockOneData[i].replace("'", "''")  +
							"' where service_block_id ="+ rs.getString("service_block_id") +"");
				}
			}
			
			for(i=0;i<blockTwoPositions.length;i++){
				rs = st.executeQuery("select service_block_id from services_block_components where user_service_id =  "+ this.getServiceID() +
						" and service_position_id = "+blockTwoPositions[i]);
				while ( rs.next() )
				{
					
					innerSt.execute("Update services_block_components set service_content='" + this.mainBlockTwoData[i].replace("'", "''")  +
							"' where service_block_id ="+ rs.getString("service_block_id") +"");
				}
			}
			
			for(i=0;i<blockFuelThreePositions.length;i++){
				rs = st.executeQuery("select service_block_id from services_block_components where user_service_id =  "+ this.getServiceID() +
						" and service_position_id = "+blockFuelThreePositions[i]);
				while ( rs.next() )
				{
					
					innerSt.execute("Update services_block_components set service_content='" + this.mainBlockFuelThreeData[i].replace("'", "''")  +
							"' where service_block_id ="+ rs.getString("service_block_id") +"");
				}
			}
			
			for(i=0;i<blockThreePositions.length;i++){
				rs = st.executeQuery("select service_block_id from services_block_components where user_service_id =  "+ this.getServiceID() +
						" and service_position_id = "+blockThreePositions[i]);
				while ( rs.next() )
				{
					
					innerSt.execute("Update services_block_components set service_content='" + this.mainBlockThreeData[i].replace("'", "''")  +
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
					
					innerSt.execute("Update services_block_components set service_content='" + this.mainBlockFiveData[i].replace("'", "''")  +
							"' where service_block_id ="+ rs.getString("service_block_id") +"");
				}
			}
			
			for(i=0;i<blockSixPositions.length;i++){
				rs = st.executeQuery("select service_block_id from services_block_components where user_service_id =  "+ this.getServiceID() +
						" and service_position_id = "+blockSixPositions[i]);
				while ( rs.next() )
				{
					System.out.println(this.mainBlockSixData[i]);	
					innerSt.execute("Update services_block_components set service_content='" + this.mainBlockSixData[i].replace("'", "''")  +
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


	public String[] getMainBlockFuelThreeData() {
		return mainBlockFuelThreeData;
	}


	public void setMainBlockFuelThreeData(String[] mainBlockFuelThreeData) {
		this.mainBlockFuelThreeData = mainBlockFuelThreeData;
	}


	public String[] getBlockFuelThreeData() {
		return blockFuelThreeData;
	}


	public void setBlockFuelThreeData(String[] blockFuelThreeData) {
		this.blockFuelThreeData = blockFuelThreeData;
	}

	
}
