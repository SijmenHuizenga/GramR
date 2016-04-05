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
        </div>
    </div>

</t:template>

