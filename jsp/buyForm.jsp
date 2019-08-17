<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Grocery Form</title>
</head>
<body>
  <h1>Edit Grocery Form</h1>
  <form:form action="confirmBuyGrocery.obj" modelAttribute="grocery">
      <table border="1" >
         <tr>
            <td>Item ID</td>
            <td><form:input path="id" readonly="true" /> 
            </td>
         </tr>
         <tr>
            <td>Item Name</td>
            <td><form:input path="name" readonly="true"  /> 
            </td>
         </tr>
         <tr>
            <td>Price(Rs)</td>
            <td><form:input path="price" readonly="true" /> 
               </td>
         </tr>
         <tr>
            <td>Category</td>
            <td><form:input path="category" readonly="true" /> 
               </td>
         </tr>
         <tr>
            <td>Available Quantity</td>
            <td><form:input path="quantity" readonly="true"/> 
             </td>
         </tr>
         <tr>
            <td>Unit</td>
            <td><form:input path="unit" readonly="true"/> 
            </td>
         </tr>
         <tr>
            <td>Description</td>
            <td><form:input path="description" readonly="true"/> 
            </td>
         </tr>
         <tr>
            <td>Units Required</td>
            <td><input type="text" name="req" value=""/> 
            </td>
         </tr>
         <tr>
            <td colspan="2"><input type="submit" value="Buy Grocery"> </td>
         </tr>
         <tr>
            <td colspan="2"><a href ="goHome.obj">Go Home</a></td>
         </tr>
   </table>
  </form:form>
</body>
</html>