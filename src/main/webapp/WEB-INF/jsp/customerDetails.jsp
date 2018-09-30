<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
   <head/>
   <body>
     <div class="container">
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
       </div>
   </body>
</html>