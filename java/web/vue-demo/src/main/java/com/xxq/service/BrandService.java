package com.xxq.service;

import com.xxq.pojo.Brand;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BrandService {
    /**
     * 查询所有
     * @return
     */
   @Select("select * from tb_brand")
    List<Brand> selectAll();
}
