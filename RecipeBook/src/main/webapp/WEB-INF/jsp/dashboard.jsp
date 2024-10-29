<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Recipe Book</title>
    <style>
        /* General styling */
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 900px;
            margin: auto;
            padding: 20px;
        }

        h1 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }

        /* Navbar styling */
        .navbar {
            display: flex;
            justify-content: space-between;
            align-items: center;
            background-color: #000; /* Changed to black */
            padding: 15px;
            border-radius: 0; /* Removed border radius for full-width */
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
            width: 100%; /* Full width */
        }

        .navbar a {
            color: #fff;
            text-decoration: none;
            padding: 10px 15px;
            font-weight: bold;
            transition: background-color 0.3s, color 0.3s;
            border-radius: 5px;
        }

        .navbar a:hover {
            background-color: #333; /* Dark gray for hover effect */
        }

        /* Dropdown styling */
        .dropdown {
            position: relative;
            display: inline-block;
        }

        .dropdown-content {
            display: none;
            position: absolute;
            background-color: #f9f9f9;
            min-width: 150px;
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.2);
            border-radius: 8px;
            overflow: hidden;
            z-index: 1;
        }

        .dropdown-content a {
            color: #333;
            padding: 12px 16px;
            display: block;
            text-decoration: none;
            font-weight: normal;
        }

        .dropdown-content a:hover {
            background-color: #000; /* Black hover for dropdown items */
            color: white;
        }

        .dropdown:hover .dropdown-content {
            display: block;
        }

        /* Mobile responsive adjustments */
        @media (max-width: 768px) {
            .navbar {
                flex-direction: column;
            }
            .navbar a, .dropdown-content a {
                padding: 10px 15px;
                font-size: 1em;
            }
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Welcome to the Recipe Book</h1>

        <!-- Navigation Bar -->
        <nav class="navbar">
            <a href="/api/recipes/list">Home</a>
            <a href="/api/recipes/add">Create Recipe</a>
            <a href="/api/recipes/list">View All Recipes</a>
            <a href="/api/categories/all">All Categories</a>

            <!-- Dropdown Menu for User -->
            <div class="dropdown">
                <a href="/api/users/user/2">Profile</a>
                <div class="dropdown-content">
                    <a href="/api/users/user/2">View Profile</a>
                    <a href="/api/users/edit/2">Edit Profile</a>
                    <a href="/logout">Logout</a>
                </div>
            </div>
        </nav>
    </div>
</body>
</html>
