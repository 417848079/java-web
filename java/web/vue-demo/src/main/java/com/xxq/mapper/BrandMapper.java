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
     * @createTime: 2023年01月06 17:56:52
     * @description: 查询全部
     * @param:
     * @return: java.util.List<com.xxq.pojo.Brand>
     */
    @Select("select * from tb_brand")
    @ResultMap("brandResultMap")
    List<Brand> selectAll();


    @Insert("insert into tb_brand values (null,#{brandName},#{companyName},#{ordered},#{description},#{status},null)")
    @ResultMap("brandResultMap")
    void add(Brand brand);

    @Delete("delete from tb_brand where id=#{id}")
    void deleteById(int id);
}
