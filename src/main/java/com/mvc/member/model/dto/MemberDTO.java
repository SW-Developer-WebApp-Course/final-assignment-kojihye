package com.mvc.member.model.dto;

import java.sql.Date;

public class MemberDTO implements java.io.Serializable {

    private int memberCode; //회원 코드
    private String memberName; //회원 이름
    private String memberBirth; //생년월일
    private String divisionCode; //구매여부 구분코드
    private String detailInfo; //상세 정보
    private String contact; //연락처
    private int teamCode; //소속(레벨) 코드
    private String activeStatus; //활동 상태

    public MemberDTO() {
    }

    public MemberDTO(String memberCode, String memberName, String memberBirth, String divisionCode, String contact, String detailInfo, String teamCode, String activeStatus, int salary, double bonus, String managerId, Date hireDate, Date entDate, String entYn) {
        super();
        this.memberCode = Integer.parseInt(memberCode);
        this.memberName = memberName;
        this.memberBirth = memberBirth;
        this.divisionCode = divisionCode;
        this.contact = contact;
        this.detailInfo = detailInfo;
        this.teamCode = Integer.parseInt(teamCode);
        this.activeStatus = activeStatus;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "memberCode=" + memberCode +
                ", memberName='" + memberName + '\'' +
                ", memberBirth='" + memberBirth + '\'' +
                ", divisionCode='" + divisionCode + '\'' +
                ", detailInfo='" + detailInfo + '\'' +
                ", phone='" + contact + '\'' +
                ", gradeCode=" + teamCode +
                ", activeStatus='" + activeStatus + '\'' +
                '}';
    }

    public int getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(int memberCode) {
        this.memberCode = memberCode;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberBirth() {
        return memberBirth;
    }

    public void setMemberBirth(String memberBirth) {
        this.memberBirth = memberBirth;
    }

    public String getDivisionCode() {
        return divisionCode;
    }

    public void setDivisionCode(String divisionCode) {
        this.divisionCode = divisionCode;
    }

    public String getDetailInfo() {
        return detailInfo;
    }

    public void setDetailInfo(String detailInfo) {
        this.detailInfo = detailInfo;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public int getTeamCode() {
        return teamCode;
    }

    public void setTeamCode(int teamCode) {
        this.teamCode = teamCode;
    }

    public String getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(String activeStatus) {
        this.activeStatus = activeStatus;
    }
}
