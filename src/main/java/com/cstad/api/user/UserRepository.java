package com.cstad.api.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUuid(String uuid);

    boolean existsByUuid(String uuid);

    @Modifying
    @Query("DELETE FROM User u WHERE u.uuid = :uuid")
    void deleteByUuid(String uuid);


}
