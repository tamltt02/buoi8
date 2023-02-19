<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
    <link href="${ pageContext.request.contextPath }/css/bootstrap.min.css" rel="stylesheet" />

</head>
<body>

<form:form
        modelAttribute="p"
        method="POST"
        action="${ pageContext.request.contextPath }/product/update/${p.id}">

<div class="form-group mt-3">
    <label for="category"> Category</label>
    <form:select path="category" id="category" class="form-control">
        <c:forEach var="c" items="${categories}">
            <option value="${c.id}" ${p.category.id == c.id ? "selected" : ""}>${c.categoryName}</option>
        </c:forEach>
    </form:select>
    <form:errors path="category" element="span" cssClass="text-danger"/>
</div>
<div class="form-group mt-3">
    <label for="productCode">ProductCode</label>
    <form:input path="productCode" class="form-control" autocomplete="off"/>
    <form:errors path="productCode" element="span" cssClass="text-danger"/>
</div>
<div class="form-group mt-3">
    <label for="email">ProductName</label>
    <form:input path="productName" class="form-control" id="email" name="email" autocomplete="off"/>
    <form:errors path="productName" element="span" cssClass="text-danger"/>
</div>
<div class="form-group mt-3">
    <label for="price">Price</label>
    <form:input path="price" class="form-control" id="price" name="price" autocomplete="off"/>
    <form:errors path="price" element="span" cssClass="text-danger"/>
</div>
<div class="form-group mt-3">
    <label for="description">Description</label>
    <form:input path="description" class="form-control" id="email" name="email" autocomplete="off"/>
    <form:errors path="description" element="span" cssClass="text-danger"/>
</div>

<div class="form-group mt-3">
    <button class="btn btn-primary">Submit</button>
    <button type="reset" class="btn btn-danger">Clear</button>
</div>
</form:form>
<script
        src="${ pageContext.request.contextPath }/js/bootstrap.min.js"
></script>
</html>
