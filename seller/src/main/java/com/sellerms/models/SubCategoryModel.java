package com.sellerms.models;


public class SubCategoryModel {

    private Integer id;

    private String subcategoryName;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubcategoryName() {
        return subcategoryName;
    }

    public void setSucbcategoryName(String subcategoryName) {
        this.subcategoryName = subcategoryName == null ? null : subcategoryName.trim();
    }


}
