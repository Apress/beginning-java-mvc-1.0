<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div style="background-color:#AAA;margin-bottom:1em">
${msg.current_member}
<c:choose>
  <c:when test="${! currentMember.defined}">
    ----
  </c:when>
  <c:otherwise>
    <fmt:formatDate value="${currentMember.birthday}"
                      pattern="MM/dd/yyyy"
                      var="cubd" />
    <span style="font-weight:bold">${currentMember.firstName} ${currentMember.lastName} ${cubd} (${currentMember.ssn})</span>
  </c:otherwise> 
</c:choose>
</div>