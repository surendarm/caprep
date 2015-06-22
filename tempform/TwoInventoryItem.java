package com.tempform;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.innoppl.dbconnect.SingleConnect;

public class TwoInventoryItem {

	private SingleConnect singleConnect = new SingleConnect();
	private String title;
	private String[] item = new String[125];
	private String [] blockLegendData = new String[25];
	private String [] blockOneData = new String[25];
	private String [] blockTwoData = new String[25];
	private Integer userID = 0;

	public Integer getUserID() {
		return userID;
	}


	public void setUserID(Integer userID) {
		this.userID = userID;
	}


	public TwoInventoryItem(int currentUserID) {
		Connection conn = null;
		conn = singleConnect.connectToDatabaseOrDie();
		this.setUserID(currentUserID);
		int formID = 0, i=0; //4401;

		try{
			Statement st = conn.createStatement();
			ResultSet rs;
			rs = st.executeQuery("select * from user_forms where  (form_name = '102 Form' or form_name = '102 Form 1' or form_name = '102 Form 2')  and user_id = "+this.getUserID());
			while( rs.next() ){
				formID = rs.getInt("user_form_id");
			}

			rs = st.executeQuery("select distinct(c.component_id), c.component_name, sc.label, op.option_description, op.options_name, uc.position_id from components c left join user_forms_components uc on c.component_id = uc.component_id left join sub_components sc on c.component_id = sc.component_id left join sub_components_options sco on sc.sub_component_id = sco.sub_component_id left join options op on sco.option_id = op.option_id where uc.user_form_id = "+ formID +" order by uc.position_id");
			i = 0;
			while( rs.next() ){
				this.title = rs.getString("component_name");
				this.item[i] =  rs.getString("component_name");
				i++;		
			}
			
			rs = st.executeQuery("select distinct(c.component_id), c.component_name, uc.position_id from components c left join user_forms_components uc on c.component_id = uc.component_id left join sub_components sc on c.component_id = sc.component_id left join sub_components_options sco on sc.sub_component_id = sco.sub_component_id left join options op on sco.option_id = op.option_id where uc.user_form_id = "+ formID +" and uc.position_id in (2, 3, 4) order by uc.position_id");
			i=0;
			while (rs.next()){
				this.blockLegendData[i] = rs.getString("component_name");
				i++;
			}

			rs = st.executeQuery("select distinct(c.component_id), c.component_name, uc.position_id from components c left join user_forms_components uc on c.component_id = uc.component_id left join sub_components sc on c.component_id = sc.component_id left join sub_components_options sco on sc.sub_component_id = sco.sub_component_id left join options op on sco.option_id = op.option_id where uc.user_form_id = "+ formID +" and (uc.position_id >= 5 and uc.position_id <= 21) order by uc.position_id");
			i=0;
			while (rs.next()){
				this.blockOneData[i] = rs.getString("component_name");
				i++;
			}

			rs = st.executeQuery("select distinct(c.component_id), c.component_name, uc.position_id from components c left join user_forms_components uc on c.component_id = uc.component_id left join sub_components sc on c.component_id = sc.component_id left join sub_components_options sco on sc.sub_component_id = sco.sub_component_id left join options op on sco.option_id = op.option_id where uc.user_form_id = "+ formID +" and (uc.position_id >= 22 and uc.position_id <= 37) order by uc.position_id");
			i=0;
			while (rs.next()){
				this.blockTwoData[i] = rs.getString("component_name");
				i++;
			}

		}
		catch (Exception e) {
			e.printStackTrace();	
		}


	}


	public void store(TwoInventoryItem twoInventoryItem){
		Connection conn = null;
		conn = singleConnect.connectToDatabaseOrDie();
		int formID = 0;	//4401;
		int i = 0;
		int[] blockLegendPositions = new int[]{2,3,4};
		int[] blockOnePositions = new int[]{5, 6, 7, 8, 9, 10, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21};
		int[] blockTwoPositions = new int[]{22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37};
		try{
			Statement st = conn.createStatement();
			Statement innerSt = conn.createStatement();
			ResultSet rs;
			rs = st.executeQuery("select * from user_forms where form_name = '102 Form' and user_id = "+this.getUserID());
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

	public String[] getBlockLegendData() {
		return blockLegendData;
	}


	public void setBlockLegendData(String[] blockLegendData) {
		this.blockLegendData = blockLegendData;
	}



}
