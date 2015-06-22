package com.innoppl.analytics;

import java.awt.Button;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.CheckEvent;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Checkbox;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;

import com.innoppl.config.Configuration;

public class AnalyticsListRenderer extends SelectorComposer<Component> {
	private static final long serialVersionUID = 1L;

	private Integer userID = 0;

	ListModel<AnalyticsList> oneReports, twoReports, threeReports, fourZeroReports, fourOneReports;

	private AnalyticsListData analyticsListData;

	@Wire
	private Button menuTemplate, menuServices; 


	@Wire
	private Checkbox id7, id8, id9, id10, id11, id12, id13, id14, id16, id17, id18, id19, id20, id21, id22, id23, id24, id25, id26;

	@Wire
	private Checkbox id31, id32, id33, id34, id35, id36, id37, id38, id44, id45, id46, id47, id53, id54, id55, id56;

	@Wire
	private Label oneID7, oneID8, oneID9, oneID10, oneID11, oneID12, oneID13, oneID14, oneID16, oneID17, oneID18, oneID19, oneID20, oneID21, oneID22, oneID23, oneID24, oneID25, oneID26;

	@Wire
	private Label oneID31, oneID32, oneID33, oneID34, oneID35, oneID36, oneID37, oneID38, oneID44, oneID45, oneID46, oneID47, oneID53, oneID54, oneID55, oneID56;

	@Wire
	private Label twoID7, twoID8, twoID9, twoID10, twoID11, twoID12, twoID13, twoID14, twoID16, twoID17, twoID18, twoID19, twoID20, twoID21, twoID22, twoID23, twoID24, twoID25, twoID26;

	@Wire
	private Label twoID31, twoID32, twoID33, twoID34, twoID35, twoID36, twoID37, twoID38, twoID44, twoID45, twoID46, twoID47, twoID53, twoID54, twoID55, twoID56;

	@Wire
	private Label threeID7, threeID8, threeID9, threeID10, threeID11, threeID12, threeID13, threeID14, threeID16, threeID17, threeID18, threeID19, threeID20, threeID21, threeID22, threeID23, threeID24, threeID25, threeID26;

	@Wire
	private Label threeID31, threeID32, threeID33, threeID34, threeID35, threeID36, threeID37, threeID38, threeID44, threeID45, threeID46, threeID47, threeID53, threeID54, threeID55, threeID56;

	@Wire
	private Label blockOneTitle, blockTwoTitle, blockThreeTitle, blockFourZeroTitle, blockFourOneTitle, analyticsPeriod, legendOne, legendTwo, legendThree;

	@Wire
	private Button submitButton;
	
	@Wire
	private Checkbox selectedAllOneGridCheckBox, selectedAllTwoGridCheckBox, selectedAllThreeGridCheckBox, selectedAllFourGridCheckBox, selectedAllFiveGridCheckBox;

	@Listen("onClick =#submitButton")
	public void submitData(){

		XSSFWorkbook workbook = new XSSFWorkbook(); 
		XSSFSheet sheet = workbook.createSheet("Assist Analytics Data");
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSSSSS");
		Date date = new Date();
		String saveFileName = ""+ (dateFormat.format(date))+".xlsx";

		Map<String, Object[]> data = new TreeMap<String, Object[]>();
		data.put("0",new Object[] {analyticsPeriod.getValue()});
		data.put("10",new Object[] {"Component", legendOne.getValue(),legendTwo.getValue(),legendThree.getValue()});

		try{

			if(!id7.isChecked() && !id8.isChecked() && !id9.isChecked() && !id10.isChecked() && !id11.isChecked() 
					&& !id12.isChecked() && !id13.isChecked() && !id14.isChecked() && !id16.isChecked() 
					&& !id17.isChecked() && !id18.isChecked() && !id19.isChecked() && !id20.isChecked() 
					&& !id21.isChecked() && !id22.isChecked() && !id23.isChecked() && !id24.isChecked() 
					&& !id25.isChecked() && !id26.isChecked() && !id31.isChecked() && !id32.isChecked() 
					&& !id33.isChecked() && !id34.isChecked() && !id35.isChecked() && !id36.isChecked() 
					&& !id37.isChecked() && !id38.isChecked() && !id44.isChecked() && !id45.isChecked() 
					&& !id46.isChecked() && !id47.isChecked() && !id53.isChecked() && !id54.isChecked() 
					&& !id55.isChecked() && !id56.isChecked()){

				data.put("11",new Object[] {""});
				data.put("12",new Object[] {blockOneTitle.getValue()});
				data.put("13",new Object[] {id7.getLabel(), oneID7.getValue(), twoID7.getValue(), threeID7.getValue()});	
				data.put("14",new Object[] {id8.getLabel(), oneID8.getValue(), twoID8.getValue(), threeID8.getValue()});
				data.put("15",new Object[] {id9.getLabel(), oneID9.getValue(), twoID9.getValue(), threeID9.getValue()});
				data.put("16",new Object[] {id10.getLabel(), oneID10.getValue(), twoID10.getValue(), threeID10.getValue()});
				data.put("17",new Object[] {id11.getLabel(), oneID11.getValue(), twoID11.getValue(), threeID11.getValue()});
				data.put("18",new Object[] {id12.getLabel(), oneID12.getValue(), twoID12.getValue(), threeID12.getValue()});
				data.put("19",new Object[] {id13.getLabel(), oneID13.getValue(), twoID13.getValue(), threeID13.getValue()});	
				data.put("20",new Object[] {id14.getLabel(), oneID14.getValue(), twoID14.getValue(), threeID14.getValue()});
				data.put("21",new Object[] {""});
				data.put("22",new Object[] {blockTwoTitle.getValue()});
				data.put("23",new Object[] {id16.getLabel(), oneID16.getValue(), twoID16.getValue(), threeID16.getValue()});
				data.put("24",new Object[] {id17.getLabel(), oneID17.getValue(), twoID17.getValue(), threeID17.getValue()});
				data.put("25",new Object[] {id18.getLabel(), oneID18.getValue(), twoID18.getValue(), threeID18.getValue()});
				data.put("26",new Object[] {id19.getLabel(), oneID19.getValue(), twoID19.getValue(), threeID19.getValue()});
				data.put("27",new Object[] {id20.getLabel(), oneID20.getValue(), twoID20.getValue(), threeID20.getValue()});
				data.put("28",new Object[] {id21.getLabel(), oneID21.getValue(), twoID21.getValue(), threeID21.getValue()});
				data.put("29",new Object[] {id22.getLabel(), oneID22.getValue(), twoID22.getValue(), threeID22.getValue()});
				data.put("30",new Object[] {id23.getLabel(), oneID23.getValue(), twoID23.getValue(), threeID23.getValue()});
				data.put("31",new Object[] {id24.getLabel(), oneID24.getValue(), twoID24.getValue(), threeID24.getValue()});
				data.put("32",new Object[] {id25.getLabel(), oneID25.getValue(), twoID25.getValue(), threeID25.getValue()});
				data.put("33",new Object[] {id26.getLabel(), oneID26.getValue(), twoID26.getValue(), threeID26.getValue()});
				data.put("34",new Object[] {""});
				data.put("35",new Object[] {blockThreeTitle.getValue()});
				data.put("36",new Object[] {id31.getLabel(), oneID31.getValue(), twoID31.getValue(), threeID31.getValue()});				
				data.put("37",new Object[] {id32.getLabel(), oneID32.getValue(), twoID32.getValue(), threeID32.getValue()});
				data.put("38",new Object[] {id33.getLabel(), oneID33.getValue(), twoID33.getValue(), threeID33.getValue()});
				data.put("39",new Object[] {id34.getLabel(), oneID34.getValue(), twoID34.getValue(), threeID34.getValue()});
				data.put("40",new Object[] {id35.getLabel(), oneID35.getValue(), twoID35.getValue(), threeID35.getValue()});
				data.put("41",new Object[] {id36.getLabel(), oneID36.getValue(), twoID36.getValue(), threeID36.getValue()});
				data.put("42",new Object[] {id37.getLabel(), oneID37.getValue(), twoID37.getValue(), threeID37.getValue()});
				data.put("43",new Object[] {id38.getLabel(), oneID38.getValue(), twoID38.getValue(), threeID38.getValue()});
				data.put("44",new Object[] {""});
				data.put("45",new Object[] {blockFourZeroTitle.getValue()});
				data.put("46",new Object[] {id44.getLabel(), oneID44.getValue(), twoID44.getValue(), threeID44.getValue()});
				data.put("47",new Object[] {id45.getLabel(), oneID45.getValue(), twoID45.getValue(), threeID45.getValue()});
				data.put("48",new Object[] {id46.getLabel(), oneID46.getValue(), twoID46.getValue(), threeID46.getValue()});
				data.put("49",new Object[] {id47.getLabel(), oneID47.getValue(), twoID47.getValue(), threeID47.getValue()});
				data.put("50",new Object[] {""});
				data.put("51",new Object[] {blockFourOneTitle.getValue()});
				data.put("52",new Object[] {id53.getLabel(), oneID53.getValue(), twoID53.getValue(), threeID53.getValue()});
				data.put("53",new Object[] {id54.getLabel(), oneID54.getValue(), twoID54.getValue(), threeID54.getValue()});
				data.put("54",new Object[] {id55.getLabel(), oneID55.getValue(), twoID55.getValue(), threeID55.getValue()});
				data.put("55",new Object[] {id56.getLabel(), oneID56.getValue(), twoID56.getValue(), threeID56.getValue()});
			}


			if(id7.isChecked() || id8.isChecked() || id9.isChecked() || id10.isChecked() || id11.isChecked() || id12.isChecked() || id13.isChecked() || id14.isChecked()){
				data.put("11",new Object[] {""});
				data.put("12",new Object[] {blockOneTitle.getValue()});
			}

			if(id7.isChecked()){
				data.put("13",new Object[] {id7.getLabel(), oneID7.getValue(), twoID7.getValue(), threeID7.getValue()});	
			}

			if(id8.isChecked()){
				data.put("14",new Object[] {id8.getLabel(), oneID8.getValue(), twoID8.getValue(), threeID8.getValue()});
			}

			if(id9.isChecked()){
				data.put("15",new Object[] {id9.getLabel(), oneID9.getValue(), twoID9.getValue(), threeID9.getValue()});
			}

			if(id10.isChecked()){
				data.put("16",new Object[] {id10.getLabel(), oneID10.getValue(), twoID10.getValue(), threeID10.getValue()});
			}

			if(id11.isChecked()){
				data.put("17",new Object[] {id11.getLabel(), oneID11.getValue(), twoID11.getValue(), threeID11.getValue()});
			}

			if(id12.isChecked()){
				data.put("18",new Object[] {id12.getLabel(), oneID12.getValue(), twoID12.getValue(), threeID12.getValue()});
			}

			if(id13.isChecked()){
				data.put("19",new Object[] {id13.getLabel(), oneID13.getValue(), twoID13.getValue(), threeID13.getValue()});	
			}

			if(id14.isChecked()){
				data.put("20",new Object[] {id14.getLabel(), oneID14.getValue(), twoID14.getValue(), threeID14.getValue()});
			}

			if(id16.isChecked() || id17.isChecked() || id18.isChecked() || id19.isChecked() || id20.isChecked() || id21.isChecked() || id22.isChecked() || id23.isChecked() || id24.isChecked() || id25.isChecked() || id26.isChecked()){
				data.put("21",new Object[] {""});
				data.put("22",new Object[] {blockTwoTitle.getValue()});
			}

			if(id16.isChecked()){
				data.put("23",new Object[] {id16.getLabel(), oneID16.getValue(), twoID16.getValue(), threeID16.getValue()});
			}

			if(id17.isChecked()){
				data.put("24",new Object[] {id17.getLabel(), oneID17.getValue(), twoID17.getValue(), threeID17.getValue()});
			}

			if(id18.isChecked()){
				data.put("25",new Object[] {id18.getLabel(), oneID18.getValue(), twoID18.getValue(), threeID18.getValue()});
			}

			if(id19.isChecked()){
				data.put("26",new Object[] {id19.getLabel(), oneID19.getValue(), twoID19.getValue(), threeID19.getValue()});
			}

			if(id20.isChecked()){
				data.put("27",new Object[] {id20.getLabel(), oneID20.getValue(), twoID20.getValue(), threeID20.getValue()});
			}

			if(id21.isChecked()){
				data.put("28",new Object[] {id21.getLabel(), oneID21.getValue(), twoID21.getValue(), threeID21.getValue()});
			}

			if(id22.isChecked()){
				data.put("29",new Object[] {id22.getLabel(), oneID22.getValue(), twoID22.getValue(), threeID22.getValue()});
			}

			if(id23.isChecked()){
				data.put("30",new Object[] {id23.getLabel(), oneID23.getValue(), twoID23.getValue(), threeID23.getValue()});
			}

			if(id24.isChecked()){
				data.put("31",new Object[] {id24.getLabel(), oneID24.getValue(), twoID24.getValue(), threeID24.getValue()});
			}

			if(id25.isChecked()){
				data.put("32",new Object[] {id25.getLabel(), oneID25.getValue(), twoID25.getValue(), threeID25.getValue()});
			}

			if(id26.isChecked()){
				data.put("33",new Object[] {id26.getLabel(), oneID26.getValue(), twoID26.getValue(), threeID26.getValue()});
			}

			if(id31.isChecked() || id32.isChecked() || id33.isChecked() || id34.isChecked() || id35.isChecked() || id36.isChecked() || id37.isChecked() || id38.isChecked()){
				data.put("34",new Object[] {""});
				data.put("35",new Object[] {blockThreeTitle.getValue()});
			}

			if(id31.isChecked()){
				data.put("36",new Object[] {id31.getLabel(), oneID31.getValue(), twoID31.getValue(), threeID31.getValue()});				
			}

			if(id32.isChecked()){
				data.put("37",new Object[] {id32.getLabel(), oneID32.getValue(), twoID32.getValue(), threeID32.getValue()});
			}

			if(id33.isChecked()){
				data.put("38",new Object[] {id33.getLabel(), oneID33.getValue(), twoID33.getValue(), threeID33.getValue()});
			}

			if(id34.isChecked()){
				data.put("39",new Object[] {id34.getLabel(), oneID34.getValue(), twoID34.getValue(), threeID34.getValue()});
			}

			if(id35.isChecked()){
				data.put("40",new Object[] {id35.getLabel(), oneID35.getValue(), twoID35.getValue(), threeID35.getValue()});
			}

			if(id36.isChecked()){
				data.put("41",new Object[] {id36.getLabel(), oneID36.getValue(), twoID36.getValue(), threeID36.getValue()});
			}

			if(id37.isChecked()){
				data.put("42",new Object[] {id37.getLabel(), oneID37.getValue(), twoID37.getValue(), threeID37.getValue()});
			}

			if(id38.isChecked()){
				data.put("43",new Object[] {id38.getLabel(), oneID38.getValue(), twoID38.getValue(), threeID38.getValue()});
			}

			if(id44.isChecked() || id45.isChecked() || id46.isChecked() || id47.isChecked()){
				data.put("44",new Object[] {""});
				data.put("45",new Object[] {blockFourZeroTitle.getValue()});
			}

			if(id44.isChecked()){
				data.put("46",new Object[] {id44.getLabel(), oneID44.getValue(), twoID44.getValue(), threeID44.getValue()});
			}

			if(id45.isChecked()){
				data.put("47",new Object[] {id45.getLabel(), oneID45.getValue(), twoID45.getValue(), threeID45.getValue()});
			}

			if(id46.isChecked()){
				data.put("48",new Object[] {id46.getLabel(), oneID46.getValue(), twoID46.getValue(), threeID46.getValue()});
			}

			if(id47.isChecked()){
				data.put("49",new Object[] {id47.getLabel(), oneID47.getValue(), twoID47.getValue(), threeID47.getValue()});
			}

			if(id53.isChecked() || id54.isChecked() || id55.isChecked() || id56.isChecked()){
				data.put("50",new Object[] {""});
				data.put("51",new Object[] {blockFourOneTitle.getValue()});
			}

			if(id53.isChecked()){
				data.put("52",new Object[] {id53.getLabel(), oneID53.getValue(), twoID53.getValue(), threeID53.getValue()});
			}

			if(id54.isChecked()){
				data.put("53",new Object[] {id54.getLabel(), oneID54.getValue(), twoID54.getValue(), threeID54.getValue()});
			}

			if(id55.isChecked()){
				data.put("54",new Object[] {id55.getLabel(), oneID55.getValue(), twoID55.getValue(), threeID55.getValue()});
			}

			if(id56.isChecked()){
				data.put("55",new Object[] {id56.getLabel(), oneID56.getValue(), twoID56.getValue(), threeID56.getValue()});
			}

		}catch(Exception e) 
		{
			e.printStackTrace();
		}

		//Iterate over data and write to sheet
		Set<String> keyset = data.keySet();
		int rownum = 0;
		for (String key : keyset)
		{
			Row row = sheet.createRow(rownum++);
			Object [] objArr = data.get(key);
			int cellnum = 0;
			for (Object obj : objArr)
			{
				Cell cell = row.createCell(cellnum++);
				if(obj instanceof String)
					cell.setCellValue((String)obj);
				else if(obj instanceof Integer)
					cell.setCellValue((Integer)obj);
			}
		}

		try 
		{
			FileOutputStream out = new FileOutputStream(new File(Configuration.ANALYTICS_SPREADSHEET_EXPORT_PATH+saveFileName));
			workbook.write(out);
			out.close();

			Session sess = Sessions.getCurrent();
			sess.setAttribute("downloadFileName", saveFileName);
			sess.setAttribute("analyticsSearchStartDate", null);
			sess.setAttribute("analyticsSearchEndDate", null);
			Executions.sendRedirect("/DownloadAnalytics.zul");

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
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

	@Listen("onClick =#menuServices")
	public void menuServicesRedir(){
		try{
			Executions.sendRedirect("/ServiceSelection.zul");
		}catch(Exception e){

		}
	}
	
	@Listen("onClick =#menuVidLibrary")
	public void menuVidLibraryRedir(){
		try{
			Executions.sendRedirect("/VideoLibraryList.zul");
		}catch(Exception e){
			
		}
	}
	

	@Listen("onClick =#menuTemplate")
	public void menuSelectRedir(){
		try{
			Executions.sendRedirect("/SelectForm.zul");
		}catch(Exception e){

		}
	}

	@Listen("onCheck =#selectedAllOneGridCheckBox")
	public void selectOneGrid(CheckEvent e){
		id7.setChecked(e.isChecked());
		id8.setChecked(e.isChecked());
		id9.setChecked(e.isChecked());
		id10.setChecked(e.isChecked());
		id11.setChecked(e.isChecked());
		id12.setChecked(e.isChecked()); 
		id13.setChecked(e.isChecked()); 
		id14.setChecked(e.isChecked()); 
	}

	@Listen("onCheck =#selectedAllTwoGridCheckBox")
	public void selectTwoGrid(CheckEvent e){
		id16.setChecked(e.isChecked());
		id17.setChecked(e.isChecked());
		id18.setChecked(e.isChecked());
		id19.setChecked(e.isChecked());
		id20.setChecked(e.isChecked());
		id21.setChecked(e.isChecked()); 
		id22.setChecked(e.isChecked()); 
		id23.setChecked(e.isChecked());
		id24.setChecked(e.isChecked()); 
		id25.setChecked(e.isChecked()); 
		id26.setChecked(e.isChecked());
	}

	@Listen("onCheck =#selectedAllThreeGridCheckBox")
	public void selectThreeGrid(CheckEvent e){
		id31.setChecked(e.isChecked());
		id32.setChecked(e.isChecked());
		id33.setChecked(e.isChecked());
		id34.setChecked(e.isChecked());
		id35.setChecked(e.isChecked());
		id36.setChecked(e.isChecked()); 
		id37.setChecked(e.isChecked()); 
		id38.setChecked(e.isChecked()); 
	}
	
	@Listen("onCheck =#selectedAllFourGridCheckBox")
	public void selectFourGrid(CheckEvent e){
		id44.setChecked(e.isChecked());
		id45.setChecked(e.isChecked());
		id46.setChecked(e.isChecked());
		id47.setChecked(e.isChecked());
	}

	@Listen("onCheck =#selectedAllFiveGridCheckBox")
	public void selectFiveGrid(CheckEvent e){
		id53.setChecked(e.isChecked());
		id54.setChecked(e.isChecked());
		id55.setChecked(e.isChecked());
		id56.setChecked(e.isChecked());
	}


	public AnalyticsListRenderer(){
		Session sess = Sessions.getCurrent();
		this.setUserID((Integer) sess.getAttribute("assist_user_id"));
		if(this.getUserID() == null){
			Executions.sendRedirect("/welcome_user.zul");
		}else{
			oneReports = new ListModelList<AnalyticsList>(new AnalyticsListData().getBlockOneReports());
			twoReports = new ListModelList<AnalyticsList>(new AnalyticsListData().getBlockTwoReports());
			threeReports = new ListModelList<AnalyticsList>(new AnalyticsListData().getBlockThreeReports());
			fourZeroReports = new ListModelList<AnalyticsList>(new AnalyticsListData().getBlockFourZeroReports());
			fourOneReports = new ListModelList<AnalyticsList>(new AnalyticsListData().getBlockFourOneReports());
			analyticsListData = new AnalyticsListData();
		}
	}

	public ListModel<AnalyticsList> getBlockOneReports() {
		return oneReports;
	}

	public ListModel<AnalyticsList> getBlockTwoReports() {
		return twoReports;
	}

	public ListModel<AnalyticsList> getBlockThreeReports() {
		return threeReports;
	}

	public ListModel<AnalyticsList> getBlockFourZeroReports() {
		return fourZeroReports;
	}

	public ListModel<AnalyticsList> getBlockFourOneReports() {
		return fourOneReports;
	}


	public Integer getUserID() {
		return userID;
	}


	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public AnalyticsListData getAnalyticsListData() {
		return analyticsListData;
	}
	public void setAnalyticsListData(AnalyticsListData analyticsListData) {
		this.analyticsListData = analyticsListData;
	}


}
