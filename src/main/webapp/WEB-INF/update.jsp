<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Book</title>
</head>
<body>
    <form action="/update" id="updateform" method="post">
        <input type="text" id="upId" name="id" value="${book.id}" hidden=true readonly>
        <ul>
            <li><h1>Update Book Information</h1></li>
            <li><input type="text" id="uptitle" name="title" value="${book.title}"></li>
            <li><input type="text" id="upauthor" name="author" value="${book.author}"></li>
            <li><input type="text" id="uppublisher" name="publisher" value="${book.publisher}"></li>
            <li><input type="text" id="uppublicationDate" name="publicationDate" value="${book.publicationDate}"></li>
            <li><input type="submit" id="upbtn" value="Save"><input type="button" id="cancelbtn" value="Cancel"></li>
        </ul>
    </form>
</body>
</html>