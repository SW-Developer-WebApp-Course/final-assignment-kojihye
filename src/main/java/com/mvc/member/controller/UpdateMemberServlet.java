package com.mvc.member.controller;

import com.mvc.member.model.dto.MemberDTO;
import com.mvc.member.model.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/member/update")
public class UpdateMemberServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        int memberCode = Integer.parseInt(request.getParameter("memberCode"));
        String memberName = request.getParameter("memberName");
        String birthDate = request.getParameter("birthDate");
        String divisionCode = request.getParameter("divisionCode");
        String detailInfo = request.getParameter("detailInfo");
        String contact = request.getParameter("contact");
        int teamCode = Integer.parseInt(request.getParameter("teamCode"));
        String activeStatus = request.getParameter("activeStatus");

        MemberService memberService = new MemberService();

        MemberDTO member = new MemberDTO();

        member.setMemberCode(memberCode);
        member.setMemberName(memberName);
        member.setMemberBirth(birthDate);
        member.setDivisionCode(divisionCode);
        member.setDetailInfo(detailInfo);
        member.setContact(contact);
        member.setTeamCode(teamCode);
        member.setActiveStatus(activeStatus);

        System.out.println("update request member = " + member);

        boolean result = memberService.updateMember(member);

        String path = "";
        if(result) {
            path = "/views/common/successPage.jsp";
            request.setAttribute("successCode", "updateMember");
        } else {
            path = "/views/common/errorPage.jsp";
            request.setAttribute("message", "회원 정보 수정 실패!");
        }

        request.getRequestDispatcher(path).forward(request, response);
    }

}
