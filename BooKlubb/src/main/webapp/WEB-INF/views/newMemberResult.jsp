<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Member Search</title>
</head>
<body>
  <%@ include file="../../fragments/errors.jsp" %>
  
  <h1>${msg.new_member_added}</h1>
  <%@ include file="../../fragments/currentMember.jsp" %>
  
  <div>
    <%@ include file="../../fragments/mainMenu.jsp" %>
    <div style="float:left">
    </div>
  </div>
    
</body>
</html>