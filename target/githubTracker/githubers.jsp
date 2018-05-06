<h1>githubers</h1>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="header.jsp"%>

<h1>page githubers</h1>

<table class="table table-bordered">
    <c:forEach var="iList" items="${List}" >
        <tr>
            <td><c:out value="${iList.id}"/></td>
            <td><c:out value="${iList.name}"/></td>
            <td><c:out value="${iList.email}"/></td>
            <td><c:out value="${iList.login}"/></td>
            <td><img src="<c:out value="${iList.avatarUrl}"/>"></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
