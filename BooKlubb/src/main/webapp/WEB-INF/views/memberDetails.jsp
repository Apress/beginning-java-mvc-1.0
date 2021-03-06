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

  <h1>${msg.hd_memberDetails}</h1>
  <%@ include file="../../fragments/currentMember.jsp" %>
 
  <div>
    <%@ include file="../../fragments/mainMenu.jsp" %>
    <div style="float:left">
      <table>
        <tbody>
          <tr><td>${msg.memb_id}</td><td>${currentMember.id}</td></tr>
          <tr><td>${msg.memb_firstName}</td><td>${currentMember.firstName}</td></tr>
          <tr><td>${msg.memb_lastName}</td><td>${currentMember.lastName}</td></tr>
          <fmt:formatDate value="${currentMember.birthday}"
                  pattern="MM/dd/yyyy"
                  var="bd" />
          <tr><td>${msg.memb_birthday}</td><td>${bd}</td></tr>
          <tr><td>${msg.memb_ssn}</td><td>${currentMember.ssn}</td></tr>
        </tbody>
      </table>
      
      <h2>${msg.hd_booksAssigned}</h2>
      <c:choose>
        <c:when test="${empty currentMember.rentals}">
          ----
        </c:when>
        <c:otherwise>
          <table>
              <tbody>
                <c:forEach items="${currentMember.rentals}" var="r">
                  <tr>
                    <td>${r.authorFirstName} ${r.authorLastName}</td>
                    <td>${r.title}</td>
                    <fmt:formatDate value="${r.make}"
                      pattern="MM/dd/yyyy"
                      var="makeDay" />
                    <td>${makeDay}</td>
                    <td><button onclick="unassign(${currentMember.id},${r.id})">${msg.btn_unassign}</button></td>
                  </tr>
                </c:forEach>
              </tbody>
          </table>
        </c:otherwise>
      </c:choose>
      <script type="text/javascript">
        function unassign(memberId,bookId) {
        	jQuery('#memberIdForUnassign').val(memberId);
        	jQuery('#bookIdForUnassign').val(bookId);
        	jQuery('#unassignForm').submit();
        }
      </script>
      <form id="unassignForm" method="post" action="${mvc.uriBuilder('BooKlubbController#unassignBook').build()}">
	      <input id="memberIdForUnassign" type="hidden" name="memberId" />  
	      <input id="bookIdForUnassign" type="hidden" name="bookId" />  
	  </form>
      
    </div>
  </div>

</body>
</html>
