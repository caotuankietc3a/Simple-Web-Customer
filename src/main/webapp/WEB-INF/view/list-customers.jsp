<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="eng">
  <head>
    <meta charset="UTF-8" />
    <meta html-equiv="X-UA-compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>List Customer App</title>
    <link
      href="https://bootswatch.com/5/quartz/bootstrap.min.css"
      rel="stylesheet"
    />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"
      integrity="sha512-Fo3rlrZj/k7ujTnHg4CGR2D7kSs0v4LLanw2qksYuRlEzO+tcaEPQogQ0KaoGN26/zrn20ImR1DfuLWnOo7aBA=="
      crossorigin="anonymous"
      referrerpolicy="no-referrer"
    />
  </head>

  <body>
    <div class="container mt-4">
      <h1 class="display-4 text-center">
        <i class="fas fa-book-open text-primary"></i>
        My<span class="text-primary">Customer</span>List
      </h1>
      <form id="book-form">
        <div class="form-group">
          <label for="name">Name</label>
          <input type="text" id="name" class="form-control" />
        </div>
        <div class="form-group mt-2">
          <label for="email">Email</label>
          <input type="text" id="email" class="form-control" />
        </div>
        <div class="add-customer">
          <input
            type="submit"
            class="btn btn-primary btn-block mt-2"
            value="Add Customer"
          />
        </div>
      </form>
      <table class="table table-striped mt-5">
        <thead>
          <tr class="text-center">
            <th>Customer Name</th>
            <th>Customer Email</th>
            <th>Delete</th>
            <th>Update</th>
          </tr>
        </thead>
        <tbody class="text-center">
          <c:forEach var="customer" items="${customers}">
          <td>${customer.name}</td>
           <td>customer.email</td>
           <td><a class="btn btn-danger btn-sm delete">X</a></td>
           <td><a class="btn btn-danger btn-sm delete">X</a></td>
          </c:forEach>
        </tbody>
      </table>
    </div>
  </body>
</html>
