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
            <div class="table-container">
                <table class="table is-striped is-hoverable">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Name</th>
                        <th>Quantity</th>
                        <th>Price</th>
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
                            <th scope="row">${wine.uid}</th>
                            <td>${wine.brandGrape}</td>
                            <td>${wine.quantity}</td>
                            <td>€${wine.price}</td>
                            <td>${wine.vintage}</td>
                            <td>${wine.color}</td>
                            <td>${wine.alcohol}</td>
                            <td>${wine.type}</td>
                            <td><a class="button is-small is-warning" role="button"
                                   href="/update/${wine.uid}">Update</a>
                                <a class="button is-small is-danger" role="button"
                                   href="/delete/${wine.uid}">Delete</a></td>
                        </tr>
                    </#list>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>