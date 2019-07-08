package com.tpssoft.devicesmanagement.action;

import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

@Results({
	@Result(name = "success", location = "loai.jsp"),
	@Result(name = "error", location = "loai.jsp")
})
public class LoaiAction extends ActionSupport implements SessionAware {
	
	private Map<String, Object> mapSession;
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.mapSession = session;
	}
	
	
	@Action(value="addcategory")
	@Override
	public String execute(){
		return "SUCCESS";
	}
	
	 
}
