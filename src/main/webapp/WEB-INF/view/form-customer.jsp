<%@page contentType="text/html;charset=UTF-8" language="java" %>
	<%@page isELIgnored="false" %>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
			<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
				<!DOCTYPE html>
				<html lang="en">

				<head>
					<title>Customer Management System</title>
					<meta charset="UTF-8" />
					<meta name="viewport" content="width=device-width, initial-scale=1" />
					<link href="https://bootswatch.com/5/quartz/bootstrap.min.css" rel="stylesheet" />
					<link rel="stylesheet"
						href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"
						integrity="sha512-Fo3rlrZj/k7ujTnHg4CGR2D7kSs0v4LLanw2qksYuRlEzO+tcaEPQogQ0KaoGN26/zrn20ImR1DfuLWnOo7aBA=="
						crossorigin="anonymous" referrerpolicy="no-referrer" />
				</head>

				<body>
					<div class="container mt-4" style="height: 100vh;">
						<h1 class="display-4 text-center">
							<i class="fas fa-book-open text-primary"></i> Customer<span
								class="text-primary">Management</span>System
						</h1>
						<form:form method="POST" action="${actionPost}" modelAttribute="customer">
							<div class="form-group">
								<form:label for="name" path="name">Name</form:label>
								<form:input type="text" id="name" class="form-control" path="name" />
							</div>
							<form:errors path="name" cssClass="text-danger mt-1" />
							<div class="form-group mt-2">
								<form:label for="email" path="email">Email</form:label>
								<form:input type="text" id="email" class="form-control" path="email" />
							</div>
							<form:errors path="email" cssClass="text-danger mt-1" />
							<div class="add-customer">
								<input type="submit" class="btn btn-primary btn-block mt-3" value="${inputVal}" />
							</div>

							<!-- Very important to associate with spring context to update Customer by id field -->
							<!-- if don not have, the data will not associate with the contxt to perform persitent data with that Customer -->
							<form:hidden path="id" />
						</form:form>
					</div>

					<script src="${pageContext.request.contextPath}/resources/js/alert.js"></script>
				</body>

				</html>
