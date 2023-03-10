package com.xxq.test;

import com.xxq.mapper.BrandMapper;
import com.xxq.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * mybatis测试
 * <p>
 * <p>
 * className: MyBatisTest
 * author: xxq
 * create: 2022-12-23 10:18
 */
public class MyBatisTest {
    @Test
    public void testSelectAll() throws IOException {
        //1.获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        List<Brand> brands = brandMapper.selectAll();
        System.out.println(brands);

        //5.释放资源
        sqlSession.close();
    }


    @Test
    public void testSelectById() throws IOException {
        // 接收参数
        int id = 1;
        //1.获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        Brand brand = brandMapper.selectById(id);
        System.out.println(brand);

        //5.释放资源
        sqlSession.close();
    }


    @Test
    public void selectByCondition() throws IOException {
        // 接收参数
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";

        //处理参数
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        //封装对象
//        Brand brand = new Brand();
//        brand.setCompanyName(companyName);
//        brand.setBrandName(brandName);
//        brand.setStatus(status);

        HashMap map = new HashMap();
//        map.put("status",status);
        map.put("companyName", companyName);
        map.put("brandName", brandName);


        //1.获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
//        List<Brand> brands = brandMapper.selectByCondition(status,companyName,brandName);
//        List<Brand> brands = brandMapper.selectByCondition(brand);
        List<Brand> brands = brandMapper.selectByCondition(map);
        System.out.println(brands);

        //5.释放资源
        sqlSession.close();
    }


    @Test
    public void selectByConditionSingle() throws IOException {
        // 接收参数
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";

        //处理参数
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

//        封装对象
        Brand brand = new Brand();
//        brand.setCompanyName(companyName);
//        brand.setBrandName(brandName);
//        brand.setStatus(status);


        //1.获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
//        List<Brand> brands = brandMapper.selectByCondition(status,companyName,brandName);
//        List<Brand> brands = brandMapper.selectByCondition(brand);
        List<Brand> brands = brandMapper.selectByConditionSingle(brand);
        System.out.println(brands);

        //5.释放资源
        sqlSession.close();
    }



    @Test
    public void testAdd() throws IOException {
        // 接收参数
        int status = 1;
        String companyName = "波导手机";
        String brandName = "波导";
        String description="手机中的战斗机";
        int ordered = 100;

//        封装对象
        Brand brand = new Brand();
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setOrdered(ordered);
        brand.setStatus(status);

        //1.获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession对象
        //SqlSession sqlSession = sqlSessionFactory.openSession();
//      自动提交事务
       SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //3.获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        brandMapper.add(brand);

        //提交事务
        sqlSession.commit();


        //5.释放资源
        sqlSession.close();
    }



    /**
     * @author: amw
     * @createTime: 2022年12月26 10:44:36
     * @description: 主键返回
     * @param:
     * @return: void
     */
    @Test
    public void testAdd2() throws IOException {
        // 接收参数
        int status = 1;
        String companyName = "波导手机";
        String brandName = "波导";
        String description="手机中的战斗机";
        int ordered = 100;

//        封装对象
        Brand brand = new Brand();
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setOrdered(ordered);
        brand.setStatus(status);

        //1.获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession对象
        //SqlSession sqlSession = sqlSessionFactory.openSession();
//      自动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //3.获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        brandMapper.add(brand);
        Integer id = brand.getId();

        //提交事务
        sqlSession.commit();
        System.out.println(id);

        //5.释放资源
        sqlSession.close();
    }



    @Test
    public void testUpdate() throws IOException {
        // 接收参数
        int status = 0;
        String companyName = "波导手机";
        String brandName = "波导";
        String description="波导手机,手机中的战斗机";
        int ordered = 200;
        int id = 5;

//        封装对象
        Brand brand = new Brand();
//        brand.setCompanyName(companyName);
//        brand.setBrandName(brandName);
//        brand.setDescription(description);
//        brand.setOrdered(ordered);
        brand.setStatus(status);
        brand.setId(id);

        //1.获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession对象
        //SqlSession sqlSession = sqlSessionFactory.openSession();
//      自动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //3.获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        int count = brandMapper.update(brand);


        //提交事务
        sqlSession.commit();
        System.out.println(count);

        //5.释放资源
        sqlSession.close();
    }


    @Test
    public void testDeleteById() throws IOException {
        // 接收参数
        int id = 6;

        //1.获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession对象
        //SqlSession sqlSession = sqlSessionFactory.openSession();
//      自动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
       brandMapper.deleteById(id);


        //提交事务
        sqlSession.commit();

        //5.释放资源
        sqlSession.close();
    }

    @Test
    public void testDeleteByIds() throws IOException {
        // 接收参数
        int[] ids = {5,7} ;

        //1.获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取SqlSession对象
        //SqlSession sqlSession = sqlSessionFactory.openSession();
//      自动提交事务
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行方法
        brandMapper.deleteByIds(ids);


        //提交事务
        sqlSession.commit();

        //5.释放资源
        sqlSession.close();
    }
}