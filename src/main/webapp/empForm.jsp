<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<title>Employee Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>

<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
			 <a href="https://www.Google.com" class="navbar-brand"> Employee
     Management App </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Empoloyees</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${emp != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${emp == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${emp != null}">
                                    Edit User
                                </c:if>
						<c:if test="${emp == null}">
                                    Add New Employee
                                </c:if>
					</h2>
				</caption>

				<c:if test="${emp != null}">
					<input type="hidden" name="id" value="<c:out value='${emp.empId}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Employee Bank Account</label> <input type="text"
						value="<c:out value='${emp.empBankAcc}' />" class="form-control"
						name="name" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label> Company</label> <input type="text"
						value="<c:out value='${emp.empCompany}' />" class="form-control"
						name="email">
				</fieldset>

				<fieldset class="form-group">
					<label> Job Title</label> <input type="text"
						value="<c:out value='${emp.empJobTitle}' />" class="form-control"
						name="country">
				</fieldset>
				<fieldset class="form-group">
					<label>Last Name</label> <input type="text"
						value="<c:out value='${emp.empLastName}' />" class="form-control"
						name="country">
				</fieldset>
				<fieldset class="form-group">
					<label>Name</label> <input type="text"
						value="<c:out value='${emp.empName}' />" class="form-control"
						name="country">
				</fieldset>
				<fieldset class="form-group">
					<label>Salary</label> <input type="text"
						value="<c:out value='${emp.empSalary}' />" class="form-control"
						name="country">
				</fieldset>
				<fieldset class="form-group">
					<label>Pf Account Balance</label> <input type="text"
						value="<c:out value='${emp.pfAccBalance}' />" class="form-control"
						name="country">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>

</html>