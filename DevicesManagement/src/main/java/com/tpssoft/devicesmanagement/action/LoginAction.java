package com.tpssoft.devicesmanagement.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;
import com.tpssoft.devicesmanagement.dao.UserDAO;
import com.tpssoft.devicesmanagement.model.User;

@Results(
		{ 
			@Result(name = "success", location = "/WEB-INF/views/success.jsp"),
			@Result(name = "error", location = "/WEB-INF/views/index.jsp") 
		})
public class LoginAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String username, password;

	@Action(value = "login")
	public String execute() {
		UserDAO daoUser = new UserDAO();
		User user = daoUser.getUserById(getUsername());
		if (user != null && user.getPassword().equals(password)) {
			return SUCCESS;
		} 
		return ERROR;
	}
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
