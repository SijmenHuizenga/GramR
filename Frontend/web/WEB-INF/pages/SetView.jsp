<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:template>
  <%--@elvariable id="set" type="it.sijmen.gramr.common.pojo.Set"--%>
  <%--@elvariable id="showEditThings" type="boolean"--%>

  <div class="row">
    <div class="col-lg-12">
      <h1 class="page-header">Set ${set.name} <small>${set.owner}</small></h1>

      <table class="table">
        <thead>
        <tr>
          <td>Title</td>
          <td>Creator</td>
          <td>Open</td>
          <td>Actie</td>
        </tr>
        </thead>
        <tbody>

        <c:forEach var="photoprivacy" items="${set.photos}">
          <tr>
            <td><a href="<c:out value="${photoprivacy.photo.url}"/>"><c:out value="${photoprivacy.photo.title}"/></a></td>
            <td><c:out value="${photoprivacy.photo.creator}"/></td>
            <td><c:out value="${photoprivacy.open}"/></td>
            <td>
              <a href="${pageContext.request.contextPath}/photo?id=<c:out value="${photoprivacy.photo.id}"/>">Open</a>
              <c:if test="${showEditThings}">
                | <a href="/set?name=${set.name}&delPhoto=${photoprivacy.photo.id}">Delete</a>
                | <a href="/set?name=${set.name}&toggleOpen=${photoprivacy.photo.id}">Toggle Open</a>
              </c:if>
            </td>

          </tr>
        </c:forEach>

        </tbody>
      </table>
    </div>
  </div>

  <c:if test="${showEditThings}">
    <hr>
    <div class="row">
      <div class="col-lg-12">
        <a href="/photos?addToSet=${set.name}">Add Photo</a>
      </div>
    </div>
  </c:if>

</t:template>

