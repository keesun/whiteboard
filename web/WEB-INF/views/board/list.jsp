<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!doctype html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <title>Board List</title>
    </head>
    <body>
        <ul>
            <c:forEach items="${list}" var="board">
            <li>${board.title}</li>
            </c:forEach>
        </ul>
    </body>
</html>