package com.xxq.mapper;

import com.xxq.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {
    /**
     *
     * 查询所有
     * */
    public List<Brand> selectAll();

    /**
     * @author: amw
     * @createTime: 2022年12月23 15:39:29
     * @description: 查看详情
     * @param: id - [int]
     * @return: com.xxq.pojo.Brand
     */
    Brand selectById(int id);


    /**
     * @author: amw
     * @createTime: 2022年12月23 16:10:44
     * @description:条件查询
     *      *参数接收
     *      1.散装参数：如果方法中有多个参数，需要使用@Param（“sql参数占位符名称”）
     *      2.对象参数：对象的属性名称要和参数占位符一致
     *      3.map集合参数
     *
     * @param: status - [int]
     * @param: companyName - [String]
     * @param: brandName - [String]
     * @return: java.util.List<com.xxq.pojo.Brand>
     */

//    List<Brand> selectByCondition(@Param("status") int status,@Param("companyName") String companyName,@Param("brandName") String brandName);

//    List<Brand> selectByCondition(Brand brand);

    List<Brand> selectByCondition(Map map);



/**
 * @author: amw
 * @createTime: 2022年12月23 16:49:44
 * @description:单条件动态查询
 * @param: brand - [Brand]
 * @return: java.util.List<com.xxq.pojo.Brand>
 */
    List<Brand> selectByConditionSingle(Brand brand);


    /**
     * @author: amw
     * @createTime: 2022年12月23 17:02:20
     * @description:添加
     * @param: brand - [Brand]
     * @return: void
     */
    void add(Brand brand);
}
