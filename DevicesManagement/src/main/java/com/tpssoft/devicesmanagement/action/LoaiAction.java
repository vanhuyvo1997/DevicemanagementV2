package com.tpssoft.devicesmanagement.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;
import com.tpssoft.devicesmanagement.dao.SubCategoryDAO;
import com.tpssoft.devicesmanagement.dao.SuperCategoryDAO;
import com.tpssoft.devicesmanagement.model.Subcategory;
import com.tpssoft.devicesmanagement.model.Supercategory;

@Results({
	@Result(name = "success", location = "/WEB-INF/views/loai.jsp"),
	@Result(name = "deletesuccess", location = "subcategory", type="redirect"),
	@Result(name = "deletefail", location = "subcategory", type="redirect"),
	@Result(name = "addsuccess", location = "subcategory", type="redirect"),
	@Result(name = "addfail", location = "subcategory", type="redirect"),
	@Result(name = "addfail", location = "subcategory", type="redirect"),
	@Result(name = "updatesuccess", location = "subcategory", type="redirect")
})
public class LoaiAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Subcategory> listSubCategory;
	private List<Supercategory> listSupCategory;
	private int idsubcategory;
	private int idsupcategory;
	private String subcategoryname;
	private int idupdate;
	
	
	


	public int getIdupdate() {
		return idupdate;
	}


	public void setIdupdate(int idupdate) {
		this.idupdate = idupdate;
	}


	public int getIdsupcategory() {
		return idsupcategory;
	}


	public void setIdsupcategory(int idsupcategory) {
		this.idsupcategory = idsupcategory;
	}


	public String getSubcategoryname() {
		return subcategoryname;
	}


	public void setSubcategoryname(String subcategoryname) {
		this.subcategoryname = subcategoryname;
	}


	public int getIdsubcategory() {
		return idsubcategory;
	}


	public void setIdsubcategory(int idsubcategory) {
		this.idsubcategory = idsubcategory;
	}


	public List<Supercategory> getListSupCategory() {
		return listSupCategory;
	}


	public void setListSupCategory(List<Supercategory> listSupCategory) {
		this.listSupCategory = listSupCategory;
	}


	public List<Subcategory> getListSubCategory() {
		return listSubCategory;
	}


	public void setListSubCategory(List<Subcategory> listSubCategory) {
		this.listSubCategory = listSubCategory;
	}
	
	@Action(value="subcategory")
	@Override
	public String execute(){
		SuperCategoryDAO daoSupCate = new SuperCategoryDAO();
		SubCategoryDAO daoSubCate = new SubCategoryDAO();
		listSubCategory = daoSubCate.getAllSubCategory();
		listSupCategory = daoSupCate.getAllSuperCategory();
		return SUCCESS;
	}
	
	@Action(value="xoaloai")
	public String deleteSubcategory() {
		SubCategoryDAO daoSubCate = new SubCategoryDAO();
		if(daoSubCate.deleteSubCategory(idsubcategory)) {
			return "deletesuccess";
		}
		return "deletefail";
	}
	
	@Action(value="themloai")
	public String addSubcategory() {
		SuperCategoryDAO daoSupCate = new SuperCategoryDAO();
		Supercategory supCate = daoSupCate.getSuperCategoryById(this.idsupcategory);
		SubCategoryDAO daoSubCate = new SubCategoryDAO();
		if(daoSubCate.addSubCategory(supCate, subcategoryname)!=null) {
			return "addsuccess";
		}
		return "addfail";	
	}
	
	@Action(value="capnhat")
	public String updateSubcategory() {
		SuperCategoryDAO daoSupCate = new SuperCategoryDAO();
		Supercategory supCate = daoSupCate.getSuperCategoryById(this.idsupcategory);
		SubCategoryDAO daoSubCate = new SubCategoryDAO();
		daoSubCate.updateSubCategory(supCate, this.idupdate, this.subcategoryname);
		return "updatesuccess";
	}
	
}
