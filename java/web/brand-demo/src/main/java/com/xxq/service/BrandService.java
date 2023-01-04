package com.xxq.service;

import com.xxq.mapper.BrandMapper;
import com.xxq.pojo.Brand;
import com.xxq.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * <p>
 *
 * <p>
 *
 * @ClassName: BrandService
 * @Author: xxq
 * @Create: 2023-01-04 10:17
 */
public class BrandService {
    //1.获取sqlSessionFactory
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public List<Brand> selectAll(){
        //调用BrandMapper.selectAll

        //2.获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3.获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //4.执行方法
        List<Brand> brands = mapper.selectAll();
        //5.释放资源
        sqlSession.close();
        return brands;
    }


    /**
     * @author: amw
     * @createTime: 2023年01月04 15:39:00
     * @description: 添加
     * @param: brand - [Brand]
     * @return: void
     */
    public void add(Brand brand){
        //2.获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3.获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //4.执行方法
        mapper.add(brand);
        //提交事务
        sqlSession.commit();
        //5.释放资源
        sqlSession.close();
    }

    /**
     * @author: amw
     * @createTime: 2023年01月04 16:26:30
     * @description:查询单条
     * @param:
     * @return: void
     */
    public Brand selectOne(int id){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = mapper.selectOne(id);
        return brand;
    }


    /**
     * @author: amw
     * @createTime: 2023年01月04 15:39:00
     * @description: 修改
     * @param: brand - [Brand]
     * @return: void
     */
    public void update(Brand brand){
        //2.获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3.获取BrandMapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        //4.执行方法
        mapper.updateBrand(brand);
        //提交事务
        sqlSession.commit();
        //5.释放资源
        sqlSession.close();
    }
}