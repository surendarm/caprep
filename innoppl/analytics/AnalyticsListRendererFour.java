package com.innoppl.analytics;

import java.awt.Button;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;

import com.innoppl.config.Configuration;

public class AnalyticsListRendererFour extends SelectorComposer<Component> {
	private static final long serialVersionUID = 1L;

	private Integer userID = 0;

	ListModel<AnalyticsList> oneReports, twoReports, threeReports, fourZeroReports, fourOneReports, fiveReports;

	private AnalyticsListDataFour analyticsListDataFour;

	@Wire
	private Button menuTemplate, menuServices; 

	@Wire
	private Checkbox id7, id8, id9, id10, id14, id15, id16, id17, id18, id19, id20, id22, id23, id24, id25, id26;

	@Wire
	private Checkbox id32, id34, id36, id38, id41, id42, id43, id44, id62, id63, id64, id65;

	@Wire
	private Label oneID7, oneID8, oneID9, oneID10, oneID14, oneID16, oneID15, oneID17, oneID18, oneID19, oneID20, oneID22, oneID23, oneID24, oneID25, oneID26;

	@Wire
	private Label oneID32, oneID34, oneID36, oneID38, oneID41, oneID42, oneID43, oneID44, oneID62, oneID63, oneID64, oneID65;

	@Wire
	private Label twoID7, twoID8, twoID9, twoID10, twoID14, twoID15, twoID16, twoID17, twoID18, twoID19, twoID20, twoID22, twoID23, twoID24, twoID25, twoID26;

	@Wire
	private Label twoID32, twoID34, twoID36, twoID38, twoID41, twoID42, twoID43, twoID44, twoID62, twoID63, twoID64, twoID65;

	@Wire
	private Label threeID7, threeID8, threeID9, threeID10, threeID14, threeID15, threeID16, threeID17, threeID18, threeID19, threeID20, threeID22, threeID23, threeID24, threeID25, threeID26;

	@Wire
	private Label threeID32, threeID34, threeID36, threeID38, threeID41, threeID42, threeID43, threeID44, threeID62, threeID63, threeID64, threeID65;

	@Wire
	private Label blockOneTitle, blockTwoTitle, blockThreeTitle, blockFourZeroTitle, blockFourOneTitle, blockFiveTitle, analyticsPeriod, legendOne, legendTwo, legendThree;

	@Wire
	private Checkbox selectedAllOneGridCheckBox, selectedAllTwoGridCheckBox, selectedAllThreeGridCheckBox, selectedAllFourGridCheckBox, selectedAllFiveGridCheckBox, selectedAllSixGridCheckBox;
	
	@Wire
	private Button submitButton;

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
			if(!id7.isChecked() && !id8.isChecked() && !id9.isChecked() && !id10.isChecked() && !id14.isChecked() 
					&& !id15.isChecked() && !id16.isChecked() && !id17.isChecked() && !id18.isChecked() 
					&& !id19.isChecked() && !id20.isChecked() && !id22.isChecked() && !id23.isChecked() 
					&& !id24.isChecked() && !id25.isChecked() && !id26.isChecked() && !id32.isChecked() 
					&& !id34.isChecked() && !id36.isChecked() && !id38.isChecked() && !id41.isChecked() 
					&& !id42.isChecked() && !id43.isChecked() && !id44.isChecked() && !id62.isChecked() 
					&& !id63.isChecked() && !id64.isChecked() && !id65.isChecked()){
				data.put("11",new Object[] {""});
				data.put("12",new Object[] {blockOneTitle.getValue()});
				data.put("13",new Object[] {id7.getLabel(), oneID7.getValue(), twoID7.getValue(), threeID7.getValue()});	
				data.put("14",new Object[] {id8.getLabel(), oneID8.getValue(), twoID8.getValue(), threeID8.getValue()});
				data.put("15",new Object[] {id9.getLabel(), oneID9.getValue(), twoID9.getValue(), threeID9.getValue()});
				data.put("16",new Object[] {id10.getLabel(), oneID10.getValue(), twoID10.getValue(), threeID10.getValue()});
				data.put("19",new Object[] {""});
				data.put("20",new Object[] {blockTwoTitle.getValue()});
				data.put("21",new Object[] {id14.getLabel(), oneID14.getValue(), twoID14.getValue(), threeID14.getValue()});
				data.put("22",new Object[] {id15.getLabel(), oneID15.getValue(), twoID15.getValue(), threeID15.getValue()});
				data.put("23",new Object[] {id16.getLabel(), oneID16.getValue(), twoID16.getValue(), threeID16.getValue()});
				data.put("24",new Object[] {id17.getLabel(), oneID17.getValue(), twoID17.getValue(), threeID17.getValue()});
				data.put("25",new Object[] {id18.getLabel(), oneID18.getValue(), twoID18.getValue(), threeID18.getValue()});
				data.put("26",new Object[] {id19.getLabel(), oneID19.getValue(), twoID19.getValue(), threeID19.getValue()});
				data.put("27",new Object[] {id20.getLabel(), oneID20.getValue(), twoID20.getValue(), threeID20.getValue()});
				data.put("28",new Object[] {""});
				data.put("29",new Object[] {blockThreeTitle.getValue()});
				data.put("30",new Object[] {id22.getLabel(), oneID22.getValue(), twoID22.getValue(), threeID22.getValue()});
				data.put("31",new Object[] {id23.getLabel(), oneID23.getValue(), twoID23.getValue(), threeID23.getValue()});
				data.put("32",new Object[] {id24.getLabel(), oneID24.getValue(), twoID24.getValue(), threeID24.getValue()});
				data.put("33",new Object[] {id25.getLabel(), oneID25.getValue(), twoID25.getValue(), threeID25.getValue()});
				data.put("34",new Object[] {id26.getLabel(), oneID26.getValue(), twoID26.getValue(), threeID26.getValue()});
				data.put("35",new Object[] {""});
				data.put("36",new Object[] {blockFourZeroTitle.getValue()});
				data.put("37",new Object[] {id32.getLabel(), oneID32.getValue(), twoID32.getValue(), threeID32.getValue()});
				data.put("38",new Object[] {id34.getLabel(), oneID34.getValue(), twoID34.getValue(), threeID34.getValue()});
				data.put("39",new Object[] {id36.getLabel(), oneID36.getValue(), twoID36.getValue(), threeID36.getValue()});
				data.put("40",new Object[] {id38.getLabel(), oneID38.getValue(), twoID38.getValue(), threeID38.getValue()});
				data.put("44",new Object[] {""});
				data.put("45",new Object[] {blockFourOneTitle.getValue()});
				data.put("46",new Object[] {id41.getLabel(), oneID41.getValue(), twoID41.getValue(), threeID41.getValue()});
				data.put("47",new Object[] {id42.getLabel(), oneID42.getValue(), twoID42.getValue(), threeID42.getValue()});
				data.put("48",new Object[] {id43.getLabel(), oneID43.getValue(), twoID43.getValue(), threeID43.getValue()});
				data.put("49",new Object[] {id44.getLabel(), oneID44.getValue(), twoID44.getValue(), threeID44.getValue()});
				data.put("50",new Object[] {""});
				data.put("51",new Object[] {blockFiveTitle.getValue()});
				data.put("52",new Object[] {id62.getLabel(), oneID62.getValue(), twoID62.getValue(), threeID62.getValue()});
				data.put("53",new Object[] {id63.getLabel(), oneID63.getValue(), twoID63.getValue(), threeID63.getValue()});
				data.put("54",new Object[] {id64.getLabel(), oneID64.getValue(), twoID64.getValue(), threeID64.getValue()});
				data.put("55",new Object[] {id65.getLabel(), oneID65.getValue(), twoID65.getValue(), threeID65.getValue()});
			}			
			if(id7.isChecked() || id8.isChecked() || id9.isChecked() || id10.isChecked()){
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


			if(id14.isChecked() || id15.isChecked() || id16.isChecked() || id17.isChecked() || id18.isChecked() || id19.isChecked() || id20.isChecked()){
				data.put("19",new Object[] {""});
				data.put("20",new Object[] {blockTwoTitle.getValue()});
			}

			if(id14.isChecked()){
				data.put("21",new Object[] {id14.getLabel(), oneID14.getValue(), twoID14.getValue(), threeID14.getValue()});
			}

			if(id15.isChecked()){
				data.put("22",new Object[] {id15.getLabel(), oneID15.getValue(), twoID15.getValue(), threeID15.getValue()});
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

			if(id22.isChecked() || id23.isChecked() || id24.isChecked() || id25.isChecked() || id26.isChecked()){
				data.put("28",new Object[] {""});
				data.put("29",new Object[] {blockThreeTitle.getValue()});
			}

			if(id22.isChecked()){
				data.put("30",new Object[] {id22.getLabel(), oneID22.getValue(), twoID22.getValue(), threeID22.getValue()});
			}

			if(id23.isChecked()){
				data.put("31",new Object[] {id23.getLabel(), oneID23.getValue(), twoID23.getValue(), threeID23.getValue()});
			}

			if(id24.isChecked()){
				data.put("32",new Object[] {id24.getLabel(), oneID24.getValue(), twoID24.getValue(), threeID24.getValue()});
			}

			if(id25.isChecked()){
				data.put("33",new Object[] {id25.getLabel(), oneID25.getValue(), twoID25.getValue(), threeID25.getValue()});
			}

			if(id26.isChecked()){
				data.put("34",new Object[] {id26.getLabel(), oneID26.getValue(), twoID26.getValue(), threeID26.getValue()});
			}

			if(id32.isChecked() || id34.isChecked() || id36.isChecked() || id38.isChecked()){
				data.put("35",new Object[] {""});
				data.put("36",new Object[] {blockFourZeroTitle.getValue()});
			}


			if(id32.isChecked()){
				data.put("37",new Object[] {id32.getLabel(), oneID32.getValue(), twoID32.getValue(), threeID32.getValue()});
			}

			if(id34.isChecked()){
				data.put("38",new Object[] {id34.getLabel(), oneID34.getValue(), twoID34.getValue(), threeID34.getValue()});
			}

			if(id36.isChecked()){
				data.put("39",new Object[] {id36.getLabel(), oneID36.getValue(), twoID36.getValue(), threeID36.getValue()});
			}

			if(id38.isChecked()){
				data.put("40",new Object[] {id38.getLabel(), oneID38.getValue(), twoID38.getValue(), threeID38.getValue()});
			}

			if(id41.isChecked() || id42.isChecked() || id43.isChecked() || id44.isChecked()){
				data.put("44",new Object[] {""});
				data.put("45",new Object[] {blockFourOneTitle.getValue()});
			}

			if(id41.isChecked()){
				data.put("46",new Object[] {id41.getLabel(), oneID41.getValue(), twoID41.getValue(), threeID41.getValue()});
			}

			if(id42.isChecked()){
				data.put("47",new Object[] {id42.getLabel(), oneID42.getValue(), twoID42.getValue(), threeID42.getValue()});
			}

			if(id43.isChecked()){
				data.put("48",new Object[] {id43.getLabel(), oneID43.getValue(), twoID43.getValue(), threeID43.getValue()});
			}

			if(id44.isChecked()){
				data.put("49",new Object[] {id44.getLabel(), oneID44.getValue(), twoID44.getValue(), threeID44.getValue()});
			}

			if(id62.isChecked() || id63.isChecked() || id64.isChecked() || id65.isChecked()){
				data.put("50",new Object[] {""});
				data.put("51",new Object[] {blockFiveTitle.getValue()});
			}

			if(id62.isChecked()){
				data.put("52",new Object[] {id62.getLabel(), oneID62.getValue(), twoID62.getValue(), threeID62.getValue()});
			}

			if(id63.isChecked()){
				data.put("53",new Object[] {id63.getLabel(), oneID63.getValue(), twoID63.getValue(), threeID63.getValue()});
			}

			if(id64.isChecked()){
				data.put("54",new Object[] {id64.getLabel(), oneID64.getValue(), twoID64.getValue(), threeID64.getValue()});
			}

			if(id65.isChecked()){
				data.put("55",new Object[] {id65.getLabel(), oneID65.getValue(), twoID65.getValue(), threeID65.getValue()});
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
	}

	@Listen("onCheck =#selectedAllTwoGridCheckBox")
	public void selectTwoGrid(CheckEvent e){
		id14.setChecked(e.isChecked());
		id15.setChecked(e.isChecked());
		id16.setChecked(e.isChecked());
		id17.setChecked(e.isChecked());
		id18.setChecked(e.isChecked());
		id19.setChecked(e.isChecked());
		id20.setChecked(e.isChecked());
	}
	
	@Listen("onCheck =#selectedAllThreeGridCheckBox")
	public void selectThreeGrid(CheckEvent e){
		id22.setChecked(e.isChecked());
		id23.setChecked(e.isChecked());
		id24.setChecked(e.isChecked());
		id25.setChecked(e.isChecked());
		id26.setChecked(e.isChecked());
	}

	@Listen("onCheck =#selectedAllFourGridCheckBox")
	public void selectFourGrid(CheckEvent e){
		id32.setChecked(e.isChecked());
		id34.setChecked(e.isChecked());
		id36.setChecked(e.isChecked());
		id38.setChecked(e.isChecked());
	}

	@Listen("onCheck =#selectedAllFiveGridCheckBox")
	public void selectFiveGrid(CheckEvent e){
		id41.setChecked(e.isChecked());
		id42.setChecked(e.isChecked());
		id43.setChecked(e.isChecked());
		id44.setChecked(e.isChecked());
	}

	@Listen("onCheck =#selectedAllSixGridCheckBox")
	public void selectSixGrid(CheckEvent e){
		id62.setChecked(e.isChecked());
		id63.setChecked(e.isChecked());
		id64.setChecked(e.isChecked());
		id65.setChecked(e.isChecked());
	}

	public AnalyticsListRendererFour(){
		Session sess = Sessions.getCurrent();
		this.setUserID((Integer) sess.getAttribute("assist_user_id"));
		if(this.getUserID() == null){
			Executions.sendRedirect("/welcome_user.zul");
		}else{
			oneReports = new ListModelList<AnalyticsList>(new AnalyticsListDataFour().getBlockOneReports());
			twoReports = new ListModelList<AnalyticsList>(new AnalyticsListDataFour().getBlockTwoReports());
			threeReports = new ListModelList<AnalyticsList>(new AnalyticsListDataFour().getBlockThreeReports());
			fourZeroReports = new ListModelList<AnalyticsList>(new AnalyticsListDataFour().getBlockFourZeroReports());
			fourOneReports = new ListModelList<AnalyticsList>(new AnalyticsListDataFour().getBlockFourOneReports());
			fiveReports = new ListModelList<AnalyticsList>(new AnalyticsListDataFour().getBlockFiveReports());
			analyticsListDataFour = new AnalyticsListDataFour();
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

	public ListModel<AnalyticsList> getBlockFiveReports() {
		return fiveReports;
	}

	public Integer getUserID() {
		return userID;
	}


	public void setUserID(Integer userID) {
		this.userID = userID;
	}


	public AnalyticsListDataFour getAnalyticsListDataFour() {
		return analyticsListDataFour;
	}

	public void setAnalyticsListDataFour(AnalyticsListDataFour analyticsListDataFour) {
		this.analyticsListDataFour = analyticsListDataFour;
	}



}
