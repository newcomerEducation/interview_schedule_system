<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <c:choose>
            <c:when test="${schedule != null}">
                <h2>面談予定 詳細ページ</h2>

                <table>
                    <tbody>
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

                        <!-- <tr>
                            <th>上位会社（発注元企業（直接発注元））</th>
                            <td><c:out value="${schedule.ordering_company}" /></td>
                        </tr> -->
                        <tr>
                            <th>担当営業</th>
                            <td><c:out value="${schedule.sales_employee.employee_name}" /></td>
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
                            <th>優先順位</th>
                            <td><c:out value="${schedule.priority}" /></td>
                        </tr>
                        <tr>
                            <th>志望状況</th>

                        </tr>
                        <tr>
                            <th>面談状況</th>
                            <td>

                            </td>
                        </tr>
                        <tr>
                            <th>合否状況</th>
                            <td>

                            </td>
                        </tr>
                        <tr>
                            <th>一次面談予定日</th>
                            <td><fmt:formatDate value="${schedule.first_interview_scheduled_date}" pattern="yyyy-MM-dd" /></td>
                        </tr>
                        <tr>
                            <th>一次面談予定時間</th>
                            <td><fmt:formatDate value="${schedule.first_interview_scheduled_time}" pattern="HH:mm" /></td>
                        </tr>
                        <tr>
                            <th>一次面談形式</th>

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
                      <!--   <tr>
                            <th>一次面談実施日</th>

                        </tr>
                        <tr>
                            <th>一次面談実施時間</th>

                        </tr>
                        <tr>
                            <th>二次面談予定日</th>

                        </tr>
                        <tr>
                            <th>二次面談予定時間</th>

                        </tr>
                        <tr>
                            <th>二次面談形式</th>
                            <td>

                            </td>
                        </tr>
                        <tr>
                            <th>二次面談ツール</th>

                        </tr>
                        <tr>
                            <th>二次面談URL</th>

                        </tr>
                        <tr>
                            <th>二次面談ID</th>

                        </tr>
                        <tr>
                            <th>二次面談パスワード</th>

                        </tr>
                        <tr>
                            <th>二次面談実施日</th>

                        </tr>
                        <tr>
                            <th>二次面談実施時間</th>

                        </tr>
                        <tr>
                            <th>補足</th>

                        </tr>-->
                        <tr>
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
                        </tr>

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