<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <title>Board Form</title>
    </head>
    <body>
        <h1>게시판 추가</h1>
        <form:form commandName="board" action="/board/new" method="POST">
            <p>
                <label>이름: </label>
                <form:input path="title"/>
                <form:errors path="title"/>
            </p>
            <input type="submit">
        </form:form>
    </body>
</html>