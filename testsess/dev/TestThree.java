package com.testsess.dev;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;

public class TestThree extends SelectorComposer<Component>  {

	private static final long serialVersionUID = 1L;

	private String fileName;
	
	public TestThree(){
		System.out.println("TEST THREE");
		setFileName("TESTNAME");
	}
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
