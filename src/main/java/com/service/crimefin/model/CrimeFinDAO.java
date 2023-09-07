package com.service.crimefin.model;

import com.service.crimefin.domain.MemberVO;

import java.util.List;

public interface CrimeFinDAO {
    //1. 사용자가 아이디와 비밀번호를 입력해서 로그인하면 세션에 UserVO를 바인딩한다.
    public MemberVO login(MemberVO memberVO);

    //2. 사용자가 자신의 카카오, 구글, 네이버 로그인 정보를 이용해서 로그인 하면 세션에 로그인 정보로 생성된 UserVO를 바인딩한다.
    //보류

    //3. 사용자가 로그아웃 버튼을 누르면 현재 세션 invaild하게 만든다.
    //public void logout();

    //4. 사용자가 로그인한 뒤 회원 상세 정보를 수정할 수 있다.
    public int updateMemberInfo(MemberVO memberVO);
    //이거 리스트 아니고 걍 스트링 3개임
    /*
        newpw하고 newpwconfirm 같을때만 동작하는거라 confirm 안받아와도됨
        폼에서 curpw 받아서
        세션에 바인딩된 memberVO에서 id 뽑아서 pw 받아와서 curpw랑 비교함
        같으면 (int result 가 0이 아니면)
        newpw insert
     */

    //public int updateMemberPassword(HttpSession session, String curPassword, String newPassword);
    /*
    MemberVO memberVO =
        new MemberVO(curMemberId,null,newPassword, null,null,null,0,null,0);
     */
    public int updateMemberPassword(MemberVO memberVO);


    //5. 사용자는 이름, 주소, 성별, 생년월일, 이메일(아이디), 희망 비밀번호를 입력하면 전화번호 인증을 통해 회원가입을 할 수 있다.
    public int insertMember(MemberVO memberVO);

    //6. 사용자는 회원 탈퇴를 요청하여 데이터베이스에서 해당 id값으로 자신의 레코드를 삭제할 수 있다.
    //service 에서 세션에 바인딩된 memberVO 객체 가져와서 getMemberId()하고 getPassword()해서 new MemberVO()해서
    //객체 생성해서 넘겨주기
    //public int deleteMember(String memberId, String passwordInput);
    public int deleteMember(MemberVO memberVO);
}
