package com.ksr.repository;

import com.ksr.model.Room;
import com.ksr.model.RoomShare;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface RoomSharesRepository extends CrudRepository<RoomShare, Long> {
    List<RoomShare> findAll();
}
