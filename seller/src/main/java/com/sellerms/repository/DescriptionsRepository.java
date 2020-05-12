package com.sellerms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sellerms.entity.DescriptionsEntity;

@Repository
public interface DescriptionsRepository extends JpaRepository<DescriptionsEntity, Integer>{
}