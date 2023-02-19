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
        action="${ pageContext.request.contextPath }/product/store">

    <div class="form-group mt-3">
        <label for="category"> Category</label>
        <form:select path="category" id="category" class="form-control">
            <c:forEach var="c" items="${categories}">
                <form:option value="${c.id}">${c.categoryName}</form:option>
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
<table class="table-hover">
    <tr>
        <td>ID</td>
        <td>Category Code</td>
        <td>Category Name</td>
        <td>Product Name</td>
        <td>Product Code</td>
        <td>Price</td>
        <td>Description</td>
        <td>Function</td>
    </tr>
    <c:forEach var="p" items="${ pageData.content}">
        <tr>
            <td>${p.id}</td>
            <td>${p.category.categoryCode}</td>
            <td>${p.category.categoryName}</td>
            <td>${p.productName}</td>
            <td>${p.productCode}</td>
            <td>${p.price}</td>
            <td>${p.description}</td>
            <td>
                <a class="btn-primary" href="/product/edit/${p.id}">Edit</a>
                <a class="btn-danger" href="/product/delete/${p.id}">Delete</a>
            </td>
        </tr>

    </c:forEach>

    <div>
        <ul class="pagination">
            <c:forEach begin="0" end="${ pageData.totalPages - 1 }" varStatus="page">
                <li class="page-item">
                   <a class="page-link" href="/product/hienthi?page=${ page.index }" > ${ page.index + 1 }</a>
                </li>
            </c:forEach>
        </ul>
    </div>
</table>
<script
        src="${ pageContext.request.contextPath }/js/bootstrap.min.js"
></script>
</html>
