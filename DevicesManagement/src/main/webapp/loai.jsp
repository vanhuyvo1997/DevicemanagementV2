<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
    <%@include file="bootstrap/css/bootstrap.min.css" %>
</style>
<script src="jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h2>Loại thiết bị</h2>
		<a href="#" data-toggle="modal" data-target="#addCategory">Thêm loại thiết bị</a>
		<table class="table table-striped">
		    <thead>
		      <tr>
		        <th>STT</th>
		        <th>Tên</th>
		        <th>Loại</th>
		        <th>Sửa</th>
		        <th>Xóa</th>
		      </tr>
		    </thead>
		    <tbody>
		      <tr>
		        <td>1</td>
		        <td>Màn hình 24 inch</td>
		        <td>Màn hình</td>
		        <td><a href="#" data-toggle="modal" data-target="#addCategory"><i class="fas fa-edit"></i></a></td>
		        <td><a href="#"><i class="fas fa-trash-alt"></i></a></td>
		      </tr>
		      <tr>
		        <td>2</td>
		        <td>PC core i5</td>
		        <td>PC</td>
		        <td><a href="#" data-toggle="modal" data-target="#addCategory"><i class="fas fa-edit"></i></a></td>
		        <td><a href="#"><i class="fas fa-trash-alt"></i></td>
		      </tr>
		    </tbody>
  		</table>	
	</div>
	<div class="modal" id="addCategory">
	<div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h4 class="modal-title">Thêm loại thiết bị</h4>
	        <button type="button" class="close" data-dismiss="modal">&times;</button>
	      </div>
	      <div class="modal-body">
	        <form action="#">
	        	<div class="form-group">
	    			<label for="txtname">Tên loại thiết bị:</label>
	   				<input type="text" class="form-control" id="txtname" name ="txtname" required>
 				</div>
	        	<div class="form-group">
					<label for="slsupercategory">Loại thiết bị:</label>
					<select class="form-control" id="slsupercategory" name = "slsupercategory">
						<option>Mobile</option>
						<option>Màn hình</option>
					</select>
				</div>
				<div>
				<button type="submit" class="btn btn-primary form-control">Thêm</button></div>
	        </form>
	      </div>
	    </div>
	  </div>
	</div>
</body>
</html>