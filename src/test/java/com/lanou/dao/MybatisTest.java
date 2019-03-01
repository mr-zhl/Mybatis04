package com.lanou.dao;

import com.lanou.pojo.BMan;
import com.lanou.pojo.BWoman;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:spring-cofing.xml")
public class MybatisTest {

    @Autowired
    private BManDao bManDao;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Test
    void test1() {
        List<BMan> bManList = bManDao.selectAllBMan();
        for (BMan bMan : bManList) {
            System.out.println(bMan);
            System.out.println(bMan.getWomanList());
        }
    }

    @Test
    void test2() {
        BMan bMan = bManDao.selectByPrimaryKey(1);
        System.out.println(bMan);
    }

    @Test
    void test3() {
        //懒加载
        //1.全局配置,在mybatis配置文件中,lazyLoadingEnabled=true
        //2.局部配合,在没有batis映射文件的resultMap中,fetchType="lazy"

        //配合resultMap中的collection,association,select,column


    }

    @Test
    void test4() {
        //System.out.println(sqlSession);
        //mybatis的缓存级别
        //1.一级缓存,sqlSession级别,默认开启,查询数据时,会先去一级缓存中获取数据,如果没有再去数据库中查
        //2.二级缓存,mapper级别,默认没有开启
        //开启在MyBatis的配置中,添加cacheEnabled=true,在指定的映射文件中添加<cache/>

        //sqlSession相当于一个连接,二级缓存,将数据序列化

    }

    @Test
    void test5() {
        //用户查数据库,缓存只有一个session
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BManDao bManDao = sqlSession.getMapper(BManDao.class);
        BMan bMan = bManDao.selectByPrimaryKey(1);
        System.out.println(bMan);

        //sqlSession关闭,无法操作数据
        //sqlSession.close();

        //清除缓存
        //sqlSession.clearCache();

        //当执行增删改操作后,清空缓存
        BMan b = new BMan();
        b.setId(2);
        b.setName("小明");

        Example example = new Example(BMan.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id",2);
        bManDao.updateByExampleSelective(b,example);

        System.out.println("??????????");

        sqlSession = sqlSessionFactory.openSession();
        bManDao = sqlSession.getMapper(BManDao.class);
        BMan bMan1 = bManDao.selectByPrimaryKey(1);
        System.out.println(bMan1);
    }

    @Test
    void test6() {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        BManDao bManDao = sqlSession.getMapper(BManDao.class);
        BMan bMan = bManDao.selectById(1);
        System.out.println(bMan);

        //没有关闭,数据存在一级缓存,关闭后,存入二级缓存
        sqlSession.close();

        System.out.println("////////////");

        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        BManDao bManDao1 = sqlSession1.getMapper(BManDao.class);
        BMan bMan1 = bManDao1.selectById(1);
        System.out.println(bMan1);


    }
}
