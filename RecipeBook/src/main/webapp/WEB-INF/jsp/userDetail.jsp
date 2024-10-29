<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User Detail</title>
    <style>
        /* General body styles */
        body {
            font-family: Arial, sans-serif;
            background-color: #f7f9fc;
            color: #333;
            margin: 0;
            padding: 20px;
            display: flex;
            align-items: center;
            justify-content: center;
            min-height: 100vh;
        }

        /* Container styling */
        .container {
            max-width: 500px;
            width: 100%;
            background: #fff;
            border-radius: 8px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
            overflow: hidden;
        }

        /* Header styling */
        h2 {
            background-color: #007bff;
            color: #fff;
            padding: 15px;
            margin: 0;
            text-align: center;
            font-size: 1.5em;
            border-top-left-radius: 8px;
            border-top-right-radius: 8px;
        }

        /* Table styling */
        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px;
        }

        th, td {
            padding: 15px;
            text-align: left;
        }

        th {
            background-color: #f4f6f8;
            color: #555;
            width: 40%;
            font-weight: bold;
        }

        td {
            background-color: #fdfdfd;
            color: #333;
        }

        /* Button styling */
        .back-button {
            display: block;
            text-align: center;
            margin: 20px;
            padding: 10px 20px;
            background-color: #007bff;
            color: #fff;
            text-decoration: none;
            border-radius: 5px;
            font-weight: bold;
            transition: background-color 0.3s;
        }

        .back-button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>User Details</h2>
        <table>
            <tr>
                <th>ID</th>
                <td>${user.id}</td>
            </tr>
            <tr>
                <th>Username</th>
                <td>${user.username}</td>
            </tr>
            <tr>
                <th>Email</th>
                <td>${user.email}</td>
            </tr>
        </table>
        <a href="/" class="back-button">Back to Home</a>
    </div>
</body>
</html>
