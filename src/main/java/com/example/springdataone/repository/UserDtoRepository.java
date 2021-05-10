package com.example.springdataone.repository;


import com.example.springdataone.repository.entity.UserDto;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;

public interface UserDtoRepository extends CrudRepository<UserDto, Long> {

    @Transactional
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("SELECT :name FROM UserDto as u")
    Optional<UserDto> findByName(@Param("name") String name);
}
