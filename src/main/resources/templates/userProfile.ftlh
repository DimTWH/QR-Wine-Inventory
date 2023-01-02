<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css">
    <title>User Profile | QR Wine Inventory</title>
</head>
<body>
<#include "navbar.ftlh">
<div class="container">
    <div class="content">
        <div class="columns">
            <div class="column"></div>
            <div class="column" style="background-color: white;">
                <h3>User profile (Coming soon... please Logout)</h3>
                <div class="table-container">
                    <table class="table is-striped is-hoverable">
                        <thead>
                        <tr>
                            <th style="background-color: #ff6969;">Profile picture</th>
                            <td>
                                <img src="/">
                            </td>
                        </tr>
                        <tr>
                            <th style="background-color: #ff6969;">Username</th>
                            <td>
<#--                                ${user.userName}-->
                            </td>
                        </tr>
                        <tr>
                            <th style="background-color: #ff6969;">User roles</th>
                            <td>
<#--                                ${user.roles}-->
                            </td>
                        </tr>
                        <tr>
                            <th style="background-color: #ff6969;">Change Password</th>
                            <td>
                                <input class="input" type="password" name="current_password" placeholder="Current password">
                                <input class="input" type="password" name="new_password" placeholder="New password">
                                <input class="input" type="password" name="confirm_password" placeholder="Confirm password">
                            </td>
                        </tr>
                        <tr>
                            <th style="background-color: #ff6969;">User actions</th>
                            <td>
                                <div class="buttons">
                                    <a class="button is-danger" href="http://localhost:8080/logout">
                                        Log out
                                    </a>
                                </div>
                            </td>
                        </tr>

                        </thead>
                    </table>
                </div>
            </div>
            <div class="column"></div>
        </div>
    </div>
</div>
</body>
</html>