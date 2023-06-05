<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <jsp:include page="../common/header.jsp"/>

    <h3> 🩷회원 정보(MEMBER_INFO) 테이블에서 회원 코드(MEMBER_CODE)를 이용하여 회원 정보 조회해오기</h3>
    <form action="employee/select">
        <label>조회할 회원 번호 : </label>
        <input type="text" name="memberCode" id="memberCode">
        <button type="submit">✔️조회하기</button>
    </form>

    <h3> ❤️회원 정보(MEMBER_INFO) 테이블에서 회원 전체 정보 조회 : /employee/list (get)</h3>
    <button onclick="location.href='${pageContext.servletContext.contextPath}/employee/list'">회원 정보 전체 조회하기</button>

    <h3> 🧡회원 정보(MEMBER_INFO) 테이블에 신규 회원 정보 추가 : /employee/insert (post)</h3>
    <form action="${ pageContext.servletContext.contextPath }/employee/insert" method="post">
        회원 이름 : <input type="text" name="empName"><br>
        생년월일 : <input type="date" name="birthday"><br>
        구매여부 구분코드 :
        <select name="ispurchased">
            <option value="N">구매 경험 없음</option>
            <option value="Y">구매 경험 있음</option>
        </select>
        연락처 : <input type="tel" name="phone"><br>
        소속 :
        <select name="deptCode">
            <option value="1">레드 다이아몬드</option>
            <option value="2">다이아몬드</option>
            <option value="3">골드</option>
            <option value="4">실버</option>
            <option value="5">브론즈</option>
            <option value="6">블랙</option>
        </select>
        <br>
        활동상태 :
        <select name="jobCode">
            <option value="N">탈퇴 회원</option>
            <option value="H">휴면 회원</option>
            <option value="Y">정상 회원</option>
        </select>
        <br>
        <button type="submit">등록하기</button>
    </form>

    <h3> 💛회원 정보(MEMBER_INFO) 테이블에서 회원 정보 수정 (사번과 변경할 정보를 입력 받아 사번과 일치하는 사원의 정보 변경 - 원하는 데이터 변경) : /employee/update (post)</h3>
    <form action="${ pageContext.servletContext.contextPath }/employee/update" method="post">
        사번 : <input type="text" name="empId"><br>
        탈퇴일 : <input type="date" name="entDate"><br>
        <button type="submit">회원 탈퇴</button>
    </form>

    <h3> 🩵회원 정보(MEMBER_INFO) 테이블에서 회원 정보 삭제 (사번 입력 받아 사번과 일치하는 행 삭제) : /employee/delete (post)</h3>
    <form action="${ pageContext.servletContext.contextPath }/employee/delete" method="post">
        사번 : <input type="text" name="empId"><br>
        <button type="submit">회원 정보 삭제</button>
    </form>
</body>
</html>
