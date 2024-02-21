<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>App</title>

    <style>
        body {
            background-color: #f2f2f2;
            font-family: sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            padding: 40px;
        }

        .login-box {
            text-align: center;
        }

        h1 {
            margin-bottom: 20px;
            font-size: 2rem;
            color: #343a40;
        }

        label {
            display: block;
            margin-bottom: 5px;
        }

        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            margin-bottom: 15px;
        }

        button[type="submit"] {
            background-color: #343a40;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
        }

        #remember-me {
            margin-bottom: 20px;
        }

    </style>

</head>

<body>
<div class="container">
    <div class="login-box">
        <h1>Login form</h1>
        <form action="Login" method="post">
            <label for="username">Username:</label>
            <input type="text" id="username" name="uname"><br>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password"><br>
            <label for="remember-me">
                <input type="checkbox" id="remember-me" name="remember-me"> Remember me
            </label><br>
            <button type="submit">Login</button>
        </form>
    </div>
</div>
</body>

</html>
