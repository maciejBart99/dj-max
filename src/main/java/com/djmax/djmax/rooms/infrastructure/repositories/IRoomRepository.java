package com.djmax.djmax.rooms.infrastructure.repositories;

import com.djmax.djmax.rooms.domain.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IRoomRepository extends JpaRepository<Room, Long> {

    @Query("SELECT r FROM Room r WHERE r.code = ?1")
    Optional<Room> getByCode(String code);
}
