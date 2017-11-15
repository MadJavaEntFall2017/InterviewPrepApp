<html>
<%@include file="head.jsp"%>
<body>
<div class="title">
    <h1>Interview Prep App</h1>

</div>

<div class="sidebar">
    <div><h2>Pick a Job</h2></div>
    GET http://localhost:8080/cards/job/html
    <div>
        <ul>
            <li><a href = "databaseAdmin.jsp">Database Administrator</a></li>
            <li><a href="webDeveloper.jsp">Web Developer</a></li>
            <li><a href="softwareDeveloper.jsp">Software Developer</a></li>
        </ul>

    </div>
</div>
<div class="main">
    <section id = "flashcard">

    </section>

</div>


</body>
</html>



