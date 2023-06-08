package com.mvc.member.model.service;

import com.mvc.member.model.dao.MemberDAO;
import com.mvc.member.model.dto.MemberDTO;
import org.apache.ibatis.session.SqlSession;

import java.io.PrintWriter;
import java.util.List;

import static com.mvc.common.Template.getSqlSession;


public class MemberService {

    private MemberDAO memberDAO;


    public MemberService() {
        memberDAO = getSqlSession().getMapper(MemberDAO.class);
    }

    SqlSession sqlSession = getSqlSession();

    /* 1. 멤버 1명을 멤버코드로 조회하는 기능을 담은 메소드 */
    public MemberDTO selectMemberByCode(int memberCode) {

        memberDAO = sqlSession.getMapper(MemberDAO.class);
        MemberDTO selectedMember = memberDAO.selectMemberByCode(memberCode);
        sqlSession.close();

        return selectedMember;
    }

    /* 2. 멤버 전체를 조회하는 기능을 담은 메소드 */
    public List<MemberDTO> selectAllMembers() {

        memberDAO = sqlSession.getMapper(MemberDAO.class);
        List<MemberDTO> memberList = memberDAO.selectAllMembers();
        sqlSession.close();

        return memberList;
    }



    /* 3. 새로운 멤버 1명을 등록하는 기능을 담은 메소드 */
    public boolean insertMember(MemberDTO member) {

        memberDAO = sqlSession.getMapper(MemberDAO.class);
        boolean result = memberDAO.insertMember(member);

        if(result) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();

        return result;
    }

    /* 4. 멤버 1명을 수정하는 기능을 담은 메소드 */
    public boolean updateMember(MemberDTO member) {

        memberDAO = sqlSession.getMapper(MemberDAO.class);
        boolean result = memberDAO.updateMember(member);

        if(result) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();

        return result;
    }
    /* 5. 멤버 1명을 멤버코드로 삭제하는 기능을 담은 메소드 */
    public boolean deleteMember(int memberCode) {

        memberDAO = sqlSession.getMapper(MemberDAO.class);
        boolean result = memberDAO.deleteMember(memberCode);

        if(result) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();

        return result;
    }

}



