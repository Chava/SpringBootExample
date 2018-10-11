<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
   <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
   <script src="//cdnjs.cloudflare.com/ajax/libs/jasny-bootstrap/3.1.3/js/jasny-bootstrap.min.js"></script>
  <head/>
   <body>
      <div class="container mt-5">
        <h3>The list of all customers</h3>
      </div>
      <div class="container">
         <div class="d-flex justify-content-center text-center mt-5">
            <table class="table table-striped table-bordered table-hover">
              <thead>
               <tr>
                  <th scope="col">First name</th>
                  <th scope="col">Last name</th>
                  <th scope="col">Email</th>
               </tr>
              </thead>
              <tbody data-link="row" class="rowlink">
               <c:forEach items="${listOfCustomers}" var="customer">
                  <tr>
                     <td>${customer.firstName}</a></td>
                     <td>${customer.lastName}</td>
                     <td>${customer.email}</td>
                   </tr>
               </c:forEach>
               </tbody>
            </table>
         </div>
         <form method="POST" action="customers" class="mt-5">
            <div class="form-row">
               <div class="form-group col-md-3">
                  <label for="inputEmail4">First name</label>
                  <input type="text" class="form-control" name="firstName" placeholder="First name">
               </div>
               <div class="form-group col-md-4">
                  <label for="inputPassword4">Last name</label>
                  <input type="text" class="form-control" name="lastName" placeholder="Last name">
               </div>
               <div class="form-group col-md-3">
                  <label for="inputPassword4">Email</label>
                  <input type="email" class="form-control" name="email" placeholder="Email">
               </div>
            </div>
            <button type="submit" class="btn btn-primary">Add customer</button>
         </form>
         <div id="msg"></div>

      </div>
   </body>
</html>