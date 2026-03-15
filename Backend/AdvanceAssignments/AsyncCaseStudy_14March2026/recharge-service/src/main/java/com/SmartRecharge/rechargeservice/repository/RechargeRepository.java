package com.SmartRecharge.rechargeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SmartRecharge.rechargeservice.entity.RechargeEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface RechargeRepository extends JpaRepository<RechargeEntity, Long> {
    List<RechargeEntity> findByUserId(Long userId);
    Optional<RechargeEntity> findByTransactionId(String txnId);
}
