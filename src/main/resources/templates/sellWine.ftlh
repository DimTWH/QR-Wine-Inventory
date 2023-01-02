<meta name="viewport" content="width=device-width, initial-scale=1"><!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css">
    <title>Sell Wine | QR Wine Inventory</title>
</head>
<body>
<#include "navbar.ftlh">
<div class="container is-max-widescreen">
    <div class="content">
        <form action="sellWine?id=${wine.uid}" method="post">
            <div class="columns">
                <div class="column"></div>
                <div class="column" style="background-color: white; padding: 2rem">
                    <h3>Register a purchase for: ${wine.brand_grape} (Maximum: ${wine.quantity})</h3>
                    <div class="field">
                        <label class="label">Quantity</label>
                        <div class="control">
                            <input class="input" style="width: 50%;" type="number" min="1" max="${wine.quantity}" name="quantity" placeholder="Type here...">
                        </div>
                    </div>
                    <div class="field is-right" style="display: inline">
                        <div class="control is-right">
                            <a href="http://localhost:8080/inventory/wine/index" class="button is-normal is-right" type="submit">Cancel</a>
                        </div>
                        <div class="control is-right">
                            <button class="button is-link is-right" type="submit">Submit</button>
                        </div>
                    </div>
                </div>
                <div class="column"></div>
            </div>
        </form>
    </div>
</div>
<#include "js/script.ftlh">
</body>
</html>