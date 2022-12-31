<meta name="viewport" content="width=device-width, initial-scale=1"><!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css">
    <title>Add New Wine | QR Wine Inventory</title>
</head>
<body>

<div class="container is-max-widescreen">
    <#include "navbar.ftlh">
    <div class="content">
        <form action="saveNew" method="post">
            <div class="columns">
                <div class="column"></div>
                <div class="column">
                    <div class="field">
                        <label class="label">Brand or Grape(s)</label>
                        <div class="control">
                            <input class="input" type="text" name="brandGrape" placeholder="Type here...">
                        </div>
                    </div>
                    <div class="field">
                        <label class="label">Winery</label>
                        <div class="control">
                            <input class="input" type="text" name="winery" placeholder="Type here...">
                        </div>
                    </div>
                    <div class="field">
                        <label class="label">Quantity</label>
                        <div class="control">
                            <input class="input" style="width: 150px;" type="number" name="quantity" placeholder="Type here...">
                        </div>
                    </div>
                    <div class="field">
                        <label class="label">Price</label>
                        <div class="control">
                            <input class="input" style="width: 150px;" type="number" name="price" placeholder="Type here...">
                        </div>
                    </div>
                </div>
                <div class="column">
                    <div class="field">
                        <label class="label">Vintage</label>
                        <div class="control is-center">
                            <input class="input" style="width: 150px;" type="text" name="vintage" placeholder="Type here...">
                        </div>
                    </div>
                    <div class="field">
                        <label class="label">Color</label>
                        <div class="control">
                            <input class="input" type="text" name="color" placeholder="Type here...">
                        </div>
                    </div>
                    <div class="field">
                        <label class="label">Alcohol</label>
                        <div class="control">
                            <input class="input" type="text" name="alcohol" placeholder="Type here...">
                        </div>
                    </div>
                    <div class="field">
                        <label class="label">Type</label>
                        <div class="control">
                            <input class="input" type="text" name="type" placeholder="Type here...">
                        </div>
                    </div>
                    <div class="field is-grouped">
                        <div class="control">
                            <a href="index is-right">
                                <button class="button is-link is-light">Cancel</button>
                            </a>
                        </div>
                        <div class="control">
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