<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form
        modelAttribute="cate"
        method="POST"
        action="${ pageContext.request.contextPath }/category/store">
    <input type="hidden" name="_method" value="put" />
    <div class="form-group mt-3">
        <label for="categoryCode">categoryCode</label>
        <form:input path="categoryCode" class="form-control" autocomplete="off" />
        <form:errors path="categoryCode" element="span" cssClass="text-danger" />
    </div>
    <div class="form-group mt-3">
        <label for="email">categoryName</label>
        <form:input path="categoryName" class="form-control" id="email" name="email" autocomplete="off" />
        <form:errors path="categoryName" element="span" cssClass="text-danger" />
    </div>

    <div class="form-group mt-3">
        <button class="btn btn-primary">Submit</button>
        <button type="reset" class="btn btn-danger">Clear</button>
    </div>
</form:form>
</body>
</html>