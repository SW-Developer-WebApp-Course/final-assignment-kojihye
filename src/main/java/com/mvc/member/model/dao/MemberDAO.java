package com.mvc.member.model.dao;

import com.mvc.common.config.ConfigLocation;
import com.mvc.member.model.dto.MemberDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static com.mvc.common.jdbc.JDBCTemplate.close;

public class MemberDAO {

    private final Properties prop;

    public MemberDAO() {

        prop = new Properties();
        try {
            prop.loadFromXML(new FileInputStream(ConfigLocation.MAPPER_LOCATION + "mapper/member-mapper.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public MemberDTO selectMemberByCode(Connection con, String memberCode) {

        PreparedStatement pstmt = null;
        ResultSet rset = null;

        MemberDTO selectedMember = null;

        String query = prop.getProperty("selectMemberByCode");

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, memberCode);

            rset = pstmt.executeQuery();

            if (rset.next()) {
                selectedMember= new MemberDTO();

                selectedMember.setMemberCode(rset.getInt("MEMBER_CODE")); //멤버 코드
                selectedMember.setMemberName(rset.getString("MEMBER_NAME")); //멤버 이름
                selectedMember.setMemberBirth(rset.getString("BIRTH_DATE")); //멤버 생일
                selectedMember.setDivisionCode(rset.getString("DIVISION_CODE")); //구매 여부 구분 코드
                selectedMember.setDetailInfo(rset.getString("DETAIL_INFO"));

                selectedMember.setGradeCode(rset.getInt("TEAM_CODE"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
        }

        return selectedMember;
    }

    /* employee 테이블의 전체 목록 조회 */
    public List<MemberDTO> selectAllMemberList(Connection con) {

        Statement stmt = null;
        ResultSet rset = null;

        List<MemberDTO> memberList = null;

        String query = prop.getProperty("selectAllMemberList");

        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(query);

            memberList = new ArrayList<>();

            while (rset.next()) {
                MemberDTO member = new MemberDTO();
                member.setMemberCode(rset.getInt("MEMBER_CODE"));
                member.setMemberName(rset.getString("MEMBER_NAME"));
                member.setMemberBirth(rset.getString("BIRTH_DATE"));
                member.setDivisionCode(rset.getString("DIVISION_CODE"));
                member.setDetailInfo(rset.getString("DETAIL_INFO"));
                member.setPhone(rset.getString("CONTACT"));
                member.setGradeCode(rset.getInt("TEAM_CODE"));
                member.setActiveStatus(rset.getString("ACTICE_STATUS"));

                memberList.add(member);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(stmt);
        }

        return memberList;
    }

    public String selectNewMemberCode(Connection con) {
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        String newMemberCode = null;

        String query = prop.getProperty("selectNewMemberCode");

        try {
            pstmt = con.prepareStatement(query);

            rset = pstmt.executeQuery();

            if (rset.next()) {
                newMemberCode = String.valueOf(rset.getInt("MEMBER_CODE"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rset);
            close(pstmt);
        }

        return newMemberCode;
    }

    /* employee 테이블에 insert 하는 메소드 */
    public int insertMember(Connection con, MemberDTO member) {

        PreparedStatement pstmt = null;

        int result = 0;

        String query = prop.getProperty("insertMember");

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(1, member.getMemberCode());
            pstmt.setString(2, member.getMemberName());
            pstmt.setString(3, member.getMemberBirth());
            pstmt.setString(4, member.getDivisionCode());
            pstmt.setString(5, member.getPhone());
            pstmt.setString(6, member.getDetailInfo());
            pstmt.setInt(7, member.getGradeCode());
            pstmt.setString(8, member.getActiveStatus());

            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }

        return result;
    }


    public int updateMember(Connection con, MemberDTO member) {

        PreparedStatement pstmt = null;

        int result = 0;

        String query = prop.getProperty("updateMember");

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setInt(2, member.getMemberCode());

            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }

        return result;
    }


    public int deleteMember(Connection con, String memberCode) {

        PreparedStatement pstmt = null;

        int result = 0;

        String query = prop.getProperty("deleteMember");

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, memberCode);

            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(pstmt);
        }

        return result;
    }

}