<%-- 
    Document   : editnote
    Created on : Jan 24, 2020, 10:46:48 AM
    Author     : 787900
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Edit</h1>
        <h2>Edit Note</h2>
        <form method="POST" action="/Week3Lab_SimpleNoteKeeper/note">
        Title: <input type="text" name="title" /><br/>
        contents: <textarea name="contents"></textarea><br/>
        <input type="submit" value="Save"      />
        </form>
        
    </body>
</html>
