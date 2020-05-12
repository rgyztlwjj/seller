package com.sellerms.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="subcategory")
public class SubCategoryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

	@Column(name="subcategory_name")
    private String subcategoryName;

	@Column(name="category_id")
	private Integer categoryId;
	
	@Column(name="brief_details")
    private String briefDetails;

	private BigDecimal GSN;

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

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
    
    public String getBriefDetails() {
        return briefDetails;
    }

    public void setBriefDetails(String briefDetails) {
        this.briefDetails = briefDetails == null ? null : briefDetails.trim();
    }
    

	public BigDecimal getGSN() {
		return GSN;
	}

	public void setPrice(BigDecimal GSN) {
		this.GSN = GSN;
	}

}
