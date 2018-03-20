package com.qainfeng.mybatis;

import com.qianfeng.mybatis.dto.DepartmentDTO;
import com.qianfeng.mybatis.dto.User2DTO;
import com.qianfeng.mybatis.dto.UserDTO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Mao on 2018/3/19.
 */
public class MybatisTest {
    private static SqlSessionFactory sqlSessionFactory;
    @BeforeClass
    public static void init(){
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream("mybatis.cfg.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


    }

    /**
     * 查询所有
     */
    @Test
    public void testCase1(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
            List<UserDTO> list = sqlSession.selectList("com.qianfeng.mybatis.dto.UserMapper.selectUser");
            for (UserDTO us :
                    list) {
                System.out.println(us.getUser_name());
            }
        sqlSession.close();
    }

    /**
     * 根据id查询一条user信息
     */
    @Test
    public void testCase2(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDTO one = sqlSession.selectOne("com.qianfeng.mybatis.dto.UserMapper.selectUserById",1);
        System.out.println(one.getUser_name());
        sqlSession.close();
    }

    /**
     * 通过username和password来查询一个user对象，用户名和密码保存在hashMap中
     */
    @Test
    public void testCase3(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("name","zhangsan");
        hashMap.put("password","123456");
        UserDTO o = sqlSession.selectOne("com.qianfeng.mybatis.dto.UserMapper.checkUser", hashMap);
        System.out.println(o.getUser_name()+o.getUser_sex());
        sqlSession.close();
    }

    /**
     * 通过用户名和密码来查询，将用户名和密码封装在一个实体内
     */
    @Test
    public void testCase4(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDTO userDTO = new UserDTO();
        userDTO.setUser_name("lisi");
        userDTO.setUser_password("111111");
        UserDTO o = sqlSession.selectOne("com.qianfeng.mybatis.dto.UserMapper.login", userDTO);
        System.out.println(o.getUser_name()+o.getUser_sex());
        sqlSession.close();
    }

    /**
     * 插入一条数据
     */
    @Test
    public void testCase5(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDTO userDTO = new UserDTO();
        userDTO.setUser_name("wangwu");
        userDTO.setUser_password("123456");
        userDTO.setUser_email("212121");
        userDTO.setUser_sex('0');
        int i = sqlSession.insert("com.qianfeng.mybatis.dto.UserMapper.save", userDTO);
        sqlSession.commit();
        System.out.println(i);
    }
    /**
     * 根据用户名来删除某一条数据
     */
    @Test
    public void testCase6(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDTO userDTO = new UserDTO();
        userDTO.setUser_name("wangwu");
        int delete = sqlSession.delete("com.qianfeng.mybatis.dto.UserMapper.delete", userDTO);
        sqlSession.commit();
        System.out.println(delete);
    }

    /**
     * 根据用户id来修改一条数据
     */
    @Test
    public void testCase7(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDTO userDTO = new UserDTO();
        userDTO.setUser_id(2);
        userDTO.setUser_name("wangwu");
        int update = sqlSession.update("com.qianfeng.mybatis.dto.UserMapper.update", userDTO);
        sqlSession.commit();
        System.out.println(update);
    }

    /**
     * mapper映射中配置结果集映射，
     */

    @Test
    public void testCase8(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User2DTO> list = sqlSession.selectList("com.qianfeng.mybatis.dto.UserMapper.queryUserByMap");
        for (User2DTO user:
             list) {
            System.out.println(user.getUsername());
        }
        sqlSession.close();
    }

    /**
     *
     */

    @Test
    public void testCase9(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        DepartmentDTO department = sqlSession.selectOne("com.qianfeng.mybatis.dto.DepartmentMapper.selectById",1);
        List<User2DTO> list = department.getList();
        for (User2DTO user :
                list) {
            System.out.println(user.getUsername());
        }
        sqlSession.close();
    }
}
