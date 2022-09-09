<%@page contentType="text/html;charset=UTF-8" language="java" %>
	<%@page isELIgnored="false" %>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
			<!DOCTYPE html>
			<html lang="en">

			<head>
				<meta charset="UTF-8" />
				<meta html-equiv="X-UA-compatible" content="IE=edge" />
				<meta name="viewport" content="width=device-width, initial-scale=1.0" />
				<title>List Customer App</title>
				<link href="https://bootswatch.com/5/quartz/bootstrap.min.css" rel="stylesheet" />
				<link rel="stylesheet"
					href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"
					integrity="sha512-Fo3rlrZj/k7ujTnHg4CGR2D7kSs0v4LLanw2qksYuRlEzO+tcaEPQogQ0KaoGN26/zrn20ImR1DfuLWnOo7aBA=="
					crossorigin="anonymous" referrerpolicy="no-referrer" />
				<script src="${pageContext.request.contextPath}/resources/js/alert.js"></script>
			</head>

			<body>
				<div class="container mt-4">
					<h1 class="display-4 text-center">
						<i class="fas fa-book-open text-primary"></i> My<span class="text-primary">Customer</span>List
					</h1>
          <div class="card text-white bg-secondary mb-3" style="max-width: 100%;">
            <div class="card-body">
              <h3 class="card-title text-center text-info">Welcome: ${username}</h3>
              <p class="card-text text-center">Webpage displays all customers.</p>
              <p class="card-text text-center">If you want to logout, please click <a href="<c:url value='/logout'/>" class="text-warning">here</a>!</p>
  
            </div>
          </div>
					<table class="table table-striped mt-5">
						<thead>
							<tr class="text-center">
								<th>Customer Name</th>
								<th>Customer Email</th>
								<th>Update</th>
								<th>Delete</th>
							</tr>
						</thead>
						<tbody class="text-center">
							<c:forEach var="customer" items="${customers}">
								<c:url var="deleteLink" value="/customer/delete-customer">
									<c:param name="customerId" value="${customer.id}"></c:param>
								</c:url>
								<c:url var="updateLink" value="/customer/update-customer">
									<c:param name="customerId" value="${customer.id}"></c:param>
								</c:url>
								<tr>
									<td>
										<c:out value="${customer.name}" />
									</td>
									<td>
										<c:out value="${customer.email}" />
									</td>
									<td><a class="btn btn-primary btn-sm" href="${updateLink}"><i
												class="fas fa-pencil-alt" /></a></td>
									<td><a class="btn btn-danger btn-sm delete-btn" href="${deleteLink}"
											onclick="return deleteAction();"><i class="fas fa-trash" /></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div>
						<a href="<c:url value="/customer/customer-form" />"><input class="btn btn-primary btn-block mt-2"
							value="Add Customer"></input></a>
					</div>
				</div>
			</body>

			</html>
