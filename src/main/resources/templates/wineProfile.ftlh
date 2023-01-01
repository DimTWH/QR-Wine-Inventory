<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css">
    <title>Wine Profile | QR Wine Inventory</title>
</head>
<body>
<div class="container">
    <#include "navbar.ftlh">
    <div class="content">
        <div class="columns">
            <div class="column"></div>
            <div class="column">
                <div class="table-container">
                    <table class="table is-striped is-hoverable">
                        <thead>
                        <tr>
                            <th class="black" style="background-color: #ff6969;width: 150px">Wine ID</th>
                            <td>
                                ${wine.uid}
                            </td>
                        </tr>
                        <tr>
                            <th style="background-color: #ff6969;">Brand or Grape(s)</th>
                            <td>
                                ${wine.brandGrape}
                            </td>
                        </tr>
                        <tr>
                            <th style="background-color: #ff6969;">Winery</th>
                            <td>
                                ${wine.winery}
                            </td>
                        </tr>
                        <tr>
                            <th style="background-color: #ff6969;">Quantity</th>
                            <td>
                                ${wine.quantity}
                            </td>
                        </tr>
                        <tr>
                            <th style="background-color: #ff6969;">Vintage</th>
                            <td>
                                ${wine.vintage}
                            </td>
                        </tr>
                        <tr>
                            <th style="background-color: #ff6969;">Price</th>
                            <td>
                                ${wine.price}
                            </td>
                        </tr>
                        <tr>
                            <th style="background-color: #ff6969;">Color</th>
                            <td>
                                ${wine.color}
                            </td>
                        </tr>
                        <tr>
                            <th style="background-color: #ff6969;">Type</th>
                            <td>
                                ${wine.type}
                            </td>
                        </tr>
                        <tr>
                            <th style="background-color: #ff6969;">QR code</th>
                            <td>
                                <img src="/pictures/${wine.image_pp}">
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