<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html><body>
<h2>Add/Edit Student</h2>
<form action="/student/save" method="post">
    <input type="hidden" name="id" value="${student.id}" />
    Name: <input type="text" name="name" value="${student.name}" /><br/>
    Courses:<br/>
    <c:forEach var="course" items="${courses}">
        <input type="checkbox" name="courses" value="${course.id}" /> ${course.title}<br/>
    </c:forEach>
    <input type="submit" value="Save"/>
</form>
</body></html>
