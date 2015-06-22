package com.innoppl.analytics;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;

public class AnalyticsListRendererOne  extends SelectorComposer<Component>  {

	private static final long serialVersionUID = 1L;

	
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
	
	public AnalyticsListRendererOne(){
		
		
	}

}
