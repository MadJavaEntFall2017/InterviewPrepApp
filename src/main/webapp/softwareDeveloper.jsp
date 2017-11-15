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
            <li><a href = "databaseAdmin.jsp">Database Administrator</a></li>
            <li><a href="webDeveloper.jsp">Web Developer</a></li>
            <li><a href="softwareDeveloper.jsp">Software Developer</a></li>
        </ul>

    </div>
</div>
<div class="main">
    GET http://localhost:8080/cards/categories/2/html
    <div id = "categoryNavBar">
        <ul>
            <li class = "category">Java</li>
            <li class = "category">Object Oriented Programming</li>
        </ul>
    </div>
    <section id = "flashcard">

    </section>

</div>
<div class="title">
    <h1>Interview Prep App</h1>

</div>

</body>
</html>



