package com.example.springdataone.repository;

import com.example.springdataone.repository.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

    @Transactional
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("SELECT :name FROM User as u")
    Optional<User> findByName(@Param("name") String name);
}
