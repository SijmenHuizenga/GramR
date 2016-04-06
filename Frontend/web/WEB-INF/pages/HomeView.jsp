<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:template>
    <!-- Page Heading -->
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">GramR Applicatie
                <small>Instagram & Flicker Link</small>
            </h1>
            Welkom op de applicatie!
            Klik <a href="${pageContext.request.contextPath}/photos">hier</a> om alle foto's te bekijken.<br>
            Klik <a href="${pageContext.request.contextPath}/sets">hier</a> om alle je sets's te bekijken.<br>
            <br>
            <form method="get" action=".">
                <div class="form-group">
                    <label for="user">Gebruiker:</label>
                    <input type="text" class="form-control" id="user" placeholder="user" name="user" value="${user}">
                </div>
                <button type="submit" class="btn btn-default">Opslaan</button>
            </form>
            <hr>
            <h2>REST backend tests:</h2>
            <ul>
                <li><a target="_blank" href="http://localhost:8092/rest/exampledata">Example Service</a></li>
                <li><a target="_blank" href="http://localhost:8092/rest/filter/1">Filter Get</a></li>
                <li><a target="_blank" href="http://localhost:8092/rest/filter/set/1/Sijmen/null/somedata">Filter Set</a></li>
                <li><a target="_blank" href="http://localhost:8092/rest/photo/getall">Photo getAll</a></li>
                <li><a target="_blank" href="http://localhost:8092/rest/photo/1">Photo Get</a></li>
                <li><a target="_blank" href="http://localhost:8092/rest/set/get/Sijmen/Time">Set Get By name</a></li>
                <li><a target="_blank" href="http://localhost:8092/rest/set/list/Sijmen">Set List of User</a></li>
                <li><a target="_blank" href="http://localhost:8092/rest/set/deletephoto/Sijmen/Time/1">Set Del Photo</a></li>
                <li><a target="_blank" href="http://localhost:8092/rest/set/addphoto/Sijmen/Time/1">Set Add Photo</a></li>
                <li><a target="_blank" href="http://localhost:8092/rest/set/toggleopen/Sijmen/Time/1">Set Toggle Open Photo</a></li>
            </ul>
        </div>
    </div>

</t:template>

