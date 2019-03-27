<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Purchases</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Purchase -->
		
			<input type="button" value="Add Purchase"
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button"
			/>
		
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Customer Email</th>
					<th>Product Name</th>
					<th>Quantity</th>
					<th>Purchase Date</th>
				
				</tr>
				
				<!-- loop over and print our purchases -->
				<c:forEach var="tempPurchase" items="${purchases}">
				
									
					
					<tr>
						<td> ${tempPurchase.productName} </td>
						<td> ${tempPurchase.customerEmail} </td>
						<td> ${tempPurchase.quantity} </td>
						<td> ${tempPurchase.purchaseDate} </td>
						
						
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>









