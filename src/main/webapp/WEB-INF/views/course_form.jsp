<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html><body>
<h2>Add/Edit Course</h2>
<form action="/courses/save" method="post">
    <input type="hidden" name="id" value="${course.id}" />
    Title: <input type="text" name="title" value="${course.title}" /><br/>
    <input type="submit" value="Save"/>
</form>
</body></html>