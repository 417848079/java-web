package com.xxq.mapper;
import com.xxq.pojo.Brand;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BrandMapper {

    /**
     * @author: amw
     * @createTime: 2023年01月04 10:16:27
     * @description: 查询所有
     * @param:
     * @return: java.util.List<com.xxq.pojo.Brand>
     */
    @Select("select * from tb_brand")
    @ResultMap("brandResultMap")
    List<Brand> selectAll();

    /**
     * @author: amw
     * @createTime: 2023年01月04 14:42:05
     * @description: 添加
     * @param:
     * @return: void
     */
    @Insert("insert into tb_brand values (null,#{brandName},#{companyName},#{ordered},#{description},#{status})")
    @ResultMap("brandResultMap")
    void add(Brand brand);


    void updateBrand(Brand brand);

    /**
     * @author: amw
     * @createTime: 2023年01月04 16:23:06
     * @description: 根据id查询单条
     * @param: id - [int]
     * @return: com.xxq.pojo.Brand
     */
    @Select("select * from tb_brand where id = #{id}")
    @ResultMap("brandResultMap")
    Brand selectOne(int id);

    /**
     * @author: amw
     * @createTime: 2023年01月05 09:44:44
     * @description: 删除
     * @param: id - [int]
     * @return: void
     */
    @Delete("delete from tb_brand where id = #{id}")
    void deleteById(int id);
}
