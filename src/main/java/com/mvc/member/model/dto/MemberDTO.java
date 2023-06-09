package com.mvc.member.model.dto;

public class MemberDTO implements java.io.Serializable {

    private int memberCode; //회원 코드
    private String memberName; //회원 이름
    private String birthDate; //생년월일
    private String divisionCode; //구매여부 구분코드
    private String detailInfo; //상세 정보
    private String phoneNum; //연락처
    private int gradeCode; //소속(레벨) 코드
    private String activeStatus; //활동 상태

    public MemberDTO() {
    }

    public MemberDTO(String memberCode, String memberName, String birthDate, String divisionCode, String phoneNum, String detailInfo, int gradeCode, String activeStatus) {
        super();
        this.memberCode = Integer.parseInt(memberCode);
        this.memberName = memberName;
        this.birthDate = birthDate;
        this.divisionCode = divisionCode;
        this.phoneNum = phoneNum;
        this.detailInfo = detailInfo;
        this.gradeCode = gradeCode;
        this.activeStatus = activeStatus;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "memberCode=" + memberCode +
                ", memberName='" + memberName + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", divisionCode='" + divisionCode + '\'' +
                ", detailInfo='" + detailInfo + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
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

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
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
