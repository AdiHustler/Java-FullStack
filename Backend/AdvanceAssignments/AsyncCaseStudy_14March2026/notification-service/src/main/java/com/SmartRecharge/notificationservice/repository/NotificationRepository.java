package com.SmartRecharge.notificationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SmartRecharge.notificationservice.entity.NotificationEntity;

import java.util.List;

@Repository
public interface NotificationRepository extends JpaRepository<NotificationEntity, Long> {
    List<NotificationEntity> findByRechargeId(Long rechargeId);
    List<NotificationEntity> findByUserIdOrderBySentAtDesc(Long userId);
}
