package com.service.crimefin.model.impl;

import com.service.crimefin.domain.MemberVO;
import com.service.crimefin.model.CrimeFinDAO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CrimeFinDAOImpl implements CrimeFinDAO {

    @Autowired
    private SqlSession sqlSession;
    private static final String NS = "sql.crime-fin.mapper.";

    @Override
    public MemberVO login(MemberVO memberVO) {
        return (MemberVO) sqlSession.selectOne(NS+"selectMember", memberVO);
    }

    /*@Override
    public void logout() {
        //dao에서 하나?
    }*/

    @Override
    public int updateMemberInfo(MemberVO memberVO) {
        int result = sqlSession.update(NS+"updateMember", memberVO);
        sqlSession.commit();
        return result;
    }

    @Override
    public int updateMemberPassword(MemberVO memberVO) {
        int result = sqlSession.update(NS+"updateMemberPassword", memberVO);
        sqlSession.commit();
        return result;
    }


    @Override
    public int insertMember(MemberVO memberVO) {
        int result = sqlSession.insert(NS+"insertMember", memberVO);
        sqlSession.commit();
        return result;
    }

    @Override
    public int deleteMember(MemberVO memberVO) {
        int result = sqlSession.delete(NS+"deleteMember", memberVO);
        sqlSession.commit();
        return result;
    }
}
