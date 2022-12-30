<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Index | Wine Attitude Inventory</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css">
</head>
<body>
    <div class="container">
        <div class="content">
            <#include "navbar.ftlh">
            <div class="table-container">
                <table class="table is-striped is-hoverable">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Name</th>
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
                                <td><#if wine.brandGrape?has_content>${wine.brandGrape}<#else>/</#if></td>
                            <td><#if wine.quantity?has_content>${wine.quantity} bottles<#else>/</#if></td>
                            <td><#if wine.price?has_content>€${wine.price}<#else>/</#if></td>
                            <td><#if wine.winery?has_content>${wine.winery}<#else>/</#if></td>
                            <td><#if wine.vintage?has_content>${wine.vintage}<#else>/</#if></td>
                            <td><#if wine.color?has_content>${wine.color}<#else>/</#if></td>
                            <td><#if wine.alcohol?has_content>${wine.alcohol}%<#else>/</#if></td>
                            <td><#if wine.type?has_content>${wine.type}<#else>/</#if></td>
                            <td><a class="button is-small is-warning" role="button"
                                   href="update?id=${wine.uid}">Update</a>
                                <form method="delete">
                                <a class="button is-small is-danger" role="button"
                                   href="delete?id=${wine.uid}">Delete</a></form>
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