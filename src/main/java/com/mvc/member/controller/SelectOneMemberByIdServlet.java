package com.mvc.member.controller;

import com.mvc.member.model.dto.MemberDTO;
import com.mvc.member.model.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/member/select")
public class SelectOneMemberByIdServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /* 전달한 파라미터 꺼내기 */
        int memberCode = Integer.parseInt(request.getParameter("memberCode"));

        System.out.println("memberCode : " + memberCode);

        /* 멤버코드을 이용해 회원 정보를 조회하는 비지니스 로직 호출 */
        MemberService empService = new MemberService();
        MemberDTO selectedMember = empService.selectMemberByCode(memberCode);

        System.out.println("selectedMember : " + selectedMember);

        /* 비지니스 로직 실행 결과에 따라 뷰 연결 */
        String path = "";
        if(selectedMember != null) {
            path = "/views/member/showMemberInfo.jsp";
            request.setAttribute("selectedMember", selectedMember);
        } else {
            path = "/views/common/errorPage.jsp";
            request.setAttribute("message", "회원 정보 조회 실패!");
        }

        request.getRequestDispatcher(path).forward(request, response);

    }

}
