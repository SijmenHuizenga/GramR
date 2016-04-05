<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:template>
  <div class="row">
    <div class="col-lg-12">
      <h1 class="page-header">Sets <small>${user}</small></h1>

      <table class="table">
        <thead>
          <tr>
            <td>Naam</td>
            <td>Aantal foto's</td>
          </tr>
        </thead>
        <tbody>

        <c:forEach var="set" items="${setList}">
          <tr>
            <td><c:out value="${set.name}" /> </td>
            <td><c:out value="${set.photoAmount}"/></td>
            <td><a href="/set?name=<c:out value="${set.name}"/>">Open</a></td>
          </tr>
        </c:forEach>

        </tbody>
      </table>

    </div>
  </div>

</t:template>

