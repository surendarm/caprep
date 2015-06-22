package com.tempform.input;

import java.awt.Button;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import com.tempform.InventoryItem;

public class Editcontroller  extends SelectorComposer<Component>  {

	private static final long serialVersionUID = 1L;

	private InventoryItem inventoryItem;

	private Integer userID = 0;

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public Editcontroller(){
		Session sess = Sessions.getCurrent();
		this.setUserID((Integer) sess.getAttribute("assist_user_id"));
		System.out.println("Controller : "+sess.getAttribute("assist_user_id"));
		if(this.getUserID() == null){
			Executions.sendRedirect("/welcome_user.zul");
		}else{
			inventoryItem = new InventoryItem(this.getUserID());
		}
	}

	public InventoryItem getInventoryItem() {
		return inventoryItem;
	}


	@Wire
	private Window win;

	@Wire
	private Button submitButton;

	@Wire
	private Textbox nameBox;

	@Wire
	private Textbox item1;

	@Wire
	private Textbox item1Label;
	@Wire
	private Textbox item1Optionsdesc1;
	@Wire
	private Textbox item1Optionsdesc2;
	@Wire
	private Textbox item1Optionsdesc3;
	@Wire
	private Textbox item2;
	@Wire
	private Textbox item2Label;
	@Wire
	private Textbox item2Optionsdesc1;
	@Wire
	private Textbox item2Optionsdesc2;
	@Wire
	private Textbox item2Optionsdesc3;
	@Wire
	private Textbox item3;
	@Wire
	private Textbox item3Label;
	@Wire
	private Textbox item3Optionsdesc1;
	@Wire
	private Textbox item3Optionsdesc2;
	@Wire
	private Textbox item3Optionsdesc3;
	@Wire
	private Textbox item4;
	@Wire
	private Textbox item4Label;
	@Wire
	private Textbox item4Optionsdesc1;
	@Wire
	private Textbox item4Optionsdesc2;
	@Wire
	private Textbox item4Optionsdesc3;
	@Wire
	private Textbox item5;
	@Wire
	private Textbox item5Label;
	@Wire
	private Textbox item5Optionsdesc1;
	@Wire
	private Textbox item5Optionsdesc2;
	@Wire
	private Textbox item5Optionsdesc3;
	@Wire
	private Textbox item6;
	@Wire
	private Textbox item6Label;
	@Wire
	private Textbox item6Optionsdesc1;
	@Wire
	private Textbox item6Optionsdesc2;
	@Wire
	private Textbox item6Optionsdesc3;
	@Wire
	private Textbox item7;
	@Wire
	private Textbox item7Label;
	@Wire
	private Textbox item7Optionsdesc1;
	@Wire
	private Textbox item7Optionsdesc2;
	@Wire
	private Textbox item7Optionsdesc3;
	@Wire
	private Textbox item8;
	@Wire
	private Textbox item8Label;
	@Wire
	private Textbox item8Optionsdesc1;
	@Wire
	private Textbox item8Optionsdesc2;
	@Wire
	private Textbox item8Optionsdesc3;
	@Wire
	private Textbox item9;
	@Wire
	private Textbox item9Label;
	@Wire
	private Textbox item9Optionsdesc1;
	@Wire
	private Textbox item9Optionsdesc2;
	@Wire
	private Textbox item9Optionsdesc3;
	@Wire
	private Textbox item10;
	@Wire
	private Textbox item10Label;
	@Wire
	private Textbox item10Optionsdesc1;
	@Wire
	private Textbox item10Optionsdesc2;
	@Wire
	private Textbox item10Optionsdesc3;
	@Wire
	private Textbox item11;
	@Wire
	private Textbox item11Label;
	@Wire
	private Textbox item11Optionsdesc1;
	@Wire
	private Textbox item11Optionsdesc2;
	@Wire
	private Textbox item11Optionsdesc3;
	@Wire
	private Textbox item12;
	@Wire
	private Textbox item12Label;
	@Wire
	private Textbox item12Optionsdesc1;
	@Wire
	private Textbox item12Optionsdesc2;
	@Wire
	private Textbox item12Optionsdesc3;
	@Wire
	private Textbox item13;
	@Wire
	private Textbox item13Label;
	@Wire
	private Textbox item13Optionsdesc1;
	@Wire
	private Textbox item13Optionsdesc2;
	@Wire
	private Textbox item13Optionsdesc3;
	@Wire
	private Textbox item14;
	@Wire
	private Textbox item14Label;
	@Wire
	private Textbox item14Optionsdesc1;
	@Wire
	private Textbox item14Optionsdesc2;
	@Wire
	private Textbox item14Optionsdesc3;
	@Wire
	private Textbox item15;
	@Wire
	private Textbox item15Label;
	@Wire
	private Textbox item15Optionsdesc1;
	@Wire
	private Textbox item15Optionsdesc2;
	@Wire
	private Textbox item15Optionsdesc3;
	@Wire
	private Textbox item16;
	@Wire
	private Textbox item16Label;
	@Wire
	private Textbox item16Optionsdesc1;
	@Wire
	private Textbox item16Optionsdesc2;
	@Wire
	private Textbox item16Optionsdesc3;
	@Wire
	private Textbox item17;
	@Wire
	private Textbox item17Label;
	@Wire
	private Textbox item17Optionsdesc1;
	@Wire
	private Textbox item17Optionsdesc2;
	@Wire
	private Textbox item17Optionsdesc3;
	@Wire
	private Textbox item18;
	@Wire
	private Textbox item18Label;
	@Wire
	private Textbox item18Optionsdesc1;
	@Wire
	private Textbox item18Optionsdesc2;
	@Wire
	private Textbox item18Optionsdesc3;
	@Wire
	private Textbox item19;
	@Wire
	private Textbox item19Label;
	@Wire
	private Textbox item19Optionsdesc1;
	@Wire
	private Textbox item19Optionsdesc2;
	@Wire
	private Textbox item19Optionsdesc3;
	@Wire
	private Textbox item20;
	@Wire
	private Textbox item20Label;
	@Wire
	private Textbox item20Optionsdesc1;
	@Wire
	private Textbox item20Optionsdesc2;
	@Wire
	private Textbox item20Optionsdesc3;
	@Wire
	private Textbox item21;
	@Wire
	private Textbox item21Label;
	@Wire
	private Textbox item21Optionsdesc1;
	@Wire
	private Textbox item21Optionsdesc2;
	@Wire
	private Textbox item21Optionsdesc3;
	@Wire
	private Textbox item22;
	@Wire
	private Textbox item22Label;
	@Wire
	private Textbox item22Optionsdesc1;
	@Wire
	private Textbox item22Optionsdesc2;
	@Wire
	private Textbox item22Optionsdesc3;
	@Wire
	private Textbox item23;
	@Wire
	private Textbox item23Label;
	@Wire
	private Textbox item23Optionsdesc1;
	@Wire
	private Textbox item23Optionsdesc2;
	@Wire
	private Textbox item23Optionsdesc3;

	@Wire
	private Textbox item01;

	@Wire
	private Button menuTemplate, menuServices, menuReports, activeForm, tempOne, tempTwo, tempThree, tempFour; 

	@Wire
	private Checkbox itemcheck1, itemcheck2, itemcheck3, itemcheck4, itemcheck5, itemcheck6, itemcheck7, itemcheck8, itemcheck9, itemcheck10, itemcheck11, itemcheck12, itemcheck13, itemcheck14, itemcheck15, itemcheck16, itemcheck17, itemcheck18, itemcheck19, itemcheck20, itemcheck21, itemcheck22, itemcheck23;

	@Listen("onClick =#menuVidLibrary")
	public void menuVidLibraryRedir(){
		try{
			Executions.sendRedirect("/VideoLibraryList.zul");
		}catch(Exception e){
			
		}
	}
	
	
	@Listen("onClick =#menuAnalytics")
	public void menuAnalyticsRedir(){
		try{
			Executions.sendRedirect("/AnalyticsMain.zul");
		}catch(Exception e){

		}
	}

	@Listen("onClick =#menuServices")
	public void menuServicesRedir(){
		try{
			Executions.sendRedirect("/ServiceSelection.zul");
		}catch(Exception e){

		}
	}

	@Listen("onClick =#menuReports")
	public void menuReportsRedir(){
		try{
			Executions.sendRedirect("/reports.zul");
		}catch(Exception e){

		}
	}

	@Listen("onClick =#menuSettings")
	public void menuSettingsRedir(){
		try{
			Executions.sendRedirect("/Settings.zul");
		}catch(Exception e){

		}
	}


	@Listen("onClick =#activeForm")
	public void activeFormRedir(){
		try{
			Executions.sendRedirect("/SelectForm.zul");
		}catch(Exception e){

		}
	}

	@Listen("onClick =#tempTwo")
	public void tempTwoRedir(){
		try{
			Executions.sendRedirect("/TemplateTwo.zul");
		}catch(Exception e){

		}
	}

	@Listen("onClick =#tempThree")
	public void tempThreeRedir(){
		try{
			Executions.sendRedirect("/TemplateThree.zul");
		}catch(Exception e){

		}
	}

	@Listen("onClick =#tempFour")
	public void tempFourRedir(){
		try{
			Executions.sendRedirect("/TemplateFour.zul");
		}catch(Exception e){

		}
	}

	@Listen("onChange = #nameBox")
	public void changeTitle(){
		String title = nameBox.getValue();
		inventoryItem.setTitle(title);
		System.out.println("TextBox action trigerred");
		showNotify("Changed to: " + title, nameBox);
	}

	@Listen("onClick =#submitButton")
	public void submitData(){
		try{
			String[] item = new String[25];
			String[] itemLabel = new String[25];
			String[] itemDesc1 = new String[25];
			String[] itemDesc2 = new String[25];
			String[] itemDesc3 = new String[25];
			Integer[] itemStatusId = new Integer[25];


			item[0] = item1.getValue();
			item[1] = item2.getValue();
			item[2] = item3.getValue();
			item[3] = item4.getValue();
			item[4] = item5.getValue();
			item[5] = item6.getValue();
			item[6] = item7.getValue();
			item[7] = item8.getValue();
			item[8] = item9.getValue();
			item[9] = item10.getValue();
			item[10] = item11.getValue();
			item[11] = item12.getValue();
			item[12] = item13.getValue();
			item[13] = item14.getValue();
			item[14] = item15.getValue();
			item[15] = item16.getValue();
			item[16] = item17.getValue();
			item[17] = item18.getValue();
			item[18] = item19.getValue();
			item[19] = item20.getValue();
			item[20] = item21.getValue();
			item[21] = item22.getValue();
			item[22] = item23.getValue();

			itemLabel[0] = item1Label.getValue();
			itemLabel[1] = item2Label.getValue();
			itemLabel[2] = item3Label.getValue();
			itemLabel[3] = item4Label.getValue();
			itemLabel[4] = item5Label.getValue();
			itemLabel[5] = item6Label.getValue();
			itemLabel[6] = item7Label.getValue();
			itemLabel[7] = item8Label.getValue();
			itemLabel[8] = item9Label.getValue();
			itemLabel[9] = item10Label.getValue();
			itemLabel[10] = item11Label.getValue();
			itemLabel[11] = item12Label.getValue();
			itemLabel[12] = item13Label.getValue();
			itemLabel[13] = item14Label.getValue();
			itemLabel[14] = item15Label.getValue();
			itemLabel[15] = item16Label.getValue();
			itemLabel[16] = item17Label.getValue();
			itemLabel[17] = item18Label.getValue();
			itemLabel[18] = item19Label.getValue();
			itemLabel[19] = item20Label.getValue();
			itemLabel[20] = item21Label.getValue();
			itemLabel[21] = item22Label.getValue();
			itemLabel[22] = item23Label.getValue();

			itemDesc1[0] = item1Optionsdesc1.getValue();
			itemDesc2[0] = item1Optionsdesc2.getValue();
			itemDesc3[0] = item1Optionsdesc3.getValue();

			itemDesc1[1] = item2Optionsdesc1.getValue();
			itemDesc2[1] = item2Optionsdesc2.getValue();
			itemDesc3[1] = item2Optionsdesc3.getValue();

			itemDesc1[2] = item3Optionsdesc1.getValue();
			itemDesc2[2] = item3Optionsdesc2.getValue();
			itemDesc3[2] = item4Optionsdesc3.getValue();

			itemDesc1[3] = item4Optionsdesc1.getValue();
			itemDesc2[3] = item4Optionsdesc2.getValue();
			itemDesc3[3] = item4Optionsdesc3.getValue();

			itemDesc1[4] = item5Optionsdesc1.getValue();
			itemDesc2[4] = item5Optionsdesc2.getValue();
			itemDesc3[4] = item5Optionsdesc3.getValue();

			itemDesc1[5] = item6Optionsdesc1.getValue();
			itemDesc2[5] = item6Optionsdesc2.getValue();
			itemDesc3[5] = item6Optionsdesc3.getValue();

			itemDesc1[6] = item7Optionsdesc1.getValue();
			itemDesc2[6] = item7Optionsdesc2.getValue();
			itemDesc3[6] = item7Optionsdesc3.getValue();

			itemDesc1[7] = item8Optionsdesc1.getValue();
			itemDesc2[7] = item8Optionsdesc2.getValue();
			itemDesc3[7] = item8Optionsdesc3.getValue();

			itemDesc1[8] = item9Optionsdesc1.getValue();
			itemDesc2[8] = item9Optionsdesc2.getValue();
			itemDesc3[8] = item9Optionsdesc3.getValue();

			itemDesc1[9] = item10Optionsdesc1.getValue();
			itemDesc2[9] = item10Optionsdesc2.getValue();
			itemDesc3[9] = item10Optionsdesc3.getValue();

			itemDesc1[10] = item11Optionsdesc1.getValue();
			itemDesc2[10] = item11Optionsdesc2.getValue();
			itemDesc3[10] = item11Optionsdesc3.getValue();

			itemDesc1[11] = item12Optionsdesc1.getValue();
			itemDesc2[11] = item12Optionsdesc2.getValue();
			itemDesc3[11] = item12Optionsdesc3.getValue();

			itemDesc1[12] = item13Optionsdesc1.getValue();
			itemDesc2[12] = item13Optionsdesc2.getValue();
			itemDesc3[12] = item13Optionsdesc3.getValue();

			itemDesc1[13] = item14Optionsdesc1.getValue();
			itemDesc2[13] = item14Optionsdesc2.getValue();
			itemDesc3[13] = item14Optionsdesc3.getValue();

			itemDesc1[14] = item15Optionsdesc1.getValue();
			itemDesc2[14] = item15Optionsdesc2.getValue();
			itemDesc3[14] = item15Optionsdesc3.getValue();

			itemDesc1[15] = item16Optionsdesc1.getValue();
			itemDesc2[15] = item16Optionsdesc2.getValue();
			itemDesc3[15] = item16Optionsdesc3.getValue();

			itemDesc1[16] = item17Optionsdesc1.getValue();
			itemDesc2[16] = item17Optionsdesc2.getValue();
			itemDesc3[16] = item17Optionsdesc3.getValue();

			itemDesc1[17] = item18Optionsdesc1.getValue();
			itemDesc2[17] = item18Optionsdesc2.getValue();
			itemDesc3[17] = item18Optionsdesc3.getValue();

			itemDesc1[18] = item19Optionsdesc1.getValue();
			itemDesc2[18] = item19Optionsdesc2.getValue();
			itemDesc3[18] = item19Optionsdesc3.getValue();

			itemDesc1[19] = item20Optionsdesc1.getValue();
			itemDesc2[19] = item20Optionsdesc2.getValue();
			itemDesc3[19] = item20Optionsdesc3.getValue();

			itemDesc1[20] = item21Optionsdesc1.getValue();
			itemDesc2[20] = item21Optionsdesc2.getValue();
			itemDesc3[20] = item21Optionsdesc3.getValue();

			itemDesc1[21] = item22Optionsdesc1.getValue();
			itemDesc2[21] = item22Optionsdesc2.getValue();
			itemDesc3[21] = item22Optionsdesc3.getValue();

			itemDesc1[22] = item23Optionsdesc1.getValue();
			itemDesc2[22] = item23Optionsdesc2.getValue();
			itemDesc3[22] = item23Optionsdesc3.getValue();

			if(itemcheck1.isChecked()){
				itemStatusId[0] = 0;
			}else{
				itemStatusId[0] = 1;
			}

			if(itemcheck2.isChecked()){
				itemStatusId[1] = 0;
			}else{
				itemStatusId[1] = 1;
			}

			if(itemcheck3.isChecked()){
				itemStatusId[2] = 0;
			}else{
				itemStatusId[2] = 1;
			}

			if(itemcheck4.isChecked()){
				itemStatusId[3] = 0;
			}else{
				itemStatusId[3] = 1;
			}

			if(itemcheck5.isChecked()){
				itemStatusId[4] = 0;
			}else{
				itemStatusId[4] = 1;
			}

			if(itemcheck6.isChecked()){
				itemStatusId[5] = 0;
			}else{
				itemStatusId[5] = 1;
			}

			if(itemcheck7.isChecked()){
				itemStatusId[6] = 0;
			}else{
				itemStatusId[6] = 1;
			}

			if(itemcheck8.isChecked()){
				itemStatusId[7] = 0;
			}else{
				itemStatusId[7] = 1;
			}

			if(itemcheck9.isChecked()){
				itemStatusId[8] = 0;
			}else{
				itemStatusId[8] = 1;
			}

			if(itemcheck10.isChecked()){
				itemStatusId[9] = 0;
			}else{
				itemStatusId[9] = 1;
			}

			if(itemcheck11.isChecked()){
				itemStatusId[10] = 0;
			}else{
				itemStatusId[10] = 1;
			}

			if(itemcheck12.isChecked()){
				itemStatusId[11] = 0;
			}else{
				itemStatusId[11] = 1;
			}

			if(itemcheck13.isChecked()){
				itemStatusId[12] = 0;
			}else{
				itemStatusId[12] = 1;
			}

			if(itemcheck14.isChecked()){
				itemStatusId[13] = 0;
			}else{
				itemStatusId[13] = 1;
			}

			if(itemcheck15.isChecked()){
				itemStatusId[14] = 0;
			}else{
				itemStatusId[14] = 1;
			}

			if(itemcheck16.isChecked()){
				itemStatusId[15] = 0;
			}else{
				itemStatusId[15] = 1;
			}

			if(itemcheck17.isChecked()){
				itemStatusId[16] = 0;
			}else{
				itemStatusId[16] = 1;
			}

			if(itemcheck18.isChecked()){
				itemStatusId[17] = 0;
			}else{
				itemStatusId[17] = 1;
			}

			if(itemcheck19.isChecked()){
				itemStatusId[18] = 0;
			}else{
				itemStatusId[18] = 1;
			}

			if(itemcheck20.isChecked()){
				itemStatusId[19] = 0;
			}else{
				itemStatusId[19] = 1;
			}

			if(itemcheck21.isChecked()){
				itemStatusId[20] = 0;
			}else{
				itemStatusId[20] = 1;
			}

			if(itemcheck22.isChecked()){
				itemStatusId[21] = 0;
			}else{
				itemStatusId[21] = 1;
			}

			if(itemcheck23.isChecked()){
				itemStatusId[22] = 0;
			}else{
				itemStatusId[22] = 1;
			}


			inventoryItem.setItem(item);
			inventoryItem.setItemLabel(itemLabel);
			inventoryItem.setItemDesc1(itemDesc1);
			inventoryItem.setItemDesc2(itemDesc2);
			inventoryItem.setItemDesc3(itemDesc3);
			inventoryItem.setItemStatusId(itemStatusId);
			inventoryItem.setUserID(this.getUserID());

			inventoryItem.store(inventoryItem);
			showNotify("Template One Saved Successfully!", win);
			Executions.sendRedirect("/SelectForm.zul");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	private void showNotify(String msg, Component ref){
		Clients.showNotification(msg); //, "info", ref, "end_center", 2000);
	}

}
