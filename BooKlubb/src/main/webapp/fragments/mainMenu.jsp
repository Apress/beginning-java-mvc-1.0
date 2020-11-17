<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div style="width:30%; float:left;">
  <ul>
    <li><a href="${mvc.uriBuilder('BooKlubbController#searchMember').build()}">
        ${msg.menu_search_member}</a></li>
    <li><a href="${mvc.uriBuilder('BooKlubbController#newMember').build()}">
        ${msg.menu_new_member}</a></li>
    <li><a href="${mvc.uriBuilder('BooKlubbController#searchBook').build()}">
        ${msg.menu_search_book}</a></li>
    <li><a href="${mvc.uriBuilder('BooKlubbController#newBook').build()}">
        ${msg.menu_new_book}</a></li>
  </ul>
</div>