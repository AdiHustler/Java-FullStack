<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <title>TaskTrack - Task Manager</title>
            <link rel="stylesheet" href="/resources/css/style.css">
        </head>

        <body>

            <nav class="navbar">
                <div>
                    <h1>&#10003; TaskTrack</h1>
                    <p>Team Task Manager</p>
                </div>
                <a href="/tasks/new" class="btn btn-primary">+ Add New Task</a>
            </nav>

            <div class="container">

                <div class="stats-row">
                    <div class="stat-card">
                        <div class="number">${fn:length(taskList)}</div>
                        <div class="label">Total Tasks</div>
                    </div>
                    <div class="stat-card pending">
                        <div class="number">
                            <c:set var="pendingCount" value="0" />
                            <c:forEach var="task" items="${taskList}">
                                <c:if test="${task.status == 'PENDING'}">
                                    <c:set var="pendingCount" value="${pendingCount + 1}" />
                                </c:if>
                            </c:forEach>
                            ${pendingCount}
                        </div>
                        <div class="label">Pending</div>
                    </div>
                    <div class="stat-card complete">
                        <div class="number">
                            <c:set var="completeCount" value="0" />
                            <c:forEach var="task" items="${taskList}">
                                <c:if test="${task.status == 'COMPLETE'}">
                                    <c:set var="completeCount" value="${completeCount + 1}" />
                                </c:if>
                            </c:forEach>
                            ${completeCount}
                        </div>
                        <div class="label">Completed</div>
                    </div>
                </div>

                <div class="task-table-wrapper">
                    <div class="table-header">
                        <h2>All Tasks</h2>
                    </div>

                    <c:if test="${empty taskList}">
                        <div class="empty-state">
                            <div class="icon">&#128203;</div>
                            <p>No tasks yet. Click "+ Add New Task" to get started!</p>
                        </div>
                    </c:if>

                    <c:if test="${not empty taskList}">
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
                                                    <img class="task-img" src="/tasks/image/${task.id}" />
                                                </c:when>
                                                <c:otherwise>
                                                    <div class="no-img">&#128444;</div>
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td><strong>${task.title}</strong></td>
                                        <td>${task.description}</td>
                                        <td>${task.dueDate}</td>
                                        <td>
                                            <c:choose>
                                                <c:when test="${task.priority == 'HIGH'}">
                                                    <span class="badge badge-high">HIGH</span>
                                                </c:when>
                                                <c:when test="${task.priority == 'MEDIUM'}">
                                                    <span class="badge badge-medium">MEDIUM</span>
                                                </c:when>
                                                <c:when test="${task.priority == 'LOW'}">
                                                    <span class="badge badge-low">LOW</span>
                                                </c:when>
                                            </c:choose>
                                        </td>
                                        <td>
                                            <c:choose>
                                                <c:when test="${task.status == 'COMPLETE'}">
                                                    <span class="badge badge-complete">COMPLETE</span>
                                                </c:when>
                                                <c:otherwise>
                                                    <span class="badge badge-pending">PENDING</span>
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td>
                                            <a href="/tasks/toggle/${task.id}" class="btn btn-complete">&#10003;</a>
                                            <a href="/tasks/delete/${task.id}" class="btn btn-delete">&#128465;</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </c:if>
                </div>

            </div>

        </body>

        </html>