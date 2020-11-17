<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div style="color:red">
  <c:forEach var="e" items="${errorMessages.msgs}">
      ${e}
  </c:forEach>
</div>
