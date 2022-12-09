<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <c:choose>
            <c:when test="${schedule != null}">
                <h2>面談予定 照会ページ</h2>

                <table>
                    <tbody>
                     <tr>
                            <th>担当営業</th>
                            <td><c:out value="${schedule.sales_employee.employee_name}" /></td>
                        </tr>
                        <tr>
                            <th>部署名</th>
                            <td><c:out value="${schedule.department.department_name}" /></td>

                        </tr>
                        <tr>
                            <th>社員名</th>
                            <td><c:out value="${schedule.employee.employee_name}" /></td>
                        </tr>
                        <tr>
                            <th>案件名</th>
                            <td><c:out value="${schedule.project_title}" /></td>
                        </tr>
                        <tr>
                            <th>場所</th>
                            <td><c:out value="${schedule.place}" /></td>
                        </tr>

                         <tr>
                            <th>得意先会社名</th>
                            <td><c:out value="${schedule.ordering_company}" /></td>
                        </tr>
                         <tr>
                            <th>得意先会社_営業担当者</th>
                              <td><c:out value="${schedule.v_OrderedCompany_SalesName}" /></td>
                        </tr>

                        <tr>
                            <th>紹介日</th>
                            <td><fmt:formatDate value="${schedule.introduce_date}" pattern="yyyy-MM-dd" /></td>
                        </tr>
                        <tr>
                            <th>案件概要</th>
                            <td>
                                <pre><c:out value="${schedule.project_overview}" /></pre>
                            </td>
                        </tr>
                        <tr>
                            <th>予定面談回数</th>
                            <td><c:out value="${schedule.number_of_interviews}" /></td>
                        </tr>
                         <tr>
                            <th>本人面談希望</th>
                            <td><%--<c:out value="${schedule.aspiration_situation}" /> --%>
                            <c:choose>
							<c:when test="${schedule.aspiration_situation == 1}">確認中</c:when>
							<c:when test="${schedule.aspiration_situation == 2}">希望する</c:when>
							<c:when test="${schedule.aspiration_situation == 3}">希望しない</c:when>
							<c:otherwise>（未入力）</c:otherwise>
						</c:choose></td>

                        </tr>
                        <tr>
                            <th>本人面談辞退理由</th>
                            <td><c:out value="${schedule.v_EmployeeComfirmedResultNG}" /></td>
                        </tr>
                        <tr>
                            <th>優先順位</th>
                            <td><c:out value="${schedule.priority}" /></td>
                        </tr>

                        <tr>
                            <th>面談ステータス</th>
                            <td><%--<c:out value="${schedule.interview_situation}" /> --%>
                            <c:choose>
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
                            </c:choose></td>
                        </tr>
                        <tr>
                            <th>一次面談予定日</th>
                            <td><fmt:formatDate value="${schedule.first_interview_scheduled_date}" pattern="yyyy-MM-dd" /></td>
                        </tr>
                       <tr>
                            <th>一次面談予定時間</th>
                             <td><c:out value="${datetime}" /></td>
                             <%--<td><fmt:formatDate value="${schedule.first_interview_scheduled_time}" pattern="HH:mm" /></td>
                        </tr> --%>
                        <tr>
                            <th>一次面談形式</th>
                            <td><%-- <c:out value="${schedule.first_interview_format}" />--%>
                             <c:choose>
							<c:when test="${schedule.first_interview_format == 1}">対面</c:when>
							<c:when test="${schedule.first_interview_format == 2}">オンライン</c:when>
							<c:when test="${schedule.first_interview_format == 3}">その他</c:when>
							<c:otherwise>（未入力）</c:otherwise>
						</c:choose></td>
                        </tr>
                        <tr>
                            <th>一次面談ツール</th>
                            <td><c:out value="${schedule.first_interview_tool}" /></td>
                        </tr>
                        <tr>
                            <th>一次面談URL</th>
                            <td><c:out value="${schedule.first_interview_url}" /></td>
                        </tr>
                        <tr>
                            <th>一次面談ID</th>
                            <td><c:out value="${schedule.first_interview_id}" /></td>
                        </tr>
                        <tr>
                            <th>一次面談パスワード</th>
                            <td><c:out value="${schedule.first_interview_password}" /></td>
                        </tr>

                        <tr>
                            <th>二次面談予定日</th>
							 <td><fmt:formatDate value="${schedule.d_SecondInterviewScheduledDate}" pattern="yyyy-MM-dd" /></td>
                        </tr>
                        <tr>
                            <th>二次面談予定時間</th>
                            <td><c:out value="${secondDateTime}" /></td>
                         <%--    <td><fmt:formatDate value="${schedule.d_SecondInterviewScheduledTime}" pattern="HH:mm" /></td>

                        </tr>--%>
                        <tr>
                            <th>二次面談形式</th>
                            <td><%-- <c:out value="${schedule.v_SecondInterviewFormat}" />--%>
                            <c:choose>
							<c:when test="${schedule.v_SecondInterviewFormat == 1}">対面</c:when>
							<c:when test="${schedule.v_SecondInterviewFormat == 2}">オンライン</c:when>
							<c:when test="${schedule.v_SecondInterviewFormat == 3}">その他</c:when>
							<c:otherwise>（未入力）</c:otherwise>
						</c:choose></td>

                        </tr>
                        <tr>
                            <th>二次面談ツール</th>
                            <td><c:out value="${schedule.v_SecondInterviewTool}" /></td>

                        </tr>
                        <tr>
                            <th>二次面談URL</th>
                            <td><c:out value="${schedule.v_SecondInterviewUrl}" /></td>

                        </tr>
                        <tr>
                            <th>二次面談ID</th>
                             <td><c:out value="${schedule.v_SecondInterviewId}" /></td>

                        </tr>
                        <tr>
                            <th>二次面談パスワード</th>
                             <td><c:out value="${schedule.v_SecondInterviewPW}" /></td>

                        </tr>
                          <tr>
                            <th>見送り理由</th>
                             <td><c:out value="${schedule.v_InterviewResultNG}" /></td>

                        </tr>


                    <%-- 表示しない   <tr>
                            <th>登録日時</th>
                            <td>
                                <fmt:formatDate value="${schedule.created_at}" pattern="yyyy-MM-dd HH:mm:ss" />
                            </td>
                        </tr>
                        <tr>
                            <th>更新日時</th>
                            <td>
                                <fmt:formatDate value="${schedule.updated_at}" pattern="yyyy-MM-dd HH:mm:ss" />
                            </td>
                        </tr>--%>

                    </tbody>
                </table>

                <c:if test="${sessionScope.login_employee.id == schedule.employee.id}">
                    <p><a href="<c:url value='/schedules/edit?id=${schedule.id}' />">この面談予定を編集する</a></p>
                </c:if>
            </c:when>
            <c:otherwise>
                <h2>お探しのデータは見つかりませんでした。</h2>
            </c:otherwise>
        </c:choose>

        <p><a href="<c:url value='/schedules/index' />">一覧に戻る</a></p>
    </c:param>
</c:import>