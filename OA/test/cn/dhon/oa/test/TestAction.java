package cn.dhon.oa.test;

import com.opensymphony.xwork2.ActionSupport;

public class TestAction extends ActionSupport{
	public String execute() throws Exception{
		System.out.println("TestAction.execute()");
		return "success";
	}
}
