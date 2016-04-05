<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:template>
  <%--@elvariable id="thePhoto" type="it.sijmen.gramr.common.pojo.Photo"--%>
  <%--@elvariable id="canEdit" type="boolean"--%>

  <div class="row">
    <div class="col-lg-12">
      <h1 class="page-header">Photo ${thePhoto.title} <small>${thePhoto.creator}</small></h1>
    </div>
    <c:if test="${not empty thePhoto.filter}">
    <div class="col-lg-12">
      <p>Filter: ${thePhoto.filter.description}</p>
    </div>
    </c:if>
  </div>

  <div class="row">
    <div class="col-lg-6 col-lg-offset-3">
      <img src="${thePhoto.url}" class="img-responsive">
    </div>
  </div>

  <c:if test="${canEdit}">
    <hr>
    <div class="row">
      <div class="col-lg-12">
        <a href="${pageContext.request.contextPath}/photo?id=${thePhoto.id}&setFilter=null">Remove all filters</a> |
        <a href="${pageContext.request.contextPath}/photo?id=${thePhoto.id}&setFilter=gray">Set to Gray filter</a> |
        <a href="${pageContext.request.contextPath}/photo?id=${thePhoto.id}&setFilter=vintage">set to Vintage filter</a>
      </div>
    </div>
  </c:if>

</t:template>

