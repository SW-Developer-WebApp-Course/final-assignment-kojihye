package com.mvc.member.model.dao;

import com.mvc.member.model.dto.MemberDTO;
import java.util.List;

public interface MemberDAO {
    MemberDTO selectMemberByCode(int memberId);
    List<MemberDTO> selectAllMembers();
    boolean insertMember(MemberDTO member);
    boolean updateMember(MemberDTO member);
    boolean deleteMember(int memberCode);
}
