<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Category</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .form-container {
            width: 100%;
            max-width: 400px;
            background: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }
        h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }
        input[type="text"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }
        .form-actions {
            display: flex;
            justify-content: center;
        }
        .form-actions input[type="submit"] {
            background-color: #28a745;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }
        .form-actions input[type="submit"]:hover {
            background-color: #218838;
        }
        .form-actions a {
            margin-left: 10px;
            text-decoration: none;
            color: #007bff;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>Add New Category</h2>
        <form action="${pageContext.request.contextPath}/api/categories/add" method="post">
            <label for="name">Category Name</label>
            <input type="text" id="name" name="name" placeholder="Enter category name" required>

            <div class="form-actions">
                <input type="submit" value="Add Category">
                <a href="${pageContext.request.contextPath}/categories">Cancel</a>
            </div>
        </form>
    </div>
</body>
</html>
