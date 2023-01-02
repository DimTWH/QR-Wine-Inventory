<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Index | Wine Attitude Inventory</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css">
</head>
<body>
<#include "navbar.ftlh">
    <div class="container">
        <div class="content">

            <div class="table-container">
                <table class="table is-striped is-hoverable">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Brand / Grapes</th>
                        <th>Quantity</th>
                        <th>Price</th>
                        <th>Winery</th>
                        <th>Vintage</th>
                        <th>Color</th>
                        <th>Alcohol</th>
                        <th>Type</th>
                        <th>Actions</th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list wines as wine>
                        <tr>
                            <th scope="row"><a href="http://localhost:8080/inventory/wine?id=${wine.uid}">${wine.uid}</a></th>
                                <td><#if wine.brand_grape?has_content>${wine.brand_grape}<#else>/</#if></td>
                            <td><#if wine.quantity?has_content>${wine.quantity} bottles<#else>/</#if></td>
                            <td><#if wine.price?has_content>€${wine.price}<#else>/</#if></td>
                            <td><#if wine.winery?has_content>${wine.winery}<#else>/</#if></td>
                            <td><#if wine.vintage?has_content>${wine.vintage}<#else>/</#if></td>
                            <td><#if wine.color?has_content>${wine.color}<#else>/</#if></td>
                            <td><#if wine.alcohol?has_content>${wine.alcohol}%<#else>/</#if></td>
                            <td><#if wine.type?has_content>${wine.type}<#else>/</#if></td>
                            <td>
                                <a class="button is-small is-primary" role="button" style="margin-bottom: 5px"
                                   href="sell?id=${wine.uid}">Sell</a>
                                <a class="button is-small is-link" role="button"
                                   href="restock?id=${wine.uid}">Restock</a>
                            </td>
                        </tr>
                    </#list>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

<#include "js/script.ftlh">
</body>
</html>