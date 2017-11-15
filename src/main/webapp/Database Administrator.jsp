<html>
<%@include file="head.jsp"%>
<body>
<div class="title">
    <h1>Interview Prep App</h1>

</div>
<div class="sidebar">
    <div><h2>Select a Job</h2></div>
    <div>
        <ul>
            <li><a href ="databaseAdmin.jsp">Database Administrator</a></li>
            <li><a href="webDeveloper.jsp">Web Developer</a></li>
            <li><a href="softwareDeveloper.jsp">Software Developer</a></li>
        </ul>

    </div>
</div>
<div class="main">
GET http://localhost:8080/cards/categories/0/html
    <div id = "categoryNavBar">
        <ul>
            <li class = "category">SQL Programming</li>
            <li class = "category">Database Design</li>
        </ul>
    </div>
    <label>
        <input type="checkbox"  />
        <div class="card">
            <div class="front">Front</div>
            <div class="back">Back</div>
        </div>
    </label>

</div>


</body>
</html>


