<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Book Management</title>
    <style>
        li{
            list-style: none;
        }
        #insert{
            width: 30%;
            height: 100px;
            border: 5px solid green;
        }
        #list{
            width: 30%;
            height: 500px;
            border: 5px solid red;
            display: inline-block;
            overflow: scroll;
        }
        #findone{
            width: 30%;
            height: 200px;
            border: 5px solid blue;
        }
    </style>
    </head>
    <body>
        <div id="insert">
            <form action="/insert" method="post">
                <input type="text" id="title" name="title" placeholder="Book title"> <br>
                <input type="text" id="author" name="author" placeholder="Author"> <br>
                <input type="text" id="publisher" name="publisher" placeholder="Publisher"> <br>
                <input type="text" id="publicationDate" name="publicationDate" placeholder="Publication Date (YYYY-MM-DD)"> <br>
                <input type="submit" value="Add Book">
            </form>
        </div>
        
        <div id="main">
            <div id="list">
                <input type="text" id="search" name="search" placeholder="Search"> 
                <button onclick="search()">Search</button>
                <hr>
                <c:forEach var="book" items="${list}">
                    <li onclick="location.href='/findOne?id=${book.id}'">
                        ${book.id}
                        ${book.title} <br>
                        ${book.author} <br>
                        ${book.publisher} <br>
                        ${book.publicationDate}
                    </li> <hr>
                </c:forEach>
            </div>
        
            <div id="findone">
                ${book.id} <br>
                ${book.title} <br>
                ${book.author} <br>
                ${book.publisher} <br>
                ${book.publicationDate} <br>
                <input type="button" id="upbtn" value="Update" onclick="location.href='/update?id=${book.id}'">
                <input type="button" id="delbtn" value="Delete" onclick="location.href='/delete?id=${book.id}'">
            </div>
            
        </div>
    </body>
    </html>