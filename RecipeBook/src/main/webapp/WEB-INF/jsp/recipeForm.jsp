<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Recipe</title>
    <style>
        /* General styling */
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
        }

        .container {
            background-color: #ffffff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
            max-width: 500px;
            width: 100%;
            margin: 20px;
        }

        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }

        /* Form styling */
        form label {
            font-weight: bold;
            display: block;
            margin-bottom: 5px;
            color: #555;
        }

        form input[type="text"],
        form input[type="number"],
        form textarea {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ddd;
            border-radius: 5px;
            font-size: 1em;
            box-sizing: border-box;
            transition: border-color 0.3s;
        }

        form input[type="text"]:focus,
        form input[type="number"]:focus,
        form textarea:focus {
            border-color: #007bff;
            outline: none;
        }

        form textarea {
            resize: vertical;
            min-height: 100px;
        }

        /* Submit button styling */
        form input[type="submit"] {
            width: 100%;
            padding: 12px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 5px;
            font-size: 1em;
            font-weight: bold;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        form input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Create Recipe</h2>
        <form action="/api/recipes/create" method="post">
            <label for="title">Title:</label>
            <input type="text" id="title" name="title" placeholder="Enter recipe title" required>

            <label for="description">Description:</label>
            <textarea id="description" name="description" placeholder="Enter recipe description" required></textarea>

            <label for="categoryId">Category ID:</label>
            <input type="number" id="categoryId" name="categoryId" placeholder="Enter category ID" required>

            <label for="userId">User ID:</label>
            <input type="number" id="userId" name="userId" placeholder="Enter user ID" required>

            <input type="submit" value="Create Recipe">
        </form>
    </div>
</body>
</html>
