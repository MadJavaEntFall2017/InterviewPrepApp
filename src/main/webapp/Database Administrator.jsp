<html>
<%@include file="head.jsp"%>
<body>
<!--<div class="title">
    <h1>Interview Prep App</h1>

</div>
<div class="sidebar">
    <div><h2>Select a Job</h2></div>
    <div>
        <ul>
            <li><a href ="Database Administrator.jsp">Database Administrator</a></li>
            <li><a href="Web Developer.jsp">Web Developer</a></li>
            <li><a href="Software Developer.jsp">Software Developer</a></li>
        </ul>

    </div>
</div>
<div class="main">
-->



    <div id = "categoryNavBar">
        <div><h2><a href = "http://localhost:8080/cards/categories/0/html" target = "cat">Pick a Category:</a></h2></div><br>
        <iframe name = "cat">
        </iframe>


    </div>
    <label>
        <input type="checkbox"  />
        <div class="card">
            <div class="front"><iframe name = "flashcard" width = "250" height = "250"></iframe></div>
            <div class="back">Back</div>
        </div>
    </label>

</div>


</body>
</html>


