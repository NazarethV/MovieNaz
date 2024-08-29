package com.movieflix.auth.repositories;

import com.movieflix.auth.entities.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String username);

    @Transactional
    @Modifying
    @Query("UPDATE User u SET u.password = ?1 WHERE u.username = ?2")
    void updatePassword(String email, String password);

}
