<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css">
    <style>
        /* Login template css */
        * {
            font-family: 'Nunito Sans', sans-serif;
        }

        :root {
            --shadowDark: #D9DDE6;
            --background: #E4E9F2;
            --shadowLight: #EFF5FE;
        }

        body {
            background: var(--background);
        }

        .hero-body {
            justify-content: center;
        }

        .login {
            border-radius: 25px;
            padding: 1.5rem;
            box-shadow: 8px 8px 15px var(--shadowDark), -8px -8px 15px var(--shadowLight);
        }

        input {
            background: var(--shadowDark) !important;
        }

        a {
            font-weight: 600;
        }
    </style>
    <title>Register | QR Wine Inventory</title>
</head>
<body>
<section class="hero is-fullheight">
    <div class="hero-body has-text-centered">
        <div class="login">
            <img src="/pictures/logo-h.png" style="margin-bottom: 20px">
            <form action="http://localhost:8080/registerUser" method="post">
<#--                <div class="field">-->
<#--                    <div class="control">-->
<#--                        <input class="input is-medium is-rounded" type="text" placeholder="Margot Robbie" autocomplete="username" required="">-->
<#--                    </div>-->
<#--                </div>-->
                <div class="field">
                    <div class="control">
                        <input class="input is-medium is-rounded" type="email" name="userName" placeholder="hello@example.com" required>
                    </div>
                </div>
                <div class="field is-grouped">
                    <div class="control">
                        <input class="input is-medium is-rounded" type="password" name="password" placeholder="**********" required>
                    </div>
                    <div class="control">
                        <input class="input is-medium is-rounded" type="password" name="confirmPassword" placeholder="Confirm **********" required>
                    </div>
                </div>
                <br>
                <button class="button is-block is-fullwidth is-primary is-medium is-rounded" type="submit">
                    Register
                </button>
            </form>
            <br>
            <nav class="level">
<#--                <div class="level-item has-text-centered">-->
<#--                    <div>-->
<#--                        <a href="#">Forgot Password?</a>-->
<#--                    </div>-->
<#--                </div>-->
                <div class="level-item has-text-centered">
                    <div>
                        <a href="/login">Already have an account?</a>
                    </div>
                </div>
            </nav>
        </div>
    </div>
</section>
</body>
</html>