package com.service.crimefin;

import com.service.crimefin.domain.MemberVO;
import com.service.crimefin.model.CrimeFinDAO;
import com.service.crimefin.model.impl.CrimeFinDAOImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CrimefinApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void loginFeatureTests(){
		CrimeFinDAO dao = new CrimeFinDAOImpl();

		MemberVO temp1 =
				new MemberVO("test2",null,"test", null,null,null,0,null,0);
		MemberVO voNewPW =
				new MemberVO("test2",null,"test2", null,null,null,0,null,0);
		MemberVO vo = new MemberVO("test2", "test2@crime-fin.com", "test2", "테스트2", "010-1234-9876", "경기 수원시 팔달구", 0, "2023-01-02", 1);
		MemberVO vo2 = new MemberVO("test2", "test2@naver.com", "test2", "테스트3", "010-6666-9876", "경기 시흥시", 0, "2023-01-02", 1);

		System.out.println("---------- 1. login --------------");
		System.out.println(dao.login(temp1));

		/*
		System.out.println("---------- 1. login --------------");
		System.out.println(dao.login(new MemberVO("test", null, "test", null, null, null, 1, null, 1)));

		System.out.println("-------- 4. updateMemberInfo ---------");
		System.out.println(dao.updateMemberInfo(vo2)+"행 업데이트 됨.");

		System.out.println("-------- 4-2. updateMemberPassword ---------");
		int rst1 = dao.updateMemberPassword(voNewPW);
		if(rst1 == 0)
			System.out.println("비밀번호 수정 fail");
		else
			System.out.println("비밀번호 수정 success");

		System.out.println("-------- 5. insertMember ---------");
		MemberVO vo3 = new MemberVO("test7", "test7@naver.com", "test7", "테스트7", "010-9999-7777", "경기 용인시", 1, "2023-01-06", 1);
		int rst2 = dao.insertMember(vo3);
		if(rst2 == 0)
			System.out.println("회원가입 fail");
		else
			System.out.println("회원가입 success");

		System.out.println("-------- 6. deleteMember ---------");
		int rst3 = dao.insertMember(vo3);
		if(rst3 == 0)
			System.out.println("회원탈퇴 fail");
		else
			System.out.println("회원탈퇴 success");

		 */
	}
}
