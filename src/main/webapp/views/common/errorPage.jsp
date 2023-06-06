<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <h1>${ requestScope.message }</h1>

  <script>
      (function() {
          const errorCode = '${ requestScope.errorCode }';

          let errorMessage = '';
          let movePath = '';

          switch(errorCode) {
              case 'insertMember' :
                  errorMessage = '신규 회원 등록 실패! 😰';
                  movePath = '${pageContext.servletContext.contextPath}/member/list';
                  break;
              case 'updateMember' :
                  errorMessage = '회원 정보 수정 실패! 😰';
                  movePath = '${pageContext.servletContext.contextPath}/member/list';
                  break;
              case 'deleteMember' :
                  errorMessage = '회원 정보 삭제 실패! 😰';
                  movePath = '${pageContext.servletContext.contextPath}/member/list';
                  break;
          }

          alert(errorMessage);
          location.href = movePath;

      })();
  </script>
</body>
</html>
