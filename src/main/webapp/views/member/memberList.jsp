<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>회원 목록 전체 조회</h1>
    <table>
        <tr>
            <th>회원번호</th>
            <th>회원이름</th>
            <th>생년월일</th>
            <th>구매여부</th>
            <th>연락처</th>
            <th>상세정보</th>
            <th>등급코드</th>
            <th>활동상태</th>
        </tr>
        <c:forEach items="${ requestScope.memberList }" var="member">
            <tr>
                <td>${ member.memberCode }</td>
                <td>${ member.memberName }</td>
                <td>${ member.birthDate }</td>
                <td>${ member.divisionCode }</td>
                <td>${ member.phoneNum }</td>
                <td>${ member.detailInfo }</td>
                <td>${ member.gradeCode }</td>
                <td>${ member.activeStatus }</td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>
