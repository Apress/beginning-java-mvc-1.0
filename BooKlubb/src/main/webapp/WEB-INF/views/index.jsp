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

  <h1>${msg.title}</h1>
  <%@ include file="../../fragments/currentMember.jsp" %>

  <div>
    <%@ include file="../../fragments/mainMenu.jsp" %>
    <div style="float:left">
    </div>
  </div>

</body>
</html>