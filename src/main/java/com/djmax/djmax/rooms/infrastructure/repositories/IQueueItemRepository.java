package com.djmax.djmax.rooms.infrastructure.repositories;

import com.djmax.djmax.rooms.domain.entity.QueueItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IQueueItemRepository extends JpaRepository<QueueItem, Long> {
}

