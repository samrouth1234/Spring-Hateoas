package com.cstad.api.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {

    List<UserRole> findByUser(User user);

    void deleteByUser(User user);


}
