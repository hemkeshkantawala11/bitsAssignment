<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html><body>
<h2>Students</h2>
<a href="/student/add">Add New</a>
<table border="1">
    <tr><th>Name</th><th>Courses</th><th>Actions</th></tr>
    <c:forEach var="student" items="${students}">
        <tr>
            <td>${student.name}</td>
            <td>
                <c:forEach var="course" items="${student.courses}">
                    ${course.title}<br/>
                </c:forEach>
            </td>
            <td><a href="/student/edit/${student.id}">Edit</a></td>
        </tr>
    </c:forEach>
</table>
</body></html>
