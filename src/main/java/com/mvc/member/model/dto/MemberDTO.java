package com.mvc.member.model.dto;

import java.sql.Date;

public class MemberDTO implements java.io.Serializable {

    private int memberCode; //회원 코드
    private String memberName; //회원 이름
    private String memberBirth; //생년월일
    private String divisionCode; //구매여부 구분코드
    private String detailInfo; //상세 정보
    private String phone; //연락처
    private int gradeCode; //소속(레벨) 코드
    private String activeStatus; //활동 상태

    public MemberDTO() {
    }

    public MemberDTO(String memberCode, String memberName, String memberBirth, String divisionCode, String phone, String detailInfo, String gradeCode, String activeStatus, int salary, double bonus, String managerId, Date hireDate, Date entDate, String entYn) {
        super();
        this.memberCode = Integer.parseInt(memberCode);
        this.memberName = memberName;
        this.memberBirth = memberBirth;
        this.divisionCode = divisionCode;
        this.phone = phone;
        this.detailInfo = detailInfo;
        this.gradeCode = Integer.parseInt(gradeCode);
        this.activeStatus = activeStatus;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "memberCode=" + memberCode +
                ", memberName='" + memberName + '\'' +
                ", memberBirth='" + memberBirth + '\'' +
                ", isPurchased='" + divisionCode + '\'' +
                ", detailInfo='" + detailInfo + '\'' +
                ", phone='" + phone + '\'' +
                ", gradeCode=" + gradeCode +
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getGradeCode() {
        return gradeCode;
    }

    public void setGradeCode(int gradeCode) {
        this.gradeCode = gradeCode;
    }

    public String getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(String activeStatus) {
        this.activeStatus = activeStatus;
    }
}
