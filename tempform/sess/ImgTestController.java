package com.tempform.sess;

import java.awt.Button;
import java.io.File;
import java.util.Random;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Label;
import org.zkoss.zul.Window;


import com.tempform.sess.ImgTestInventory;

public class ImgTestController extends SelectorComposer<Component>  {

	private static final long serialVersionUID = 1L;
	
	private ImgTestInventory imgTestInventory = new ImgTestInventory();
	
	public ImgTestInventory getImgTestInventory() {
        return imgTestInventory;
    }

	public ImgTestController(){
		System.out.println("From Constructor");
		Random rand = new Random();
		int  n = rand.nextInt(1000000) + 1;
		System.out.println(n);
		
		System.out.println("test");
	}
	
	@Wire
	private Window win;
	
	@Wire
	private Button submitButton;
	
	@Wire
	private Label layout;
	
	@Wire
	private Label layout2;
	
	@Listen("onClick =#submitButton")
	public void submitData(){
		
		System.out.println(layout.getValue());
		System.out.println(layout2.getValue());
		
		try{
			File f1 = new File(layout.getValue());
			System.out.println(f1.getName());
			File f2 = new File(layout2.getValue());
			System.out.println(f2.getName());
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
}
