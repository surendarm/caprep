package com.tempform;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.innoppl.dbconnect.SingleConnect;

public class ThreeInventoryItem {
	
	private SingleConnect singleConnect = new SingleConnect();
	private String title;
	private String[] item = new String[125];
	private String [] blockLegendData = new String[25];
	private String [] blockOneData = new String[25];
	private String [] blockTwoData = new String[25];
	private String [] blockThreeData = new String[25];
	private String [] blockFourZeroData = new String[25];
	private String [] blockFourOneData = new String[25];
	private String [] blockFourTwoData = new String[25];
	private String [] blockFourThreeData = new String[25];
	private String [] blockBatteryData = new String[25];
	private String [] blockImageData = new String[25];

	private Integer userID = 0;
	
	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public ThreeInventoryItem(int currentUserID) {
	 	Connection conn = null;
	 	conn = singleConnect.connectToDatabaseOrDie();
		this.setUserID(currentUserID);
		int formID = 0, i=0; //4441;
		
		try{
			Statement st = conn.createStatement();
		    ResultSet rs;
		    rs = st.executeQuery("select * from user_forms where  (form_name = '103 Form' or form_name = '103 Form 1' or form_name = '103 Form 2')  and user_id = "+this.getUserID());
		    while( rs.next() ){
		    	formID = rs.getInt("user_form_id");
		    }
		    
		    rs= st.executeQuery("select distinct(c.component_id), c.component_name, sc.label, op.option_description, op.options_name, uc.position_id from components c left join user_forms_components uc on c.component_id = uc.component_id left join sub_components sc on c.component_id = sc.component_id left join sub_components_options sco on sc.sub_component_id = sco.sub_component_id left join options op on sco.option_id = op.option_id where uc.user_form_id = "+ formID +" order by uc.position_id");
		    i = 0;
		    while( rs.next() ){
		    	this.item[i] =  rs.getString("component_name");
		    	i++;		
		    }
		    
		    rs = st.executeQuery("select distinct(c.component_id), c.component_name, uc.position_id from components c left join user_forms_components uc on c.component_id = uc.component_id left join sub_components sc on c.component_id = sc.component_id left join sub_components_options sco on sc.sub_component_id = sco.sub_component_id left join options op on sco.option_id = op.option_id where uc.user_form_id = "+ formID +" and uc.position_id in (2, 3, 4) order by uc.position_id");
			i=0;
			while (rs.next()){
				this.blockLegendData[i] = rs.getString("component_name");
				i++;
			}
		    
			rs = st.executeQuery("select distinct(c.component_id), c.component_name, uc.position_id from components c left join user_forms_components uc on c.component_id = uc.component_id left join sub_components sc on c.component_id = sc.component_id left join sub_components_options sco on sc.sub_component_id = sco.sub_component_id left join options op on sco.option_id = op.option_id where uc.user_form_id = "+ formID +" and (uc.position_id = 5 or uc.position_id >= 7 and uc.position_id <= 14) order by uc.position_id");
			i=0;
			while (rs.next()){
				this.blockOneData[i] = rs.getString("component_name");
				i++;
			}
			
			rs = st.executeQuery("select distinct(c.component_id), c.component_name, uc.position_id from components c left join user_forms_components uc on c.component_id = uc.component_id left join sub_components sc on c.component_id = sc.component_id left join sub_components_options sco on sc.sub_component_id = sco.sub_component_id left join options op on sco.option_id = op.option_id where uc.user_form_id = "+ formID +" and (uc.position_id >= 15 and uc.position_id <= 26) order by uc.position_id");
			i=0;
			while (rs.next()){
				this.blockTwoData[i] = rs.getString("component_name");
				i++;
			}
			
			rs = st.executeQuery("select distinct(c.component_id), c.component_name, uc.position_id from components c left join user_forms_components uc on c.component_id = uc.component_id left join sub_components sc on c.component_id = sc.component_id left join sub_components_options sco on sc.sub_component_id = sco.sub_component_id left join options op on sco.option_id = op.option_id where uc.user_form_id = "+ formID +" and (uc.position_id >= 30 and uc.position_id <= 38) order by uc.position_id");
			i=0;
			while (rs.next()){
				this.blockThreeData[i] = rs.getString("component_name");
				i++;
			}

			rs = st.executeQuery("select distinct(c.component_id), c.component_name, uc.position_id from components c left join user_forms_components uc on c.component_id = uc.component_id left join sub_components sc on c.component_id = sc.component_id left join sub_components_options sco on sc.sub_component_id = sco.sub_component_id left join options op on sco.option_id = op.option_id where uc.user_form_id = "+ formID +" and (uc.position_id >= 27 and uc.position_id <= 29) order by uc.position_id");
			i=0;
			while (rs.next()){
				this.blockBatteryData[i] = rs.getString("component_name");
				i++;
			}
			
			rs = st.executeQuery("select distinct(c.component_id), c.component_name, uc.position_id from components c left join user_forms_components uc on c.component_id = uc.component_id left join sub_components sc on c.component_id = sc.component_id left join sub_components_options sco on sc.sub_component_id = sco.sub_component_id left join options op on sco.option_id = op.option_id where uc.user_form_id = "+ formID +" and (uc.position_id >= 39 and uc.position_id <= 51) order by uc.position_id");
			i=0;
			while (rs.next()){
				this.blockFourZeroData[i] = rs.getString("component_name");
				i++;
			}
			
			rs = st.executeQuery("select distinct(c.component_id), c.component_name, uc.position_id from components c left join user_forms_components uc on c.component_id = uc.component_id left join sub_components sc on c.component_id = sc.component_id left join sub_components_options sco on sc.sub_component_id = sco.sub_component_id left join options op on sco.option_id = op.option_id where uc.user_form_id = "+ formID +" and (uc.position_id >= 52 and uc.position_id <= 56) order by uc.position_id");
			i=0;
			while (rs.next()){
				this.blockFourOneData[i] = rs.getString("component_name");
				i++;
			}
			
			rs = st.executeQuery("select distinct(c.component_id), c.component_name, uc.position_id from components c left join user_forms_components uc on c.component_id = uc.component_id left join sub_components sc on c.component_id = sc.component_id left join sub_components_options sco on sc.sub_component_id = sco.sub_component_id left join options op on sco.option_id = op.option_id where uc.user_form_id = "+ formID +" and (uc.position_id >= 57 and uc.position_id <= 64) order by uc.position_id");
			i=0;
			while (rs.next()){
				this.blockFourTwoData[i] = rs.getString("component_name");
				i++;
			}
			
			rs = st.executeQuery("select distinct(c.component_id), c.component_name, uc.position_id from components c left join user_forms_components uc on c.component_id = uc.component_id left join sub_components sc on c.component_id = sc.component_id left join sub_components_options sco on sc.sub_component_id = sco.sub_component_id left join options op on sco.option_id = op.option_id where uc.user_form_id = "+ formID +" and (uc.position_id >= 65 and uc.position_id <= 69) order by uc.position_id");
			i=0;
			while (rs.next()){
				this.blockFourThreeData[i] = rs.getString("component_name");
				i++;
			}

			rs = st.executeQuery("select distinct(c.component_id), c.component_name, uc.position_id from components c left join user_forms_components uc on c.component_id = uc.component_id left join sub_components sc on c.component_id = sc.component_id left join sub_components_options sco on sc.sub_component_id = sco.sub_component_id left join options op on sco.option_id = op.option_id where uc.user_form_id = "+ formID +" and (uc.position_id >= 71 and uc.position_id <= 72) order by uc.position_id");
			i=0;
			while (rs.next()){
				this.blockImageData[i] = rs.getString("component_name");
				System.out.println(rs.getString("component_name"));
				i++;
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();	
		    }
        

    }
	
	public void store(ThreeInventoryItem threeInventoryItem){
		Connection conn = null;
		conn = singleConnect.connectToDatabaseOrDie();
		int formID = 0; //4441;
		int i = 0;

		int[] blockLegendPositions = new int[]{2, 3, 4};
		int[] blockOnePositions = new int[]{5,7,8,9,10,11,12,13,14};
		int[] blockTwoPositions = new int[]{15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26};
		int[] blockThreePositions = new int[]{30, 31, 32, 33, 34, 35, 36, 37, 38};
		int[] blockFourZeroPositions = new int[]{39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51};
		int[] blockFourOnePositions = new int[]{52, 53, 54, 55, 56};
		int[] blockFourTwoPositions = new int[]{57, 58, 59, 60, 61, 62, 63, 64};
		int[] blockFourThreePositions = new int[]{65, 66, 67, 68, 69};
		int[] blockBatteryPositions = new int[]{27, 28, 29};
		int[] blockImagePositions = new int[]{71,72};
		System.out.println(this.blockImageData[0]);
		System.out.println(this.blockImageData[1]);
		
		try{
		
			Statement st = conn.createStatement();
			Statement innerSt = conn.createStatement();
			ResultSet rs;
			
			rs = st.executeQuery("select * from user_forms where form_name = '103 Form' and user_id = "+this.getUserID());
		    while( rs.next() ){
		    	formID = rs.getInt("user_form_id");
		    }
			
		    for(i=0;i<blockLegendPositions.length;i++){
				rs = st.executeQuery("select component_id from user_forms_components where user_form_id = "+ formID +
						" and position_id="+blockLegendPositions[i]);
				while ( rs.next() )
				{
					innerSt.execute("Update components set component_name ='" + this.blockLegendData[i] +
							"' where component_id ="+ rs.getString("component_id") +"");
				}
			}
		    
			for(i=0;i<blockOnePositions.length;i++){
				rs = st.executeQuery("select component_id from user_forms_components where user_form_id = "+ formID +
						" and position_id="+blockOnePositions[i]);
				while ( rs.next() )
				{
					
					innerSt.execute("Update components set component_name ='" + this.blockOneData[i] +
							"' where component_id ="+ rs.getString("component_id") +"");
				}
			}
			
			for(i=0;i<blockTwoPositions.length;i++){
				rs = st.executeQuery("select component_id from user_forms_components where user_form_id = "+ formID +
						" and position_id="+blockTwoPositions[i]);
				while ( rs.next() )
				{
					innerSt.execute("Update components set component_name ='" + this.blockTwoData[i] +
							"' where component_id ="+ rs.getString("component_id") +"");
				}
			}
			
			for(i=0;i<blockThreePositions.length;i++){
				rs = st.executeQuery("select component_id from user_forms_components where user_form_id = "+ formID +
						" and position_id="+blockThreePositions[i]);
				while ( rs.next() )
				{
					innerSt.execute("Update components set component_name ='" + this.blockThreeData[i] +
							"' where component_id ="+ rs.getString("component_id") +"");
				}
			}
				
			for(i=0;i<blockFourZeroPositions.length;i++){
				rs = st.executeQuery("select component_id from user_forms_components where user_form_id = "+ formID +
						" and position_id="+blockFourZeroPositions[i]);
				while ( rs.next() )
				{
					innerSt.execute("Update components set component_name ='" + this.blockFourZeroData[i] +
							"' where component_id ="+ rs.getString("component_id") +"");
				}
			}
			
			for(i=0;i<blockFourOnePositions.length;i++){
				rs = st.executeQuery("select component_id from user_forms_components where user_form_id = "+ formID +
						" and position_id="+blockFourOnePositions[i]);
				while ( rs.next() )
				{
					innerSt.execute("Update components set component_name ='" + this.blockFourOneData[i] +
							"' where component_id ="+ rs.getString("component_id") +"");
				}
			}
			
			for(i=0;i<blockFourTwoPositions.length;i++){
				rs = st.executeQuery("select component_id from user_forms_components where user_form_id = "+ formID +
						" and position_id="+blockFourTwoPositions[i]);
				while ( rs.next() )
				{
					innerSt.execute("Update components set component_name ='" + this.blockFourTwoData[i] +
							"' where component_id ="+ rs.getString("component_id") +"");
				}
			}
			
			for(i=0;i<blockFourThreePositions.length;i++){
				rs = st.executeQuery("select component_id from user_forms_components where user_form_id = "+ formID +
						" and position_id="+blockFourThreePositions[i]);
				while ( rs.next() )
				{
					innerSt.execute("Update components set component_name ='" + this.blockFourThreeData[i] +
							"' where component_id ="+ rs.getString("component_id") +"");
				}
			}
			
			for(i=0;i<blockBatteryPositions.length;i++){
				rs = st.executeQuery("select component_id from user_forms_components where user_form_id = "+ formID +
						" and position_id="+blockBatteryPositions[i]);
				while ( rs.next() )
				{
					innerSt.execute("Update components set component_name ='" + this.blockBatteryData[i] +
							"' where component_id ="+ rs.getString("component_id") +"");
				}
			}
			
			for(i=0;i<blockImagePositions.length;i++){
				rs = st.executeQuery("select component_id from user_forms_components where user_form_id = "+ formID +
						" and position_id="+blockImagePositions[i]);
				while ( rs.next() )
				{
					innerSt.execute("Update components set component_name ='" + this.blockImageData[i] +
							"' where component_id ="+ rs.getString("component_id") +"");
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
	
	public String getTitle(){
		return title;
	}

	public void setTitle(String title){
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

	public String[] getBlockTwoData() {
		return blockTwoData;
	}

	public void setBlockTwoData(String[] blockTwoData) {
		this.blockTwoData = blockTwoData;
	}

	public String[] getBlockThreeData() {
		return blockThreeData;
	}

	public void setBlockThreeData(String[] blockThreeData) {
		this.blockThreeData = blockThreeData;
	}

	public String[] getBlockFourZeroData() {
		return blockFourZeroData;
	}

	public void setBlockFourZeroData(String[] blockFourZeroData) {
		this.blockFourZeroData = blockFourZeroData;
	}

	public String[] getBlockFourOneData() {
		return blockFourOneData;
	}

	public void setBlockFourOneData(String[] blockFourOneData) {
		this.blockFourOneData = blockFourOneData;
	}

	public String[] getBlockFourTwoData() {
		return blockFourTwoData;
	}

	public void setBlockFourTwoData(String[] blockFourTwoData) {
		this.blockFourTwoData = blockFourTwoData;
	}

	public String[] getBlockFourThreeData() {
		return blockFourThreeData;
	}

	public void setBlockFourThreeData(String[] blockFourThreeData) {
		this.blockFourThreeData = blockFourThreeData;
	}

	public String[] getBlockBatteryData() {
		return blockBatteryData;
	}

	public void setBlockBatteryData(String[] blockBatteryData) {
		this.blockBatteryData = blockBatteryData;
	}

	public String[] getBlockImageData() {
		return blockImageData;
	}

	public void setBlockImageData(String[] blockImageData) {
		this.blockImageData = blockImageData;
	}

	public String[] getBlockLegendData() {
		return blockLegendData;
	}

	public void setBlockLegendData(String[] blockLegendData) {
		this.blockLegendData = blockLegendData;
	}

	
	
}
