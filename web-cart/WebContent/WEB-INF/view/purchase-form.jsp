<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>

<head>
	<title>Save Purchase</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Purchase Relationship Manager</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save Purchase</h3>
	
		<form:form action="savePurchase" modelAttribute="purchase" method="POST">

			<!-- need to associate this data with customer id -->
			<form:hidden path="id" />
					
			<table>
				<tbody>
					<tr>
						<td><label>Product name:</label></td>
						<td>
						   <form:select path="productName">

					            <form:option label="Select a Product" value=""></form:option>
					            <c:forEach items="${productlist}" var="tempProduct">
					
					                <form:option label="${tempProduct.name }" value="${tempProduct.name }"></form:option>
					            </c:forEach>
                            </form:select>
						     
						</td>
					</tr>
				
					<tr>
						<td><label>Customer Email:</label></td>
						<td><form:input path="customerEmail" /></td>
					</tr>

					<tr>
						<td><label>Quantity:</label></td>
						<td><form:input path="quantity" /></td>
					</tr>
					

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/purchase/list">Back to List</a>
		</p>
	
	</div>

</body>

</html>










