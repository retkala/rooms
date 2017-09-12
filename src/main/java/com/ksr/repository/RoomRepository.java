package com.ksr.repository;

import com.ksr.model.Room;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by ktrzn on 11.09.2017.
 */
public interface RoomRepository extends CrudRepository<Room, Long> {

    List<Room> findAllById(Long id);

    List<Room> findAllByOwner(String owner);

}
