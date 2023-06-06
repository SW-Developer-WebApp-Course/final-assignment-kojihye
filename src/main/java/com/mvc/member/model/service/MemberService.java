package com.mvc.member.model.service;

import com.mvc.member.model.dao.MemberDAO;
import com.mvc.member.model.dto.MemberDTO;

import java.sql.Connection;
import java.util.List;

import static com.mvc.common.jdbc.JDBCTemplate.*;

public class MemberService {

    private final MemberDAO memberDAO;

    public MemberService() {
        memberDAO = new MemberDAO();
    }

    public MemberDTO selectOneEmpById(String empId) {

        /* Connection 생성 */
        Connection con = getConnection();

        /* Connection과 함께 정보를 전달하여 조회한다. */
        MemberDTO selectedEmp = memberDAO.selectMemberByCode(con, empId);

        /* connection 닫기 */
        close(con);

        /* 조회 결과를 반환한다. */
        return selectedEmp;
    }

    /* 직원 정보 전체 조회용 메소드 */
    public List<MemberDTO> selectAllMember() {

        /* Connection 생성 */
        Connection con = getConnection();

        /* 비지니스 로직 */
        /* 1. dao 호출하여 조회 */
        List<MemberDTO> empList = memberDAO.selectAllMemberList(con);

        /* Connection 닫기 */
        close(con);

        /* 수행 결과 반환 */
        return empList;
    }

    public String selectNewMemberCode() {

        /* Connection 생성 */
        Connection con = getConnection();

        /* 비지니스 로직 */
        /* 1. dao 호출하여 조회 */
        String newEmpId = memberDAO.selectNewMemberCode(con);

        /* Connection 닫기 */
        close(con);

        /* 수행 결과 반환 */
        return newEmpId;
    }

    /* 신규 사원 등록용 메소드 */
    public int insertMember(MemberDTO emp) {

        Connection con = getConnection();

        int result = memberDAO.insertMember(con, emp);

        if (result > 0) {
            commit(con);
        } else {
            rollback(con);
        }

        close(con);

        return result;
    }

    public int updateMember(MemberDTO emp) {

        Connection con = getConnection();

        int result = memberDAO.updateMember(con, emp);

        if (result > 0) {
            commit(con);
        } else {
            rollback(con);
        }

        close(con);

        return result;
    }

    public int deleteMember(String empId) {

        Connection con = getConnection();

        int result = memberDAO.deleteMember(con, empId);

        if (result > 0) {
            commit(con);
        } else {
            rollback(con);
        }

        close(con);

        return result;
    }

}



