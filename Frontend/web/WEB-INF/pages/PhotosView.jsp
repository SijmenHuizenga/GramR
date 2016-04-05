<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:template>

  <div class="row">
    <div class="col-lg-12">
      <h1 class="page-header">All Photos</h1>

      <table class="table">
        <thead>
        <tr>
          <td>Title</td>
          <td>Creator</td>
          <td>Description</td>
          <td>Filter</td>
          <td>Actie</td>
        </tr>
        </thead>
        <tbody>

        <%--@elvariable id="photosList" type="java.util.List<Photo>"--%>
        <c:forEach var="photo" items="${photosList}">
          <tr>
            <td><a href="<c:out value="${photo.url}"/>"><c:out value="${photo.title}"/></a></td>
            <td><c:out value="${photo.creator}"/></td>
            <td><c:out value="${photo.description}"/></td>

            <td><c:if test="${not empty photo.filter}"><c:out value="${photo.filter.description}"/></c:if></td>
            <td>
              <a href="${pageContext.request.contextPath}/photo?id=<c:out value="${photo.id}"/>">Open</a>
            </td>

          </tr>
        </c:forEach>

        </tbody>
      </table>
    </div>
  </div>

</t:template>

