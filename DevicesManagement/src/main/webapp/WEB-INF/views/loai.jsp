<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
    <%@include file="../../bootstrap/css/bootstrap.min.css" %>
</style>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css" >

</head>
<body>
	<div class="container">
		<h2>Loại thiết bị</h2>
		<!-- Button trigger modal -->
		
		<!-- Button trigger modal -->
		<div class="row">
			<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#exampleModalCenter">
			  Thêm
			</button>
		</div>
		
		<!-- Modal -->
		<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
		  <div class="modal-dialog modal-dialog-centered" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLongTitle">Thêm loại</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		       		<s:form action="themloai.action">
	      				<div class="form-group">
							<label for="">Tên</label>
							<input type="text" class="form-control" id="" placeholder="Nhập tên loại" required="required" name="subcategoryname">
						</div>
						<div class="form-group">
							<label for="">Chủng loại</label>
							<select name="idsupcategory" id="input" class="form-control w-50" required="required" >
								<option ></option>
								<c:forEach items="${listSupCategory}" var="sup">
									<option value="${sup.idsupercategory }">${sup.name }</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
		        			<button type="submit" class="btn btn-primary">Save changes</button>
						</div>
						
    			</s:form>
		      </div>
		    </div>
		  </div>
		</div>
		
		<div class="row">
			<table class="table table-striped">
			    <thead>
			      <tr>
			        <th>ID</th>
			        <th>Tên</th>
			        <th>Chủng loại</th>
			        <th>Tùy chọn</th>
			      </tr>
			    </thead>
			    <tbody>
			     	<c:forEach items="${listSubCategory}" var="sub">
						<tr>
							<td>${sub.idsubcategory}</td>
							<td>${sub.name}</td>
							<td>${sub.supercategory.name}</td>
							<td><button id="${sub.idsubcategory}" type="button" onclick="clickSua(this.id)" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCente"> <i class="fas fa-edit"> </i> Sửa</button>
						<a href="xoaloai.action?idsubcategory=${sub.idsubcategory}" onclick="return confirm('Are you sure?')" type="button" class="btn btn-danger"><i class="fas fa-trash-alt"> Xóa</i></a></td>
						   
						</tr>
					</c:forEach>
			    </tbody>
			
		
  			</table>	
  		</div>
	</div>
	
	<!-- Modal -->
	<div class="modal fade" id="exampleModalCente" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
		  <div class="modal-dialog modal-dialog-centered" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalCenterTitle">Sửa loại</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
		        <s:form action="capnhat.action">
		        		<div class="form-group">
							<label for="">ID</label>
							<input type="text" name="idupdate" class="form-control" id="idsub" placeholder="Nhập tên loại" required="required" readonly name="subcategoryname">
						</div>
	      				<div class="form-group">
							<label for="">Tên</label>
							<input type="text" class="form-control" placeholder="Nhập tên loại" required="required" name="subcategoryname">
						</div>
						<div class="form-group">
							<label for="">Chủng loại</label>
							<select name="idsupcategory" id="input" class="form-control w-50" required="required" >
								<option ></option>
								<c:forEach items="${listSupCategory}" var="sup">
									<option value="${sup.idsupercategory }">${sup.name }</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
		        			<button type="submit" class="btn btn-primary">Save changes</button>
						</div>
						
    			</s:form>
		      </div>
		    </div>
		  </div>
	  </div>
	<script src="/DevicesManagement/jquery.min.js"></script>
    <script src="/DevicesManagement/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript">
    	function clickSua(val){
    		$("#idsub").val(val);
    	}
    </script>
</body>
</html>