package com.service.crimefin.model;

import com.service.crimefin.domain.MemberVO;

import java.util.List;

public interface MemberDAO {
	public MemberVO login(MemberVO memberVO);

	public int updateMemberInfo(MemberVO memberVO);
    public int insertMember(MemberVO memberVO);
    public int deleteMember(MemberVO memberVO);
    public String selectMemberId(MemberVO memberVO);


    public int isExistMemberId(String memberId);
    public int isExistMemberEmail(String email);
    public String selectAddress(String memberId);
}
