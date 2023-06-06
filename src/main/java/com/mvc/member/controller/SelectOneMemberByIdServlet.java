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
        String empId = request.getParameter("empId");

        System.out.println("empId : " + empId);

        /* 사번을 이용해 사원 정보를 조회하는 비지니스 로직 호출 */
        MemberService empService = new MemberService();
        MemberDTO selectedEmp = empService.selectOneEmpById(empId);

        System.out.println("selectedEmp : " + selectedEmp);

        /* 비지니스 로직 실행 결과에 따라 뷰 연결 */
        String path = "";
        if(selectedEmp != null) {
            path = "/WEB-INF/views/member/showEmpInfo.jsp";
            request.setAttribute("selectedEmp", selectedEmp);
        } else {
            path = "/WEB-INF/views/common/errorPage.jsp";
            request.setAttribute("message", "직원 정보 조회 실패!");
        }

        request.getRequestDispatcher(path).forward(request, response);

    }

}
