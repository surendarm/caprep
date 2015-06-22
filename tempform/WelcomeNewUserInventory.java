package com.tempform;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.Map;

import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;

import com.innoppl.dbconnect.SingleConnect;

public class WelcomeNewUserInventory {

	private SingleConnect singleConnect = new SingleConnect();
	private String title;
	private Integer sessID;
	private Integer userID;
	private String userName; 
	

	@SuppressWarnings("resource")
	public WelcomeNewUserInventory(int sessID){
		
		this.setSessID(sessID);
		this.setTitle("MR.");
		
		String fname = "", lname ="";
		int size =0;
		Connection conn = null;
		conn = singleConnect.connectToDatabaseOrDie();
		Session sess = Sessions.getCurrent();
		
		try{
			Statement st = conn.createStatement();
			ResultSet rs;
			rs = st.executeQuery("select * from user_ifs where sess_user_id = "+ this.getSessID());
			while ( rs.next() )
			{
				size++;
			}
			
			if(size > 0){
				rs = st.executeQuery("select * from user_ifs where sess_user_id = "+ this.getSessID());
				while(rs.next()){
					System.out.println("Fisker log 1" + rs.getInt("user_id") + rs.getString("user_name") + this.getSessID());
					this.setUserID(rs.getInt("user_id"));
					sess.setAttribute("assist_user_id", rs.getInt("user_id"));
					this.setUserName(rs.getString("user_name"));
					Map<String, Object> allAttributes = sess.getAttributes();
					Iterator iterator = allAttributes.entrySet().iterator();
					while (iterator.hasNext()) {
						Map.Entry mapEntry = (Map.Entry) iterator.next();
						System.out.println("The key is: " + mapEntry.getKey()
							+ ",value is :" + mapEntry.getValue());
					}
					
				}
			}else{
				userID = this.getSessID();
				fname = (String) sess.getAttribute("fname");
				lname = (String) sess.getAttribute("lname");
				System.out.println("Fisker log 2" + fname + lname + this.getSessID());
				st.execute("Insert into user_ifs (sess_user_id, user_name, user_role) values" +
						"("+userID +",'"+fname.replace("'", "''") +" "+ lname.replace("'", "''") +"','User')");
				rs = st.executeQuery("select last_value from user_id_seq");
				while(rs.next()){
					this.setUserID(rs.getInt("last_value"));
					sess.setAttribute("assist_user_id", rs.getInt("last_value"));
				}
				this.setUserName(fname +" "+ lname);
				servicesCreation();
				templatesCreation();
				System.out.println("Fisker log 3 : Else NEW USER Condition Triggered");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void templatesCreation(){
		System.out.println(this.getUserID());
		java.util.Date date= new java.util.Date();
		Timestamp createdTime = new Timestamp(date.getTime());
		
		Connection conn = null;
		conn = singleConnect.connectToDatabaseOrDie();
		
		
		int userID = this.getUserID();
		int userFormID = 0,	refFormOneID = 4259, refFormTwoID = 4401,	refFormThreeID = 4441, refFormFourID = 4525;
		String tempComponentName ="", tempLabel ="", tempOptionDescription ="";
		int tempPositionID = 0, tempComponentID = 0, tempOptionID = 0, tempSubComponentID = 0;
		
		try{
			Statement st = conn.createStatement();
			Statement innerSt = conn.createStatement();
			ResultSet rs, innerRs;
			
			

			/*
			 * Template FOUR
			 */
			
			st.execute("INSERT INTO user_forms(form_image, image_type, form_left_image, form_name, form_right_image, header_text, heading_color, status, template_id, user_id, created_time) VALUES " +
					"('','','','104 Form','','VEHICLE CONDITION REPORT','','',4,"+ userID +",'"+ createdTime +"')");
			rs = st.executeQuery("select last_value from user_form_id_seq");
			while(rs.next()){
				userFormID = rs.getInt("last_value");
			}
			
			rs = st.executeQuery("select distinct(c.component_id), c.component_name, sc.label, op.option_description, op.options_name, uc.position_id from components c left join user_forms_components uc on c.component_id = uc.component_id left join sub_components sc on c.component_id = sc.component_id left join sub_components_options sco on sc.sub_component_id = sco.sub_component_id left join options op on sco.option_id = op.option_id where uc.user_form_id = "+ refFormFourID +" order by uc.position_id");
			
		    while( rs.next() ){
		    	/*System.out.println(rs.getString("component_name"));
		    	System.out.println(rs.getString("label"));
		    	System.out.println(rs.getString("option_description"));
		    	System.out.println(rs.getInt("position_id"));
		    	*/
		    	tempComponentName =rs.getString("component_name");
		    	tempLabel =rs.getString("label");
		    	tempOptionDescription =rs.getString("option_description"); 
		    	tempPositionID = rs.getInt("position_id");
		    	
		    	innerSt.execute("INSERT INTO components(component_name, created_by, created_date, updated_by, updated_date) VALUES " +
		    			"('"+ tempComponentName +"','User','"+ createdTime +"','User','"+ createdTime +"')");
		    	innerRs = innerSt.executeQuery("select last_value from component_id_seq");
		    	while(innerRs.next()){
		    		tempComponentID = innerRs.getInt("last_value");
		    	}
		    	
		    	innerSt.execute("INSERT INTO user_forms_components(color_preference, parent_component_id, user_id, component_id, document_id, position_id, status_id, user_form_id) VALUES " +
		    			"('',Null,"+ userID +","+ tempComponentID +",Null,"+ tempPositionID +",1,"+ userFormID+")");
		    	
		    }
			
			
			/*
			 * Template THREE
			 */
			
			st.execute("INSERT INTO user_forms(form_image, image_type, form_left_image, form_name, form_right_image, header_text, heading_color, status, template_id, user_id, created_time) VALUES " +
					"('','','','103 Form','','VEHICLE CONDITION REPORT','','',3,"+ userID +",'"+ createdTime +"')");
			rs = st.executeQuery("select last_value from user_form_id_seq");
			while(rs.next()){
				userFormID = rs.getInt("last_value");
			}
			
			rs = st.executeQuery("select distinct(c.component_id), c.component_name, sc.label, op.option_description, op.options_name, uc.position_id from components c left join user_forms_components uc on c.component_id = uc.component_id left join sub_components sc on c.component_id = sc.component_id left join sub_components_options sco on sc.sub_component_id = sco.sub_component_id left join options op on sco.option_id = op.option_id where uc.user_form_id = "+ refFormThreeID +" order by uc.position_id");
			
		    while( rs.next() ){
		    	/*
		    	System.out.println(rs.getString("component_name"));
		    	System.out.println(rs.getString("label"));
		    	System.out.println(rs.getString("option_description"));
		    	System.out.println(rs.getInt("position_id"));
		    	*/
		    	tempComponentName =rs.getString("component_name");
		    	tempLabel =rs.getString("label");
		    	tempOptionDescription =rs.getString("option_description"); 
		    	tempPositionID = rs.getInt("position_id");
		    	
		    	innerSt.execute("INSERT INTO components(component_name, created_by, created_date, updated_by, updated_date) VALUES " +
		    			"('"+ tempComponentName +"','User','"+ createdTime +"','User','"+ createdTime +"')");
		    	innerRs = innerSt.executeQuery("select last_value from component_id_seq");
		    	while(innerRs.next()){
		    		tempComponentID = innerRs.getInt("last_value");
		    	}
		    	
		    	innerSt.execute("INSERT INTO user_forms_components(color_preference, parent_component_id, user_id, component_id, document_id, position_id, status_id, user_form_id) VALUES " +
		    			"('',Null,"+ userID +","+ tempComponentID +",Null,"+ tempPositionID +",1,"+ userFormID+")");
		    	
		    }
			
		
			/*
			 * Template TWO
			 */
			
			st.execute("INSERT INTO user_forms(form_image, image_type, form_left_image, form_name, form_right_image, header_text, heading_color, status, template_id, user_id, created_time) VALUES " +
					"('','','','102 Form','','VEHICLE CONDITION REPORT','','',2,"+ userID +",'"+ createdTime +"')");
			rs = st.executeQuery("select last_value from user_form_id_seq");
			while(rs.next()){
				userFormID = rs.getInt("last_value");
			}
			
			rs = st.executeQuery("select distinct(c.component_id), c.component_name, sc.label, op.option_description, op.options_name, uc.position_id from components c left join user_forms_components uc on c.component_id = uc.component_id left join sub_components sc on c.component_id = sc.component_id left join sub_components_options sco on sc.sub_component_id = sco.sub_component_id left join options op on sco.option_id = op.option_id where uc.user_form_id = "+ refFormTwoID +" order by uc.position_id");
		    
		    while( rs.next() ){
		    	/*System.out.println(rs.getString("component_name"));
		    	System.out.println(rs.getString("label"));
		    	System.out.println(rs.getString("option_description"));
		    	System.out.println(rs.getInt("position_id"));
		    	*/
		    	tempComponentName =rs.getString("component_name");
		    	tempLabel =rs.getString("label");
		    	tempOptionDescription =rs.getString("option_description"); 
		    	tempPositionID = rs.getInt("position_id");
		    	
		    	innerSt.execute("INSERT INTO components(component_name, created_by, created_date, updated_by, updated_date) VALUES " +
		    			"('"+ tempComponentName +"','User','"+ createdTime +"','User','"+ createdTime +"')");
		    	innerRs = innerSt.executeQuery("select last_value from component_id_seq");
		    	while(innerRs.next()){
		    		tempComponentID = innerRs.getInt("last_value");
		    	}
		    	
		    	innerSt.execute("INSERT INTO user_forms_components(color_preference, parent_component_id, user_id, component_id, document_id, position_id, status_id, user_form_id) VALUES " +
		    			"('',Null,"+ userID +","+ tempComponentID +",Null,"+ tempPositionID +",1,"+ userFormID+")");
		    	
		    }
			
			/*
			 * Template ONE
			 */
		    
			st.execute("INSERT INTO user_forms(form_image, image_type, form_left_image, form_name, form_right_image, header_text, heading_color, status, template_id, user_id, created_time) VALUES " +
					"('','','','101 Form','','VEHICLE CONDITION REPORT','','',1,"+ userID +",'"+ createdTime +"')");
			rs = st.executeQuery("select last_value from user_form_id_seq");
			while(rs.next()){
				userFormID = rs.getInt("last_value");
			}
			
			rs = st.executeQuery("select distinct(c.component_id), c.component_name, sc.label, op.option_description, uc.position_id from components c left join user_forms_components uc on c.component_id = uc.component_id left join sub_components sc on c.component_id = sc.component_id left join sub_components_options sco on sc.sub_component_id = sco.sub_component_id left join options op on sco.option_id = op.option_id where uc.user_form_id = "+ refFormOneID +" and options_name = 'Second' order by uc.position_id");
		    
		    while( rs.next() ){
		    	/*System.out.println(rs.getString("component_name"));
		    	System.out.println(rs.getString("label"));
		    	System.out.println(rs.getString("option_description"));
		    	System.out.println(rs.getInt("position_id"));
		    	*/
		    	tempComponentName =rs.getString("component_name");
		    	tempLabel =rs.getString("label");
		    	tempOptionDescription =rs.getString("option_description"); 
		    	tempPositionID = rs.getInt("position_id");
		    	
		    	innerSt.execute("INSERT INTO components(component_name, created_by, created_date, updated_by, updated_date) VALUES " +
		    			"('"+ tempComponentName +"','User','"+ createdTime +"','User','"+ createdTime +"')");
		    	innerRs = innerSt.executeQuery("select last_value from component_id_seq");
		    	while(innerRs.next()){
		    		tempComponentID = innerRs.getInt("last_value");
		    	}
		    	
		    	innerSt.execute("INSERT INTO user_forms_components(color_preference, parent_component_id, user_id, component_id, document_id, position_id, status_id, user_form_id) VALUES " +
		    			"('',Null,"+ userID +","+ tempComponentID +",Null,"+ tempPositionID +",1,"+ userFormID+")");
		    	
		    	
		    	innerSt.execute("INSERT INTO options (option_description, options_name) VALUES ('"+ tempOptionDescription +"','FIRST')");
		    	innerRs = innerSt.executeQuery("select last_value from option_id_seq");
		    	while(innerRs.next()){
		    		tempOptionID = innerRs.getInt("last_value");
		    	}
		    	
		    	innerSt.execute("INSERT INTO sub_components(component_id, created_by, created_date, label, modified_by, modified_date) VALUES " +
		    			"("+ tempComponentID +",'USER','"+ createdTime +"','"+ tempLabel +"','User','"+ createdTime +"')");
		    	innerRs = innerSt.executeQuery("select last_value from sub_component_id_seq");
		    	while(innerRs.next()){
		    		tempSubComponentID = innerRs.getInt("last_value");  
		    	}
		    	
		    	innerSt.execute("INSERT INTO sub_components_options(option_type, status, option_id, sub_component_id) VALUES " +
		    			"('Square','true',"+ tempOptionID +","+ tempSubComponentID +")");
		    	
		    }

		    System.out.println(createdTime);
			System.out.println(userID);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	private void servicesCreation(){
		//System.out.println(this.getUserID());
		//System.out.println("Inside Services Creation");
		
		Connection conn = null;
		conn = singleConnect.connectToDatabaseOrDie();
		
		int userID = this.getUserID();
		int[] userServicesID = new int[8];
		int i = 0, j = 0, oneCount = 0, twoCount =0, threeCount=0, fourCount=0, fiveCount =0, sixCount =0, sevenCount =0, eightCount =0;
		int[] serviceOnePositions = new int[50];//{101, 102, 103, 111, 112, 113, 121, 122, 201, 202, 203, 204, 205, 211, 212, 213, 214, 215, 221, 222, 223, 224, 225};
		int[] serviceTwoPositions = new int[50];//{101, 102, 103, 111, 112, 113, 121, 122, 201, 202, 203, 204, 205, 211, 212, 213, 214, 215, 221, 222, 223, 224, 225};
		int[] serviceThreePositions = new int[50];//{101, 102, 103, 111, 112, 113, 121, 122, 131, 132, 133, 201, 202, 203, 204, 205, 211, 212, 213, 214, 215, 221, 222, 223, 224, 225};
		int[] serviceFourPositions = new int[50];//{101, 102, 103, 111, 112, 113, 121, 122, 201, 202, 203, 204, 205, 211, 212, 213, 214, 215, 221, 222, 223, 224, 225};
		int[] serviceFivePositions = new int[50];//{101, 102, 103, 111, 112, 113, 121, 122, 201, 202, 203, 204, 205, 211, 212, 213, 214, 215, 221, 222, 223, 224, 225};
		int[] serviceSixPositions = new int[50];//{101, 102, 103, 111, 112, 113, 121, 122, 201, 202, 203, 204, 205, 211, 212, 213, 214, 215, 221, 222, 223, 224, 225};
		int[] serviceSevenPositions = new int[50];//{301, 302, 303, 311, 312, 313, 321, 322, 323, 331, 332, 333, 341, 342, 343, 351, 352, 353, 361, 362, 363, 371, 372, 373, 381, 382, 383, 391, 392, 393};
		int[] serviceEightPositions = new int[50];//{101, 102, 103, 111, 112, 113, 121, 122, 201, 202, 203, 204, 205, 211, 212, 213, 214, 215, 221, 222, 223, 224, 225};
		String[] serviceOneContent = new String[50];
		String[] serviceTwoContent = new String[50];
		String[] serviceThreeContent = new String[50];
		String[] serviceFourContent = new String[50];
		String[] serviceFiveContent = new String[50];
		String[] serviceSixContent = new String[50];
		String[] serviceSevenContent = new String[50];
		String[] serviceEightContent = new String[50];
		
		
		try{
			Statement st = conn.createStatement();
			ResultSet rs;
			for(i=0,j=1;i<8;i++,j++){
				st.execute("Insert into user_services (user_id, service_id, service_active) values" +
						"("+userID +","+ j +",'false')");
				rs = st.executeQuery("select last_value from user_service_id_seq");
				while(rs.next()){
					userServicesID[i] = rs.getInt("last_value");
				}
			}
			
			for(i=0;i<userServicesID.length;i++){
				System.out.println(userServicesID[i]);
			}
			
			
			rs = st.executeQuery("select service_content, service_position_id from services_block_components where user_service_id = 1 order by service_position_id");
			i=0;
			oneCount =0;
			while(rs.next()){
				serviceOneContent[i] = rs.getString("service_content");
				serviceOnePositions[i] = rs.getInt("service_position_id");
				i++;
				oneCount++;
			}
			
			for(i=0;i<oneCount;i++){
				st.execute("insert into services_block_components(user_service_id, service_content, user_id, service_id, service_position_id) values" +
							"("+ userServicesID[0] +",'"+ serviceOneContent[i].replace("'", "''") +"',"+userID+",1,"+serviceOnePositions[i]+")");
			}
			

			rs = st.executeQuery("select service_content, service_position_id from services_block_components where user_service_id = 2 order by service_position_id");
			i=0;
			twoCount =0;
			while(rs.next()){
				serviceTwoContent[i] = rs.getString("service_content");
				serviceTwoPositions[i] = rs.getInt("service_position_id");
				i++;
				twoCount++;
			}
			
			for(i=0;i<twoCount;i++){
				st.execute("insert into services_block_components(user_service_id, service_content, user_id, service_id, service_position_id) values" +
							"("+ userServicesID[1] +",'"+ serviceTwoContent[i].replace("'", "''") +"',"+userID+",2,"+serviceTwoPositions[i]+")");
			}
			
			rs = st.executeQuery("select service_content, service_position_id from services_block_components where user_service_id = 3 order by service_position_id");
			i=0;
			threeCount =0;
			while(rs.next()){
				serviceThreeContent[i] = rs.getString("service_content");
				serviceThreePositions[i] = rs.getInt("service_position_id");
				i++;
				threeCount++;
			}
			
			for(i=0;i<threeCount;i++){
				st.execute("insert into services_block_components(user_service_id, service_content, user_id, service_id, service_position_id) values" +
							"("+ userServicesID[2] +",'"+ serviceThreeContent[i].replace("'", "''") +"',"+userID+",3,"+serviceThreePositions[i]+")");
			}
						
			
			rs = st.executeQuery("select service_content, service_position_id from services_block_components where user_service_id = 4 order by service_position_id");
			i=0;
			fourCount =0;
			while(rs.next()){
				serviceFourContent[i] = rs.getString("service_content");
				serviceFourPositions[i] = rs.getInt("service_position_id");
				i++;
				fourCount++;
			}
			
			for(i=0;i<fourCount;i++){
				st.execute("insert into services_block_components(user_service_id, service_content, user_id, service_id, service_position_id) values" +
							"("+ userServicesID[3] +",'"+ serviceFourContent[i].replace("'", "''") +"',"+userID+",4,"+serviceFourPositions[i]+")");
			}
						
			rs = st.executeQuery("select service_content, service_position_id from services_block_components where user_service_id = 5 order by service_position_id");
			i=0;
			fiveCount =0;
			while(rs.next()){
				serviceFiveContent[i] = rs.getString("service_content");
				serviceFivePositions[i] = rs.getInt("service_position_id");
				i++;
				fiveCount++;
			}
			
			for(i=0;i<fiveCount;i++){
				st.execute("insert into services_block_components(user_service_id, service_content, user_id, service_id, service_position_id) values" +
							"("+ userServicesID[4] +",'"+ serviceFiveContent[i].replace("'", "''") +"',"+userID+",5,"+serviceFivePositions[i]+")");
			}
			
			rs = st.executeQuery("select service_content, service_position_id from services_block_components where user_service_id = 6 order by service_position_id");
			i=0;
			sixCount =0;
			while(rs.next()){
				serviceSixContent[i] = rs.getString("service_content");
				serviceSixPositions[i] = rs.getInt("service_position_id");
				i++;
				sixCount++;
			}
			
			for(i=0;i<sixCount;i++){
				st.execute("insert into services_block_components(user_service_id, service_content, user_id, service_id, service_position_id) values" +
							"("+ userServicesID[5] +",'"+ serviceSixContent[i].replace("'", "''") +"',"+userID+",6,"+serviceSixPositions[i]+")");
			}
			

			rs = st.executeQuery("select service_content, service_position_id from services_block_components where user_service_id = 7 order by service_position_id");
			i=0;
			sevenCount =0;
			while(rs.next()){
				serviceSevenContent[i] = rs.getString("service_content");
				serviceSevenPositions[i] = rs.getInt("service_position_id");
				i++;
				sevenCount++;
			}
			
			for(i=0;i<sevenCount;i++){
				st.execute("insert into services_block_components(user_service_id, service_content, user_id, service_id, service_position_id) values" +
							"("+ userServicesID[6] +",'"+ serviceSevenContent[i].replace("'", "''") +"',"+userID+",7,"+serviceSevenPositions[i]+")");
			}
			

			rs = st.executeQuery("select service_content, service_position_id from services_block_components where user_service_id = 8 order by service_position_id");
			i=0;
			eightCount =0;
			while(rs.next()){
				serviceEightContent[i] = rs.getString("service_content");
				serviceEightPositions[i] = rs.getInt("service_position_id");
				i++;
				eightCount++;
			}
			
			for(i=0;i<eightCount;i++){
				st.execute("insert into services_block_components(user_service_id, service_content, user_id, service_id, service_position_id) values" +
							"("+ userServicesID[7] +",'"+ serviceEightContent[i].replace("'", "''") +"',"+userID+",8,"+serviceEightPositions[i]+")");
			}
			

			
			/*
			for(i=0;i<serviceOnePositions.length;i++){
				st.execute("insert into services_block_components(user_service_id, service_content, user_id, service_id, service_position_id) values" +
							"("+ userServicesID[0] +",'',"+userID+",1,"+serviceOnePositions[i]+")");
			}
			
			for(i=0;i<serviceTwoPositions.length;i++){
				st.execute("insert into services_block_components(user_service_id, service_content, user_id, service_id, service_position_id) values" +
							"("+ userServicesID[1] +",'',"+userID+",2,"+serviceTwoPositions[i]+")");
			}
			
			for(i=0;i<serviceThreePositions.length;i++){
				st.execute("insert into services_block_components(user_service_id, service_content, user_id, service_id, service_position_id) values" +
							"("+ userServicesID[2] +",'',"+userID+",3,"+serviceThreePositions[i]+")");
			}
			
			for(i=0;i<serviceFourPositions.length;i++){
				st.execute("insert into services_block_components(user_service_id, service_content, user_id, service_id, service_position_id) values" +
							"("+ userServicesID[3] +",'',"+userID+",4,"+serviceFourPositions[i]+")");
			}
			
			for(i=0;i<serviceFivePositions.length;i++){
				st.execute("insert into services_block_components(user_service_id, service_content, user_id, service_id, service_position_id) values" +
							"("+ userServicesID[4] +",'',"+userID+",5,"+serviceFivePositions[i]+")");
			}
			
			for(i=0;i<serviceSixPositions.length;i++){
				st.execute("insert into services_block_components(user_service_id, service_content, user_id, service_id, service_position_id) values" +
							"("+ userServicesID[5] +",'',"+userID+",6,"+serviceSixPositions[i]+")");
			}
			
			for(i=0;i<serviceSevenPositions.length;i++){
				st.execute("insert into services_block_components(user_service_id, service_content, user_id, service_id, service_position_id) values" +
							"("+ userServicesID[6] +",'',"+userID+",7,"+serviceSevenPositions[i]+")");
			}
			
			for(i=0;i<serviceEightPositions.length;i++){
				st.execute("insert into services_block_components(user_service_id, service_content, user_id, service_id, service_position_id) values" +
							"("+ userServicesID[7] +",'',"+userID+",8,"+serviceEightPositions[i]+")");
			}
			*/
			
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("Service Creation Method Triggered");
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


	public Integer getSessID() {
		return sessID;
	}

	public void setSessID(Integer sessID) {
		this.sessID = sessID;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	
	
	
}
