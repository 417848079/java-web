package com.xxq.pojo;

/**
 * <p>
 * 品牌信息
 * alt + 鼠标左键
 * 在实体类中，基本数据类型建议使用其对应的包装类型
 * <p>
 *
 * @className: Brand
 * @author: xxq
 * @create: 2022-12-21 11:04
 */
public class Brand {
  private Integer id;	// id 主键
  private String brandName;	// 品牌名称
  private String companyName;		// 企业名称
  private Integer ordered;		// 排序字段
  private String description; // 描述信息
  private Integer status;  // 状态：0：禁用  1：启用

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getOrdered() {
        return ordered;
    }

    public void setOrdered(int ordered) {
        this.ordered = ordered;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", brandName='" + brandName + '\'' +
                ", companyName='" + companyName + '\'' +
                ", ordered=" + ordered +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}