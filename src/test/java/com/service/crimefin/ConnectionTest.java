package com.service.crimefin;

import com.service.crimefin.domain.MemberVO;
import com.service.crimefin.model.MemberDAO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.io.Reader;
import java.util.List;

@SpringBootTest
@Transactional
@Commit
public class ConnectionTest {

    @Autowired
    private MemberDAO memberDAO;

    @Test
    public void unitTest() throws Exception{

        System.out.println("=========== insert ===========");
        MemberVO memberVO = new MemberVO(
                "test0908", "test0908@gmail.com", "1234", "maeng",
                "01011112222","노원구",1,"0",1);
        //memberDAO.insertMember(memberVO);


        System.out.println("=========== select ===========");
        List<MemberVO> selected = memberDAO.select();
        for (MemberVO mVO : selected) {
            System.out.println(mVO.getEmail()+"!!!");
        }

//        System.out.println("=========== delete ===========");
//        MemberVO memberVO = new MemberVO();
//        memberVO.setMemberId("test0908");
//        memberVO.setPassword("1234");
//        memberDAO.deleteMember(memberVO);

        System.out.println("=========== update info ===========");
        memberVO.setAddress("강남구");
        memberVO.setEmail("test0908@naver.com");
        memberDAO.updateMemberInfo(memberVO);

        System.out.println("=========== update password ===========");
        memberVO.setPassword("5678");
        memberDAO.updateMemberPassword(memberVO);

        System.out.println("=========== login ===========");
        MemberVO testVO = new MemberVO();
        testVO.setMemberId("test0908");
        testVO.setPassword("5678");
        MemberVO resultVO = memberDAO.login(testVO);
        if(resultVO!=null){
            System.out.println("로그인 성공!!");
        } else {
            System.out.println("로그인 실패!!");
        }

    }

}
