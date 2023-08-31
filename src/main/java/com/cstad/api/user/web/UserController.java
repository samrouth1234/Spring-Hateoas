package com.cstad.api.user.web;

import com.cstad.api.account.Account;
import com.cstad.api.user.User;
import com.cstad.api.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    // @RequestBody take data when create
    @PostMapping
    public EntityModel<?> createNewUser(@RequestBody CreateUserDto createUserDto){
        return userService.createNew(createUserDto);
    }

    @DeleteMapping("/{uuid}")
    public void deleteByUuid(@PathVariable String uuid) {
        userService.deleteByUuid(uuid);
    }
    // @RequestBody take data when update
    @PutMapping("/{uuid}")
    public EntityModel<?> updateUserByUUID (@PathVariable  String uuid ,@RequestBody UpdateUserDto updateUserDto){
        return userService.updateByUuid(uuid,updateUserDto);
    }

    @PutMapping("/{uuid}/disable")
    public void disableByUuid( @PathVariable String uuid){
         userService.disableByUuid(uuid);
    }

    @GetMapping("/{uuid}/accounts")
    public ResponseEntity<List<Account>> getUserAccounts(@PathVariable String uuid) {
        List<Account> accounts = userService.getUserAccounts(uuid);
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }



}
