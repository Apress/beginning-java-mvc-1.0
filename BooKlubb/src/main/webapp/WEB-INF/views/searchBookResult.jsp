<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <script type="text/javascript" src="${mvc.basePath}/../js/jquery-3.5.1.min.js"></script>
    <title>Book Search</title>
</head>
<body>
  <%@ include file="../../fragments/errors.jsp" %>
  
  <h1>${msg.hd_searchResult}</h1>
  <%@ include file="../../fragments/currentMember.jsp" %>
  
  <div>
    <%@ include file="../../fragments/mainMenu.jsp" %>
    <div style="float:left">
	  <c:choose>
	    <c:when test="${empty bookSearchResult}">
	        ${msg.no_result}
	    </c:when>
	    <c:otherwise>
		  <table>
		      <thead>
		        <tr>
		        	<th>${msg.tblhdr_id}</th>
		        	<th>${msg.tblhdr_author_last_name}</th>
		        	<th>${msg.tblhdr_author_first_name}</th>
		        	<th>${msg.tblhdr_book_title}</th>
		        	<th>${msg.tblhdr_book_make}</th>
		        	<th>${msg.tblhdr_isbn}</th>
		        	<th></th>
		        	<th></th>
		        </tr>
		      <thead>
		      <tbody>
		          <c:forEach  items="${bookSearchResult}" var="itm" >
		            <tr id="itm-${itm.id}">
		              <td>${itm.id}</td>
		              <td>${itm.authorLastName}</td>
		              <td>${itm.authorFirstName}</td>
		              <td>${itm.title}</td>
		              <fmt:formatDate value="${itm.make}"
	                      pattern="MM/dd/yyyy"
	                      var="d1" />
		              <td>${d1}</td>
		              <td>${itm.isbn}</td>
		              <td><button onclick="deleteItm(${itm.id})">${msg.btn_delete}</button></td>
		              <td><button onclick="assignItm(${itm.id},${currentMember.id})">${msg.btn_assign}</button></td>
		            </tr>
		          </c:forEach>
		      </tbody>
		  </table>
	    </c:otherwise>
	  </c:choose>
	    
	  <script type="text/javascript">
	    function deleteItm(id) {
		  	  jQuery('#bookIdForDelete').val(id);
		  	  jQuery('#deleteForm').submit();
		} 
	    function assignItm(bookId, userId) {
		  	  jQuery('#bookIdForAssign').val(bookId);
		  	  jQuery('#userIdForAssign').val(userId);
		  	  jQuery('#assignForm').submit();
		} 
	  </script>
	  <form id="deleteForm" method="post" action="${mvc.uriBuilder('BooKlubbController#deleteBook').build()}">
	    <input id="bookIdForDelete" type="hidden" name="bookId" />  
	  </form>    
	  <form id="assignForm" method="post" action="${mvc.uriBuilder('BooKlubbController#assignBook').build()}">
	    <input id="bookIdForAssign" type="hidden" name="bookId" />  
	    <input id="userIdForAssign" type="hidden" name="userId" />  
	  </form>    
    </div>
  </div>
  
</body>
</html>