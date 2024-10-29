<!-- deleteRecipe.jsp -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Delete Recipe</title>
</head>
<body>
    <h2>Delete Recipe</h2>
    <p>Are you sure you want to delete this recipe?</p>

    <form action="${pageContext.request.contextPath}/api/recipes/delete/${id}" method="post">
        <button type="submit">Yes, Delete</button>
    </form>
    <a href="${pageContext.request.contextPath}/api/recipes">Cancel</a>
</body>
</html>
