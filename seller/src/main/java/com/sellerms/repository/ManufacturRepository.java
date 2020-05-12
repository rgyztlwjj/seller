package com.sellerms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sellerms.entity.ManufacturEntity;

@Repository
public interface ManufacturRepository extends JpaRepository<ManufacturEntity, Integer>{
}