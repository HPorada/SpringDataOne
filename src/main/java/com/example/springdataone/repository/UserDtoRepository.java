package com.example.springdataone.repository;


import com.example.springdataone.repository.entity.UserDto;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface UserDtoRepository extends CrudRepository<UserDto, Long> {

    @Transactional
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("SELECT :name FROM UserDto as u")
    Optional<UserDto> findByName(@Param("name") String name);
}
