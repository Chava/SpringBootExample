<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
   <script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
   <script src="/js/main.js"></script>
   <head/>
   <body>
    <div class="container mt-5">
           <h3>Customer details</h3>
      </div>
     <div class="container mt-5">
             <div class="d-flex justify-content-center text-center">
                <table class="table">
                   <tr>
                      <th scope="col">First name</th>
                      <th scope="col">Last name</th>
                      <th scope="col">Email</th>
                   </tr>
                      <tr>
                         <td>${customer.firstName}</td>
                         <td>${customer.lastName}</td>
                         <td>${customer.email}</td>
                      </tr>
                </table>
             </div>
            <div class="d-flex justify-content-center text-center mt-5">
              <a href="/customers" class="btn btn-info mr-3">Back to the list</a>
              <button  class="btn btn-outline-danger">Delete this customer</button>
            </div>
       </div>
   </body>
</html>