package com.mvc.member.controller;

import com.mvc.member.model.dto.MemberDTO;
import com.mvc.member.model.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/member/insert")
public class InsertMemberServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        //memberCode는 Auto Incresement니까 insert할 때 사용하지 않음
        String memberName = request.getParameter("memberName"); //회원 이름
        String memberBirth = request.getParameter("memberBirth"); //생년월일
        String divisionCode = request.getParameter("divisionCode"); //구매여부 구분코드
        String detailInfo = request.getParameter("detailInfo"); //상세정보
        String contact = request.getParameter("contact"); //연락처
        int gradeCode = Integer.parseInt(request.getParameter("gradeCode")); //소속코드
        String activeStatus	= request.getParameter("activeStatus"); //활동 상태

        MemberService memberService = new MemberService();

        MemberDTO member = new MemberDTO();

        member.setMemberName(memberName);
        member.setMemberBirth(memberBirth);
        member.setDivisionCode(divisionCode);
        member.setDetailInfo(detailInfo);
        member.setContact(contact);
        member.setTeamCode(gradeCode);
        member.setActiveStatus(activeStatus);

        System.out.println("insert request member : " + member);

        boolean result = memberService.insertMember(member);

        String path = "";
        if(result) {
            path = "/views/common/successPage.jsp";
            request.setAttribute("successCode", "insertMember");
        } else {
            path = "/views/common/errorPage.jsp";
            request.setAttribute("message", "회원 등록 실패!");
        }

        request.getRequestDispatcher(path).forward(request, response);
    }

}