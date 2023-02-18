package com.fullstackprojects.recyclingapp.dao;

import com.fullstackprojects.recyclingapp.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

public interface UserRepository extends JpaRepository<User, Long> {

    Page<User> findByUserEmail(@RequestParam("user_email") String userEmail, Pageable pageable);

}
