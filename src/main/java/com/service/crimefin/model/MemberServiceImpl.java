package com.service.crimefin.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.crimefin.domain.MemberVO;
import com.service.crimefin.model.MemberDAO;
import com.service.crimefin.model.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO memberDAO;
	
	@Override
	public MemberVO login(MemberVO memberVO) {
		return memberDAO.login(memberVO);
	}

	@Override
	public void updateMemberInfo(String memberId, String email, String name, String phone, String address) {
		MemberVO memberVO = new MemberVO();
		memberVO.setMemberId(memberId);
		memberVO.setEmail(email);
		memberVO.setName(name);
		memberVO.setPhone(phone);
		memberVO.setAddress(address);
		memberDAO.updateMemberInfo(memberVO);
	}

	@Override
	public void updateMemberPassword(String memberId, String newPassword) {
		MemberVO memberVO = new MemberVO();
		memberVO.setMemberId(memberId);
		memberVO.setPassword(newPassword);
		memberDAO.updateMemberInfo(memberVO);
	}
	
	@Override
	public void insertMember(String memberId, String email, String password, String name, String phone, String address, int sex, int messageOk) {
		MemberVO memberVO = new MemberVO();
		memberVO.setMemberId(memberId);
		memberVO.setPassword(password);
		memberVO.setEmail(email);
		memberVO.setName(name);
		memberVO.setPhone(phone);
		memberVO.setAddress(address);
		memberVO.setSex(sex);
		memberVO.setMessageOk(messageOk);
		memberDAO.insertMember(memberVO);
	}

	@Override
	public void deleteMember(String memberId, String passwordInput) {
		MemberVO memberVO = new MemberVO();
		memberVO.setMemberId(memberId);
		memberVO.setPassword(passwordInput);
		memberDAO.deleteMember(memberVO);
	}

	@Override
	public String selectMemberId(String name, String phone) {
		MemberVO memberVO = new MemberVO();
		memberVO.setName(name);
		memberVO.setPhone(phone);
		return memberDAO.selectMemberId(memberVO);
	}

	@Override
	public int isExistMemberId(String memberId) {
		return memberDAO.isExistMemberId(memberId);
	}

	@Override
	public int isExistMemberEmail(String email) {
		return memberDAO.isExistMemberEmail(email);
	}

	@Override
	public String selectAddress(String memberId) {
		return memberDAO.selectAddress(memberId);
	}
}
