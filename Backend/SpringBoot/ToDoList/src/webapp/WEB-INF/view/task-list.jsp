<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>

<title>TaskTrack</title>

<link rel="stylesheet" href="/resources/css/style.css">

</head>

<body>

<nav class="navbar">

<div>
<h1>✔ TaskTrack</h1>
<p>Team Task Manager</p>
</div>

<a href="/tasks/new" class="btn btn-primary">+ Add Task</a>

</nav>

<div class="container">

<div class="stats-row">

<div class="stat-card">
<div class="number">${taskList.size()}</div>
<div>Total Tasks</div>
</div>

<c:set var="pendingCount" value="0"/>
<c:set var="completeCount" value="0"/>

<c:forEach var="t" items="${taskList}">
<c:if test="${t.status=='PENDING'}">
<c:set var="pendingCount" value="${pendingCount+1}"/>
</c:if>

<c:if test="${t.status=='COMPLETE'}">
<c:set var="completeCount" value="${completeCount+1}"/>
</c:if>
</c:forEach>

<div class="stat-card pending">
<div class="number">${pendingCount}</div>
<div>Pending</div>
</div>

<div class="stat-card complete">
<div class="number">${completeCount}</div>
<div>Completed</div>
</div>

</div>

<div class="table-wrapper">

<table>

<thead>

<tr>
<th>Image</th>
<th>Title</th>
<th>Description</th>
<th>Due Date</th>
<th>Priority</th>
<th>Status</th>
<th>Actions</th>
</tr>

</thead>

<tbody>

<c:forEach var="task" items="${taskList}">

<tr>

<td>

<c:choose>

<c:when test="${task.imageData != null}">
<img class="task-img" src="/tasks/image/${task.id}">
</c:when>

<c:otherwise>
No Image
</c:otherwise>

</c:choose>

</td>

<td><b>${task.title}</b></td>

<td>${task.description}</td>

<td>${task.dueDate}</td>

<td>

<c:choose>

<c:when test="${task.priority=='HIGH'}">
<span class="badge badge-high">HIGH</span>
</c:when>

<c:when test="${task.priority=='MEDIUM'}">
<span class="badge badge-medium">MEDIUM</span>
</c:when>

<c:otherwise>
<span class="badge badge-low">LOW</span>
</c:otherwise>

</c:choose>

</td>

<td>

<c:choose>

<c:when test="${task.status=='COMPLETE'}">
<span class="badge badge-complete">COMPLETE</span>
</c:when>

<c:otherwise>
<span class="badge badge-pending">PENDING</span>
</c:otherwise>

</c:choose>

</td>

<td class="actions">

	<a href="/tasks/toggle/${task.id}" class="btn btn-complete">
	    Completed
	</a>

	<a href="/tasks/delete/${task.id}" class="btn btn-delete">
	    Delete
	</a>

</td>

</tr>

</c:forEach>

</tbody>

</table>

</div>

</div>

</body>

</html>