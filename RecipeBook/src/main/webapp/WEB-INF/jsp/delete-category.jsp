<!-- delete-category.jsp -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Category</title>
</head>
<body>
    <h2>Are you sure you want to delete this category?</h2>
    
    <form action="${pageContext.request.contextPath}/categories/delete/${id}" method="post">
        <input type="submit" value="Yes, Delete">
    </form>
    
    <br>
    <a href="${pageContext.request.contextPath}/categories">Cancel</a>
</body>
</html>
