<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <script type="text/javascript" src="${mvc.basePath}/../js/jquery-3.5.1.min.js"></script>
    <title>Member Search</title>
</head>
<body>
  <%@ include file="../../fragments/errors.jsp" %>
  
  <h1>${msg.hd_searchResult}</h1>
  <%@ include file="../../fragments/currentMember.jsp" %>
  
  <div>
    <%@ include file="../../fragments/mainMenu.jsp" %>
    
    <div style="float:left">
      <c:choose>
	    <c:when test="${empty memberSearchResult}">
	        ${msg.no_result}
	    </c:when>
	    <c:otherwise>
		    <table>
		      <thead>
		        <tr>
		        	<th>${msg.tblhdr_id}</th>
		        	<th>${msg.tblhdr_last_name}</th>
		        	<th>${msg.tblhdr_first_name}</th>
		        	<th>${msg.tblhdr_birthday}</th>
		        	<th>${msg.tblhdr_ssn}</th>
		        	<th></th>
		        	<th></th>
		        </tr>
		      <thead>
		      <tbody>
		          <c:forEach  items="${memberSearchResult}" var="itm" >
		            <tr id="itm-${itm.id}">
		              <td>${itm.id}</td>
		              <td>${itm.lastName}</td>
		              <td>${itm.firstName}</td>
		              <fmt:formatDate value="${itm.birthday}"
	                      pattern="MM/dd/yyyy"
	                      var="d1" />
		              <td>${d1}</td>
		              <td>${itm.ssn}</td>
		              <td><button onclick="deleteItm(${itm.id})">${msg.btn_delete}</button></td>
		              <td><button onclick="selectMember(${itm.id})">${msg.btn_select}</button></td>
		              <td><button onclick="showDetails(${itm.id})">${msg.btn_details}</button></td>
		            </tr>
		          </c:forEach>
		      </tbody>
		    </table>
	      </c:otherwise>
	    </c:choose>
	    
	    <script type="text/javascript">
	      function deleteItm(id) {
	    	  jQuery('#memberIdForDelete').val(id);
	    	  jQuery('#deleteForm').submit();
	      } 
	      function selectMember(id) {
	    	  jQuery('#memberIdForSelect').val(id);
	    	  jQuery('#selectForm').submit();    	  
	      }
	      function showDetails(id) {
	    	  jQuery('#memberIdForDetails').val(id);
	    	  jQuery('#detailsForm').submit();    	  
	      }
	    </script>
	    <form id="deleteForm" method="post" action="${mvc.uriBuilder('BooKlubbController#deleteMember').build()}">
	      <input id="memberIdForDelete" type="hidden" name="memberId" />  
	    </form>    
	    <form id="selectForm" method="post" action="${mvc.uriBuilder('BooKlubbController#selectMember').build()}">
	      <input id="memberIdForSelect" type="hidden" name="memberId" />  
	    </form>        
	    <form id="detailsForm" method="post" action="${mvc.uriBuilder('BooKlubbController#memberDetails').build()}">
	      <input id="memberIdForDetails" type="hidden" name="memberId" />  
	    </form>        
    </div>
    
  </div>
  
</body>
</html>