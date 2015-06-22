package com.servicesform;

import java.awt.Button;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Label;
import org.zkoss.zul.Window;

import com.innoppl.dbconnect.SingleConnect;
import com.servicesform.ActiveServicesInventory;

public class ActiveServicesController extends SelectorComposer<Component>  {
	
	private static final long serialVersionUID = 1L;
	
	private ActiveServicesInventory activeServicesInventory;
	
	private SingleConnect singleConnect = new SingleConnect();
	
	private Integer userID = 0;
	
	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public ActiveServicesController(){
		Session sess = Sessions.getCurrent();
		this.setUserID((Integer) sess.getAttribute("assist_user_id"));
		if(this.getUserID() == null){
			Executions.sendRedirect("/welcome_user.zul");
		}else{
			activeServicesInventory = new ActiveServicesInventory(this.getUserID());
		}
	}
	
	public ActiveServicesInventory getActiveServicesInventory() {
        return activeServicesInventory;
    }
	
	private Integer serviceID = 0;

	@Wire
	private Window win;
	
	@Wire
	private Button submitButton;
	
	@Wire
	private Label transmission, oil, fuel, coolant, power, brake, mileage, additional;
	

	@Wire
	private Button menuTemplate, menuServices, menuReports, activeService, editService; 
	
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
	
	@Listen("onClick =#menuTemplate")
	public void menuServicesRedir(){
		try{
			Executions.sendRedirect("/SelectForm.zul");
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
	
	
	@Listen("onClick =#menuReports")
	public void menuReportsRedir(){
		try{
			Executions.sendRedirect("/reports.zul");
		}catch(Exception e){
			
		}
	}
	
	@Listen("onClick =#activeService")
	public void activeFormRedir(){
		try{
			Executions.sendRedirect("/ServiceSelection.zul");
		}catch(Exception e){
			
		}
	}
	
	@Listen("onClick =#transmission")
	public void transmissionSetRedirect(){
		Connection conn = null;
		conn = singleConnect.connectToDatabaseOrDie();
		this.setServiceID(1);
		
		try{
			Statement st = conn.createStatement();
		    ResultSet rs;
		    rs = st.executeQuery("select user_service_id from user_services where user_id = "+ this.getUserID() +" and service_id = 1");
		    while(rs.next()){
		    	this.setServiceID(rs.getInt("user_service_id"));
		    }
			Session sess = Sessions.getCurrent();
			sess.setAttribute("assist_service_id", this.getServiceID());
			Executions.sendRedirect("/ServiceDescription.zul");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Listen("onClick =#oil")
	public void oilSetRedirect(){
		Connection conn = null;
		conn = singleConnect.connectToDatabaseOrDie();
		this.setServiceID(2);
		
		try{
			Statement st = conn.createStatement();
		    ResultSet rs;
		    rs = st.executeQuery("select user_service_id from user_services where user_id = "+ this.getUserID() +" and service_id = 2");
		    while(rs.next()){
		    	this.setServiceID(rs.getInt("user_service_id"));
		    }
			Session sess = Sessions.getCurrent();
			sess.setAttribute("assist_service_id", this.getServiceID());
			Executions.sendRedirect("/ServiceDescription.zul");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Listen("onClick =#fuel")
	public void fuelSetRedirect(){
		Connection conn = null;
		conn = singleConnect.connectToDatabaseOrDie();
		this.setServiceID(3);
		
		try{
			Statement st = conn.createStatement();
		    ResultSet rs;
		    rs = st.executeQuery("select user_service_id from user_services where user_id = "+ this.getUserID() +" and service_id = 3");
		    while(rs.next()){
		    	this.setServiceID(rs.getInt("user_service_id"));
		    }
			Session sess = Sessions.getCurrent();
			sess.setAttribute("assist_service_id", this.getServiceID());
			Executions.sendRedirect("/ServiceFuelDescription.zul");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Listen("onClick =#coolant")
	public void coolantSetRedirect(){
		Connection conn = null;
		conn = singleConnect.connectToDatabaseOrDie();
		this.setServiceID(4);
		
		try{
			Statement st = conn.createStatement();
		    ResultSet rs;
		    rs = st.executeQuery("select user_service_id from user_services where user_id = "+ this.getUserID() +" and service_id = 4");
		    while(rs.next()){
		    	this.setServiceID(rs.getInt("user_service_id"));
		    }
			Session sess = Sessions.getCurrent();
			sess.setAttribute("assist_service_id", this.getServiceID());
			Executions.sendRedirect("/ServiceDescription.zul");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Listen("onClick =#power")
	public void powerSetRedirect(){
		Connection conn = null;
		conn = singleConnect.connectToDatabaseOrDie();
		this.setServiceID(5);
		
		try{
			Statement st = conn.createStatement();
		    ResultSet rs;
		    rs = st.executeQuery("select user_service_id from user_services where user_id = "+ this.getUserID() +" and service_id = 5");
		    while(rs.next()){
		    	this.setServiceID(rs.getInt("user_service_id"));
		    }
			Session sess = Sessions.getCurrent();
			sess.setAttribute("assist_service_id", this.getServiceID());
			Executions.sendRedirect("/ServiceDescription.zul");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Listen("onClick =#brake")
	public void brakeSetRedirect(){
		Connection conn = null;
		conn = singleConnect.connectToDatabaseOrDie();
		this.setServiceID(6);
		
		try{
			Statement st = conn.createStatement();
		    ResultSet rs;
		    rs = st.executeQuery("select user_service_id from user_services where user_id = "+ this.getUserID() +" and service_id = 6");
		    while(rs.next()){
		    	this.setServiceID(rs.getInt("user_service_id"));
		    }
			Session sess = Sessions.getCurrent();
			sess.setAttribute("assist_service_id", this.getServiceID());
			Executions.sendRedirect("/ServiceDescription.zul");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Listen("onClick =#mileage")
	public void mileageSetRedirect(){
		Connection conn = null;
		conn = singleConnect.connectToDatabaseOrDie();
		this.setServiceID(7);
		
		try{
			Statement st = conn.createStatement();
		    ResultSet rs;
		    rs = st.executeQuery("select user_service_id from user_services where user_id = "+ this.getUserID() +" and service_id = 7");
		    while(rs.next()){
		    	this.setServiceID(rs.getInt("user_service_id"));
		    }
			Session sess = Sessions.getCurrent();
			sess.setAttribute("assist_service_id", this.getServiceID());
			System.out.println(sess.getAttribute("assist_service_id"));
			//Executions.sendRedirect("/ServiceMileageDescription.zul");
			Executions.getCurrent().sendRedirect("/ServiceMileageDescription.zul");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Listen("onClick =#additional")
	public void additionalSetRedirect(){
		Connection conn = null;
		conn = singleConnect.connectToDatabaseOrDie();
		this.setServiceID(8);
		
		try{
			Statement st = conn.createStatement();
		    ResultSet rs;
		    rs = st.executeQuery("select user_service_id from user_services where user_id = "+ this.getUserID() +" and service_id = 8");
		    while(rs.next()){
		    	this.setServiceID(rs.getInt("user_service_id"));
		    }
			Session sess = Sessions.getCurrent();
			sess.setAttribute("assist_service_id", this.getServiceID());
			Executions.sendRedirect("/ServiceDescription.zul");
		}catch(Exception e){
			e.printStackTrace();
		}
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
	public Integer getServiceID() {
		return serviceID;
	}

	public void setServiceID(Integer serviceID) {
		this.serviceID = serviceID;
	}
	
}
