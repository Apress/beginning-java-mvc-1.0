<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <script type="text/javascript" src="${mvc.basePath}/../js/jquery-3.5.1.min.js"></script>
    <title>${msg.title}</title>
</head>
<body>
  <%@ include file="../../fragments/errors.jsp" %>

  <h1>${msg.hd_searchBook}</h1>
  <%@ include file="../../fragments/currentMember.jsp" %>
 
  <div>
    <%@ include file="../../fragments/mainMenu.jsp" %>
    <div style="float:left">
	  <form method="get" action="${mvc.uriBuilder('BooKlubbController#searchBookSubmit').build()}">
	    <table><tbody>
	      <tr><td>${msg.enter_authorFirstName}</td> <td><input type="text" name="aurhorFirstName" /></td></tr> 
	      <tr><td>${msg.enter_authorLastName}</td> <td><input type="text" name="authorLastName" /> </td></tr> 
	      <tr><td>${msg.enter_bookTitle}</td> <td><input type="text" name="bookTitle"/> </td></tr>
	      <tr><td>${msg.enter_isbn}</td> <td><input type="text" name="isbn"/> </td></tr>
	    </tbody></table>
	    <input type="submit" value="${msg.btn_search}" />    
	  </form>
    </div>
  </div>

</body>
</html>
