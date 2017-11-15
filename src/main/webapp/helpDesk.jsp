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
            <li><a href = "Database Administrator.jsp">Database Administrator</a></li>
            <li><a href="helpDesk.jsp">IT Help Desk</a></li>
            <li><a href="Web Developer.jsp">Web Developer</a></li>
            <li><a href="Software Developer.jsp">Software Developer</a></li>
        </ul>

    </div>
</div>
<div class="main">

    <div id = "categoryNavBar">
        <ul>
            <li class = "category">SQL Programming</li>
            <li class = "category">Database Design</li>
            <li class = "category">Database Theory</li>
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


