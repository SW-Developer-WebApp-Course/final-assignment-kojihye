<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <jsp:include page="../common/header.jsp"/>

    회원번호 : ${ requestScope.selectedMember.memberCode }<br>
    회원명 : ${ requestScope.selectedMember.memberName }<br>
    회원생년월일 : ${ requestScope.selectedMember.memberBirth }<br>
    구분코드 : ${ requestScope.selectedMember.divisionCode }<br>
    상세정보 : ${ requestScope.selectedMember.detailInfo }<br>
    연락처 : ${ requestScope.selectedMember.contact }<br>
    등급코드 : ${ requestScope.selectedMember.teamCode }<br>
    활동상태 : ${ requestScope.selectedMember.activeStatus }<br>
</body>
</html>
