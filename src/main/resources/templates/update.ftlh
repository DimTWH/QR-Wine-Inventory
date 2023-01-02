<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css">
    <title>Update Wine | QR Wine Inventory</title>
</head>
<body>
<#include "navbar.ftlh">
<div class="container">
    <div class="content">
        <form action="save?id=${wine.uid}" method="post">
            <div class="columns">
                <div class="column"></div>
                <div class="column" style="background-color: white; padding: 2rem">
                    <div class="field">
                        <label class="label">Brand or Grape(s)</label>
                        <div class="control">
                            <input class="input" type="text" name="brand_grape" placeholder="Type here..." value="${wine.brand_grape}">
                        </div>
                    </div>
                    <div class="field">
                        <label class="label">Winery</label>
                        <div class="control">
                            <input class="input" type="text" name="winery" placeholder="Type here..." value="${wine.winery}">
                        </div>
                    </div>
                    <div class="field">
                        <label class="label">Quantity</label>
                        <div class="control">
                            <input class="input" type="text" min="0" name="quantity" placeholder="Type here..." value="${wine.quantity}">
                        </div>
                    </div>
                    <div class="field">
                        <label class="label">Price</label>
                        <div class="control">
                            <input class="input" type="text" name="price" placeholder="Type here..." value="${wine.price}">
                        </div>
                    </div>
                </div>
                <div class="column" style="background-color: white; padding: 2rem">
                    <div class="field">
                        <label class="label">Vintage</label>
                        <div class="control">
                            <input class="input" type="text" name="vintage" placeholder="Type here..." value="${wine.vintage}">
                        </div>
                    </div>
                    <div class="field">
                        <label class="label">Color</label>
                        <div class="control">
                            <input class="input" type="text" name="color" placeholder="Type here..." value="${wine.color}">
                        </div>
                    </div>
                    <div class="field">
                        <label class="label">Alcohol</label>
                        <div class="control">
                            <input class="input" type="text" name="alcohol" placeholder="Type here..." value="${wine.alcohol}">
                        </div>
                    </div>
                    <div class="field">
                        <label class="label">Type</label>
                        <div class="control">
                            <input class="input" type="text" name="type" placeholder="Type here..." value="${wine.type}">
                        </div>
                    </div>
                    <div class="field">
                        <div class="control">
                            <a href="http://localhost:8080/inventory/wine?id=${wine.uid}" class="button is-link is-light">Cancel</a>
                        </div>
                    </div>
                    <div class="field">
                        <div class="control">
                            <button class="button is-link" type="submit">Submit</button>
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