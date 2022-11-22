<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="../layout/app.jsp">
    <c:param name="content">
        <c:if test="${flush != null}">
            <div id="flush_success">
                <c:out value="${flush}"></c:out>
            </div>
        </c:if>
        <h2>面談予定管理システムへようこそ</h2>
        <h3>【メニュー】</h3>

		<a href="<c:url value='/schedules/mySchedule' />">自分の面談予定一覧</a><br>
		<a href="<c:url value='/schedules/new' />">新規予定の登録</a><br>

         <c:if test="${sessionScope.login_employee != null}">
                        <c:if test="${sessionScope.login_employee.admin_flag == 1}">
                            <a href="<c:url value='/departments/index' />">部署情報管理</a>&nbsp;<br>
                            <a href="<c:url value='/employees/index' />">社員情報管理</a>&nbsp;<br>
                        </c:if>
                        <a href="<c:url value='/schedules/index' />">面談予定管理</a>&nbsp;
                    </c:if>
<br><br><br><br><br><br><br>
    </c:param>
</c:import>