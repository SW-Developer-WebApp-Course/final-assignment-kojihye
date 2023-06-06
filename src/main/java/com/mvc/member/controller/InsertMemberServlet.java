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
        String memberBirthDate = request.getParameter("memberBirthDate"); //생년월일
        String divisionCode = request.getParameter("divisionCode"); //구매여부 구분코드
        String detailInfo = request.getParameter("detailInfo"); //상세정보
        String phone = request.getParameter("phone"); //연락처
        //TO-DO : String -> Int 형태로 바꾸기
        int belongCode = Integer.parseInt(request.getParameter("belongCode")); //소속코드
        String activeStatus	= request.getParameter("activeStatus"); //활동 상태

        MemberService memberService = new MemberService();
        String newEmpId = memberService.selectNewMemberCode();

        MemberDTO member = new MemberDTO();
        if(newEmpId != null){
            member.setMemberName(memberName);
            member.setMemberBirth(memberBirthDate);
            member.setDivisionCode(divisionCode);
            member.setDetailInfo(detailInfo);
            member.setPhone(phone);
            member.setGradeCode(belongCode);
            member.setActiveStatus(activeStatus);
        }
        System.out.println("insert request member : " + member);

        int result = memberService.insertMember(member);

        String path = "";
        if(result > 0) {
            path = "/views/common/successPage.jsp";
//			request.setAttribute("message", "신규 직원 등록에 성공하셨습니다.");
//			response.sendRedirect(request.getContextPath() + "/WEB-INF/views/common/successPage.jsp");

            request.setAttribute("successCode", "insertMember");
        } else {
            path = "/views/common/errorPage.jsp";
            request.setAttribute("message", "신규 직원 등록에 실패하셨습니다.");
        }

        request.getRequestDispatcher(path).forward(request, response);
    }

}