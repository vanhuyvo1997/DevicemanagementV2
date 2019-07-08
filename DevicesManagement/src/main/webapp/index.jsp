<%@ page language="java" contentType="text/html; charset = ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Log in</title>
<style type="text/css">
    <%@include file="bootstrap/css/bootstrap.min.css" %>
</style>

<script src="jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
</head>

<body>
	<div class="container-fluid my-5">
		<div class="row">
			<div class="col-xs-4 col-sm-4 col-md-4 col-lg-4 mx-auto my-auto">
				<div class="row">
					<div class="px-2 py-2 rounded bg-light px-5 py-4 shadow-sm">
						<s:form action="login.action" method="post" >
							<legend class="text-success">Log in</legend>
							<div class="form-group">
								<s:textfield name="username" label="User name" cssClass="form-control text-warning" />
							</div>
							<div class="form-group">
								<s:password name="password" label="Password"  cssClass="form-control text-warning"/>
							</div>
							<s:submit cssClass="btn btn-success" name="submit" label="Log in" align="right" />
						</s:form>
					</div>
				</div>
			</div>
		</div>
		
	</div>
</body>
</html>