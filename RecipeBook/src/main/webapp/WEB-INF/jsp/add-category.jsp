<!-- add-category.jsp -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Category</title>
</head>
<body>
    <h2>Add New Category</h2>
    
    <form action="${pageContext.request.contextPath}/categories" method="post">
        <label for="name">Category Name:</label>
        <input type="text" id="name" name="name" required>
        <input type="submit" value="Add Category">
    </form>
    
    <br>
    <a href="${pageContext.request.contextPath}/categories">Back to Category List</a>
</body>
</html>
