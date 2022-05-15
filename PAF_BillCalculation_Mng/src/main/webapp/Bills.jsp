<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@page import="model.Bill"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bill Calculation</title>
	<link rel="stylesheet" href="Views/bootstrap.css">
</head>
<body>
	<div class="container"><div class="row"><div class="col-6">
		<h1>Bill Calculation</h1>
		<form id="formInq" name="formInq">
		
 			User ID:
 			<input id="accNo" name="accNo" type="text"
 				class="form-control form-control-sm">
 				
 			<br> User Name:
		 	<input id="cusName" name="cusName" type="text"
 				class="form-control form-control-sm">
 			<br> User Address:
 			
 			<input id="date" name="date" type="text"
 				class="form-control form-control-sm">
 			
 			<br> User Mobile:
 			<input id="complain" name="complain" type="text"
 				class="form-control form-control-sm">
 			<br>
 			
 			<br> Units:
 			<input id="complain" name="complain" type="text"
 				class="form-control form-control-sm">
 			<br>
 			
 			<br> Amount:
 			<input id="complain" name="complain" type="text"
 				class="form-control form-control-sm">
 			<br>
 			
 			<br> Arrears:
 			<input id="complain" name="complain" type="text"
 				class="form-control form-control-sm">
 			<br>
 			
 			<br> Final Bill:
 			<input id="complain" name="complain" type="text"
 				class="form-control form-control-sm">
 			<br>
 			
 			
 			<input id="btnSave" name="btnSave" type="button" value="Save"
 				class="btn btn-primary">
 			<input type="hidden" id="hidInqIDSave"
 				name="hidInqIDSave" value="">
		</form>
		<br>
		<div id="alertSuccess" class="alert alert-success"></div>
		<div id="alertError" class="alert alert-danger"></div>
	<br>
		<div id="divInqGrid">
 		<%
 			Bill BillObj = new Bill();
 			out.print(BillObj.readBill());
 		%>
		</div>
		</div> </div> </div>
</body>
	<script src="Components/jquery.min.js"></script>
	<script src="Components/inquiries.js"></script>
</html>