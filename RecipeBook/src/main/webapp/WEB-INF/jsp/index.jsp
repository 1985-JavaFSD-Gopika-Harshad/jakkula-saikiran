<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <style>
        /* General styling */
        body {
            font-family: Arial, sans-serif;
            background-color: #000; /* Black background */
            color: #fff; /* White text */
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .login-container {
            background: rgba(255, 255, 255, 0.1); /* Semi-transparent white */
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
            width: 300px;
            text-align: center;
        }

        h2 {
            margin-bottom: 20px;
        }

        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }

        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ddd;
            border-radius: 5px;
            background: #fff;
            color: #333;
        }

        input[type="submit"] {
            background-color: #007bff; /* Blue background */
            color: white;
            padding: 10px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            width: 100%;
            transition: background-color 0.3s;
        }

        input[type="submit"]:hover {
            background-color: #0056b3; /* Darker blue on hover */
        }

        .register-link {
            margin-top: 15px;
            color: #007bff; /* Link color */
            text-decoration: none;
        }

        .register-link:hover {
            text-decoration: underline; /* Underline on hover */
        }

        .error-message {
            color: #ff4d4d; /* Red color for error message */
            margin: 10px 0;
        }
    </style>
</head>
<body>
    <div class="login-container">
        <h2>Register</h2>
        <%-- Display error message if exists --%>
        <c:if test="${not empty errorMessage}">
            <div class="error-message">${errorMessage}</div>
        </c:if>
        
        <form action="${pageContext.request.contextPath}/api/users/login" method="post">
            <label for="username">Username</label>
            <input type="text" id="username" name="username" required placeholder="Enter your username">
			
			<label for="email">EmailId</label>
			            <input type="text" id="email" name="email" required placeholder="Enter your email">


            <label for="password">Password</label>
            <input type="password" id="password" name="password" required placeholder="Enter your password">

            <input type="submit" value="Register">
        </form>
        <a href="${pageContext.request.contextPath}/api/users/form" class="register-link">Already have an Account Login In</a>
    </div>
</body>
</html>
