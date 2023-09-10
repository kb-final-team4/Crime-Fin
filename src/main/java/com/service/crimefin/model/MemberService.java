package com.service.crimefin.model;

import com.service.crimefin.domain.MemberVO;

public interface MemberService {
    public MemberVO login(MemberVO memberVO);
  
    public void updateMemberInfo(String memberId, String email, String name, String phone, String address);
    public void updateMemberPassword(String memberId, String newPassword);
    public void insertMember(String memberId, String email, String password, String name, String phone, String address, int sex, int messageOk);
    public void deleteMember(String memberId, String passwordInput);
    public String selectMemberId(String name, String phone);

    public int isExistMemberId(String memberId);
    public int isExistMemberEmail(String email);
    public String selectAddress(String memberId);
}
