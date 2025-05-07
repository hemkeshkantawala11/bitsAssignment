<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html><body>
<h2>Courses</h2>
<a href="/courses/add">Add New</a>
<table border="1">
    <tr><th>Title</th><th>Enrolled Students</th><th>Actions</th></tr>
    <c:forEach var="course" items="${courses}">
        <tr>
            <td>${course.title}</td>
            <td>
                <c:forEach var="student" items="${course.students}">
                    ${student.name}<br/>
                </c:forEach>
            </td>
            <td><a href="/courses/edit/${course.id}">Edit</a></td>
        </tr>
    </c:forEach>
</table>
</body></html>