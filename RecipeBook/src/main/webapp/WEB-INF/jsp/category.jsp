<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Category List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
            margin: 0;
            padding: 20px;
        }
        .container {
            max-width: 800px;
            margin: auto;
            padding: 20px;
            background: white;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }
        h2 {
            text-align: center;
            color: #333;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
            box-shadow: 0 2px 8px rgba(0, 0, 0, 0.05);
        }
        th, td {
            padding: 15px;
            border: 1px solid #ddd;
            text-align: left;
        }
        th {
            background-color: #007bff;
            color: white;
        }
        td {
            background-color: #fdfdfd;
        }
        .actions form {
            display: inline;
        }
        .btn {
            padding: 8px 16px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            text-decoration: none;
            color: white;
            font-size: 14px;
        }
        .btn-delete {
            background-color: #dc3545;
        }
        .btn-delete:hover {
            background-color: #c82333;
        }
        .btn-add {
            background-color: #28a745;
            display: inline-block;
            margin-top: 20px;
        }
        .btn-add:hover {
            background-color: #218838;
        }
        .text-center {
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Category List</h2>

        <table>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th class="text-center">Actions</th>
            </tr>
            <c:forEach var="category" items="${category}">
                <tr>
                    <td>${category.id}</td>
                    <td>${category.name}</td>
                    <td class="text-center">
                        <form action="${pageContext.request.contextPath}/api/categories/delete/${category.id}" method="post">
                            <input type="submit" value="Delete" class="btn btn-delete" onclick="return confirm('Are you sure you want to delete this category?');">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <a href="${pageContext.request.contextPath}/api/categories/show" class="btn btn-add">Add New Category</a>
    </div>
</body>
</html>
