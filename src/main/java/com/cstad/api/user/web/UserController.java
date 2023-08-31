package com.cstad.api.user.web;

import com.cstad.api.user.User;
import com.cstad.api.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final   UserService userService;

    @GetMapping
    public CollectionModel<?> getAllUsers(){
        return userService.findAll();
    }
    @GetMapping("/{uuid}")
    public EntityModel<?> getUser(@PathVariable String uuid){
        return userService.findByUuid(uuid);
    }

    @PostMapping
    public EntityModel<?> createNewUser(CreateUserDto createUserDto){
        return userService.createNew(createUserDto);
    }

    @DeleteMapping("/{uuid}")
    public void deleteByUuid(@PathVariable String uuid) {
        userService.deleteByUuid(uuid);
    }

    @PutMapping("/{uuid}")
    public EntityModel<?> updateUserByUUID (@PathVariable String uuid ,UpdateUserDto updateUserDto){
        return userService.updateByUuid(uuid,updateUserDto);
    }

    @PutMapping("/{uuid}/disable")
    public void disableByUuid( @PathVariable String uuid){
         userService.disableByUuid(uuid);
    }


}
