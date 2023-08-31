package com.cstad.api.user;

import com.cstad.api.user.web.CreateUserDto;
import com.cstad.api.user.web.UpdateUserDto;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

import java.util.List;

public interface UserService {

    CollectionModel<?> findAll();

    EntityModel<?> findByUuid(String uuid);

    EntityModel <?> createNew (CreateUserDto createUserDto);

    void createUserRoles(Integer userId, List<Integer> roleIds);


    void deleteByUuid(String uuid);

    String disableByUuid (String uuid);

    EntityModel<?> updateByUuid(String uuid, UpdateUserDto updateUserDto);


}
