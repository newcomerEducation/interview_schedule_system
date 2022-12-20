<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:import url="/WEB-INF/views/layout/app.jsp">
	<c:param name="content">
		<c:if test="${flush != null}">
			<div id="flush_success">
				<c:out value="${flush}"></c:out>
			</div>
		</c:if>
		<h2>面談予定 一覧</h2>
		<table id="schedule_list">
			<tbody>
				<tr>
					<!--  <th class="    ">所属部署</th>-->
					<th class="schedule_project_title">案件名</th>
					<th class="schedule_place">場所</th>
					<th class="schedule_ordering_company">得意先会社名</th>
					<%--  <th class="schedule_sales_employee_name">担当営業</th>--%>
					<th class="v_OrderedCompany_SalesName">得意先営業担当者</th>
					<th class="introduce_date">紹介日</th>
					<th class="project_overview">案件概要</th>
					<th class="number_of_interviews">面談予定回数</th>
					<%--   <th class="schedule_aspiration_situation">志望状況</th>--%>
					<th class="schedule_interview_situation">面談ステータス</th>
					<%-- 	<th class="v_AccountingSlackLink">概要リンク</th>
					  <th class="schedule_pass_fail_status">合否状況</th>--%>
					<th class="schedule_first_interview_scheduled_date">一次面談予定日</th>
					<th class="schedule_first_interview_scheduled_time">一次面談予定時間</th>
					<th class="schedule_second_interview_scheduled_date">二次面談予定日</th>
					<th class="schedule_second_interview_scheduled_time">二次面談予定時間</th>
					<th class="schedule_action">操作</th>
				</tr>
				<c:forEach var="schedule" items="${schedules}" varStatus="status">
					<%--<c:forEach var="DateTimeList" items="${DateTimeList}" varStatus="DateTimeList">  --%>
					<tr class="row${status.count % 2}">
						<td class="schedule_project_title"><c:out
								value="${schedule.project_title}" /></td>
						<td class="schedule_place"><c:out value="${schedule.place}" /></td>
						<td class="schedule_ordering_company"><c:out
								value="${schedule.ordering_company}" /></td>
						<td class="v_OrderedCompany_SalesName"><c:out
								value="${schedule.v_OrderedCompany_SalesName}" /></td>
						<td class="schedule_priority"><c:out
								value="${schedule.priority}" /></td>
						<td class="project_overview"><c:out
								value="${schedule.project_overview}" /></td>
						<td class="number_of_interviews"><c:out
								value="${schedule.number_of_interviews}" /></td>
						<td class="schedule_interview_situation">
							<%--<c:out value="${schedule.interview_situation}" /> --%> <c:choose>
								<c:when test="${schedule.interview_situation == 1}">本人確認中</c:when>
								<c:when test="${schedule.interview_situation == 2}">面談日程調整中（1次）</c:when>
								<c:when test="${schedule.interview_situation == 3}">面談日程確定（1次）</c:when>
								<c:when test="${schedule.interview_situation == 4}">面談結果待ち（1次）</c:when>
								<c:when test="${schedule.interview_situation == 5}">面談日程調整中（2次）</c:when>
								<c:when test="${schedule.interview_situation == 6}">面談日程確定（2次）</c:when>
								<c:when test="${schedule.interview_situation == 7}">面談結果待ち（2次）</c:when>
								<c:when test="${schedule.interview_situation == 8}">見送り</c:when>
								<c:when test="${schedule.interview_situation == 9}">本人辞退</c:when>
								<c:when test="${schedule.interview_situation == 10}">参画日調整中</c:when>
								<c:when test="${schedule.interview_situation == 11}">参画日決定</c:when>
								<c:otherwise>（未入力）</c:otherwise>
							</c:choose>
						</td>
						<%--<td class="v_AccountingSlackLink"><c:out
								value="${schedule.v_AccountingSlackLink}" /></td>
						<td class="schedule_pass_fail_status">
                            <c:choose>
                                    <c:when test="${schedule.pass_fail_status == 1}">合格</c:when>
                                    <c:when test="${schedule.pass_fail_status == 2}">不合格</c:when>
                                    <c:otherwise>（未入力）</c:otherwise>
                            </c:choose>
                        </td>--%>
						<td class="schedule_first_interview_scheduled_date"><fmt:formatDate
								value='${schedule.first_interview_scheduled_date}'
								pattern='yyyy-MM-dd' /></td>
						<%-- 	<c:forEach var="DateTimeList" items="${DateTimeList}"
						varStatus="status">
						<tr class="row${status.count % 2}">--%>
						<td class="schedule_first_interview_scheduled_time">
							<%-- <c:out
								value="${schedule.first_interview_scheduled_time}" /> --%>
								<fmt:parseDate	value="${schedule.first_interview_scheduled_time }"
								pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both" />
							<fmt:formatDate pattern="HH:mm"
								value="${ parsedDateTime }" /> <%--<c:out
								value="${DateTimeList}" /> --%>
						</td>





						<%--	<c:forEach var="SecondDateTimeList" items="${SecondDateTimeList}"
						varStatus="status">
						<tr class="row${status.count % 2}"> --%>
						<td class="schedule_second_interview_scheduled_date"><fmt:formatDate
								value='${schedule.d_SecondInterviewScheduledDate}'
								pattern='yyyy-MM-dd' />
						<td class="schedule_second_interview_scheduled_time">
						<fmt:parseDate	value="${schedule. d_SecondInterviewScheduledTime }"
								pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both" />
							<fmt:formatDate pattern="HH:mm"
								value="${ parsedDateTime }" /> <%-- <c:out
								value="${SecondDateTimeList}" />--%></td>

						<td class="schedule_action"><a
							href="<c:url value='/schedules/show?id=${schedule.id}' />">詳細を見る</a></td>


						<%-- <c:forEach var="schedule" items="${schedules}" varStatus="status">
					<tr class="row${status.count % 2}">--%>
						<%-- <fmt:formatDate
								value='${schedule.first_interview_scheduled_time}'
								pattern='HH:mm' /></td>
						<td class="schedule_second_interview_scheduled_date">
                            <fmt:formatDate value='${schedule.second_interview_scheduled_date}' pattern='yyyy-MM-dd' />
                        </td>
                        <td class="schedule_second_interview_scheduled_time">
                            <fmt:formatDate value='${schedule.second_interview_scheduled_time}' pattern='HH:mm' />
                        </td>
						<td class="schedule_action"><a
							href="<c:url value='/schedules/show?id=${schedule.id}' />">詳細を見る</a></td>
					</tr>--%>
				</c:forEach>
			</tbody>
		</table>

		<div id="paginattion">
            (全 ${schedules_count} 件)<br />
            <c:forEach var="i" begin="1" end="${((schedules_count - 1) / 15) + 1}" step="1">
                <c:choose>
                    <c:when test="${i == page}">
                        <c:out value="${i}" />&nbsp;
                    </c:when>
                    <c:otherwise>
                        <a href="<c:url value='/schedules/index?page=${i}' />"><c:out value="${i}" /></a>&nbsp;
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>
		<p>
			<a href="<c:url value='/schedules/new' />">新規予定の登録</a>
		</p>

	</c:param>
</c:import>