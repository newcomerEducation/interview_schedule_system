<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:if test="${errors != null}">
	<div id="flush_error">
		入力内容にエラーがあります。<br />
		<c:forEach var="error" items="${errors}">
            ・<c:out value="${error}" />
			<br />
		</c:forEach>

	</div>


</c:if>
<label for="project_title">案件名（必須）</label>
<br />
<input type="text" name="project_title"
	value="${schedule.project_title}" />
<br />
<br />
<label for="employee_id">社員名（必須）</label>
<br />
<select name="employee_id">
	<c:forEach var="employee" items="${employees}">
		<option value="${employee.id}"
			<c:if test="${employee.id == schedule.employee.id}"> selected</c:if>>
			${employee.employee_code} : ${employee.employee_name}</option>
	</c:forEach>

</select>


<br />
<br />



<label for="place">場所（必須）</label>
<br />
<input type="text" name="place" value="${schedule.place}" />
<br />
<br />



<label for="ordering_company">得意先会社名（必須）</label>
<br />
<input type="text" name="ordering_company"
	value="${schedule.ordering_company}" />
<br />
<br />

<label for="place">得意先営業担当（必須）</label>
<br />
<input type="text" name="v_OrderedCompany_SalesName"
	value="${schedule.v_OrderedCompany_SalesName}" />
<br />
<br />




<label for="introduce_date_date">紹介日（必須）</label>
<br />
<input type="date" name="introduce_date"
	value="<fmt:formatDate value='${schedule.introduce_date}' pattern='yyyy-MM-dd' />" />
<br />
<br />

<label for="project_overview">案件概要（必須）</label>
<br />
<textarea name="project_overview" rows="10" cols="50">${schedule.project_overview}</textarea>
<br />
<br />

<label for="number_of_interviews">予定面談回数（必須）</label>
<br />
<input type="number" min="0" max="5" name="number_of_interviews"
	value="${schedule.number_of_interviews}" />
<br />
<br />
<label for="aspiration_situation">本人面談希望（必須）</label>
<br />
<select name="aspiration_situation">
	<option value="0"
		<c:if test="${empty schedule.aspiration_situation}"> selected</c:if>></option>
	<option value="1"
		<c:if test="${schedule.aspiration_situation == 1}"> selected</c:if>>確認中</option>
	<option value="2"
		<c:if test="${schedule.aspiration_situation == 2}"> selected</c:if>>希望する</option>
	<option value="3"
		<c:if test="${schedule.aspiration_situation == 3}"> selected</c:if>>希望しない</option>
</select>
<br />
<br />
<label for="v_EmployeeComfirmedResultNG">本人面談辞退理由</label>
<br />
<textarea name="v_EmployeeComfirmedResultNG" rows="5" cols="50">${schedule.v_EmployeeComfirmedResultNG}</textarea>
<br />
<br />


<label for="priority">優先順位（必須）</label>
<br />
<input type="number" min="1" max="20" name="priority"
	value="${schedule.priority}" />
<br />
<br />


<label for="interview_situation">面談ステータス（必須）</label>
<br />
<select name="interview_situation">
	<option value="0"
		<c:if test="${empty schedule.interview_situation}"> selected</c:if>></option>
	<option value="1"
		<c:if test="${schedule.interview_situation == 1}"> selected</c:if>>本人確認中</option>
	<option value="2"
		<c:if test="${schedule.interview_situation == 2}"> selected</c:if>>面談日程調整中（1次）</option>
	<option value="3"
		<c:if test="${schedule.interview_situation == 3}"> selected</c:if>>面談日程確定（1次）</option>
	<option value="4"
		<c:if test="${schedule.interview_situation == 4}"> selected</c:if>>面談結果待ち（1次）</option>
	<option value="5"
		<c:if test="${schedule.interview_situation == 5}"> selected</c:if>>面談日程調整中（2次）</option>
	<option value="6"
		<c:if test="${schedule.interview_situation == 6}"> selected</c:if>>面談日程確定（2次）</option>
	<option value="7"
		<c:if test="${schedule.interview_situation == 7}"> selected</c:if>>面談結果待ち（2次）</option>
	<option value="8"
		<c:if test="${schedule.interview_situation == 8}"> selected</c:if>>見送り</option>
	<option value="9"
		<c:if test="${schedule.interview_situation == 9}"> selected</c:if>>本人辞退</option>
	<option value="10"
		<c:if test="${schedule.interview_situation == 10}"> selected</c:if>>参画日調整中</option>
	<option value="11"
		<c:if test="${schedule.interview_situation == 11}"> selected</c:if>>参画日決定</option>

</select>
<br />
<br />

<label for="v_AccountingSlackLink">概要リンク（必須）</label>
<br />
<input type="text" name="v_AccountingSlackLink"
	value="${schedule.v_AccountingSlackLink}" />

<br />
<br />

<label for="first_interview_scheduled_date">一次面談予定日</label>
<br />
<input type="date" name="first_interview_scheduled_date"
	value="<fmt:formatDate value='${schedule.first_interview_scheduled_date}' pattern='yyyy-MM-dd' />" />
<br />
<br />

<label for="first_interview_scheduled_time">一次面談予定時間</label>
<br />

<input type="time" name="first_interview_scheduled_time"
<fmt:parseDate value="${schedule.first_interview_scheduled_time }"
	pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime" type="both" />
value = "<fmt:formatDate  value="${ parsedDateTime }" pattern="HH:mm" />"/>
<%--  value="<fmt:formatDate value='${schedule.first_interview_scheduled_time}' pattern='HH:mm' />"--%>
<br />
<br />

<label for="first_interview_format">一次面談形式</label>
<br />
<select name="first_interview_format">
	<option value="0"
		<c:if test="${empty schedule.first_interview_format}"> selected</c:if>></option>
	<option value="1"
		<c:if test="${schedule.first_interview_format == 1}"> selected</c:if>>対面</option>
	<option value="2"
		<c:if test="${schedule.first_interview_format == 2}"> selected</c:if>>オンライン</option>
	<option value="3"
		<c:if test="${schedule.first_interview_format == 3}"> selected</c:if>>その他</option>
</select>
<br />
<br />

<label for="first_interview_tool">一次面談ツール</label>
<br />
<input type="text" name="first_interview_tool"
	value="${schedule.first_interview_tool}" />
<br />
<br />

<label for="first_interview_url">一次面談URL</label>
<br />
<input type="text" name="first_interview_url"
	value="${schedule.first_interview_url}" />
<br />
<br />

<label for="first_interview_id">一次面談ID</label>
<br />
<input type="text" name="first_interview_id"
	value="${schedule.first_interview_id}" />
<br />
<br />

<label for="first_interview_password">一次面談パスワード</label>
<br />
<input type="text" name="first_interview_password"
	value="${schedule.first_interview_password}" />
<br />
<br />

<label for="d_SecondInterviewScheduledDate">二次面談予定日</label>
<br />
<input type="date" name="d_SecondInterviewScheduledDate"
	value="<fmt:formatDate value='${schedule.d_SecondInterviewScheduledDate}' pattern='yyyy-MM-dd' />" />
<br />
<br />

<label for="d_SecondInterviewScheduledTime">二次面談予定時間</label>
<br />
<input type="time" name="d_SecondInterviewScheduledTime"
<fmt:parseDate value="${schedule.d_SecondInterviewScheduledTime }"
	pattern="yyyy-MM-dd'T'HH:mm" var="parsedDateTime2" type="both" />
 value = "<fmt:formatDate  value="${ parsedDateTime2 }" pattern="HH:mm" />"/>
<%--  value="<fmt:formatDate value='${schedule.d_SecondInterviewScheduledTime}' pattern='HH:mm' />"--%>
<br />
<br />

<label for="v_SecondInterviewFormat">二次面談形式</label>
<br />
<select name="v_SecondInterviewFormat">
	<option value="0"
		<c:if test="${empty schedule.v_SecondInterviewFormat}"> selected</c:if>></option>
	<option value="1"
		<c:if test="${schedule.v_SecondInterviewFormat == 1}"> selected</c:if>>対面</option>
	<option value="2"
		<c:if test="${schedule.v_SecondInterviewFormat == 2}"> selected</c:if>>オンライン</option>
	<option value="3"
		<c:if test="${schedule.v_SecondInterviewFormat == 3}"> selected</c:if>>その他</option>
</select>


<br />
<br />

<label for="v_SecondInterviewTool">二次面談ツール</label>
<br />
<input type="text" name="v_SecondInterviewTool"
	value="${schedule.v_SecondInterviewTool}" />
<br />
<br />

<label for="v_SecondInterviewUrl">二次面談URL</label>
<br />
<input type="text" name="v_SecondInterviewUrl"
	value="${schedule.v_SecondInterviewUrl}" />
<br />
<br />

<label for="v_SecondInterviewId">二次面談ID</label>
<br />
<input type="text" name="v_SecondInterviewId"
	value="${schedule.v_SecondInterviewId}" />
<br />
<br />

<label for="v_SecondInterviewPW">二次面談パスワード</label>
<br />
<input type="text" name="v_SecondInterviewPW"
	value="${schedule.v_SecondInterviewPW}" />
<br />
<br />
<label for="v_InterviewResultNG">見送り理由</label>
<br />
<textarea name="v_InterviewResultNG" rows="5" cols="50">${schedule.v_InterviewResultNG}</textarea>
<br />
<br />

<input type="hidden" name="_token" value="${_token}" />
<button type="submit">登録</button>
