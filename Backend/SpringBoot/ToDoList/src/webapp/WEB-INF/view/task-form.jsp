
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<html>

<head>

<title>Add Task</title>

<link rel="stylesheet" href="/resources/css/style.css">

</head>

<body>

<nav class="navbar">

<div>
<h1>✔ TaskTrack</h1>
<p>Team Task Manager</p>
</div>

<a href="/tasks" class="btn btn-primary">Back</a>

</nav>

<div class="container">

<div class="form-card">

<h2>Add New Task</h2>

<form:form method="post"
action="/tasks/save"
modelAttribute="task"
enctype="multipart/form-data">

<div class="form-group">

<label>Title</label>

<form:input path="title"/>

<form:errors path="title" cssClass="error"/>

</div>

<div class="form-group">

<label>Description</label>

<form:textarea path="description"/>

<form:errors path="description" cssClass="error"/>

</div>

<div class="form-group">

<label>Due Date</label>

<form:input path="dueDate" type="date"/>

<form:errors path="dueDate" cssClass="error"/>

</div>

<div class="form-group">

<label>Priority</label>

<form:select path="priority">

<form:option value="">Select</form:option>

<form:option value="LOW">LOW</form:option>

<form:option value="MEDIUM">MEDIUM</form:option>

<form:option value="HIGH">HIGH</form:option>

</form:select>

<form:errors path="priority" cssClass="error"/>

</div>

<div class="form-group">

<label>Task Image</label>

<input type="file" name="imageFile" accept="image/*">

</div>

<div class="form-buttons">

<button type="submit" class="btn btn-primary">
Save Task
</button>

<a href="/tasks" class="btn btn-delete">
Cancel
</a>

</div>

</form:form>

</div>

</div>

</body>

</html>
