package com.cstad.api.user;

import java.util.Collections;
import java.util.stream.Collectors;
import com.cstad.api.account.Account;
import com.cstad.api.account.AccountRepository;
import com.cstad.api.role.Role;
import com.cstad.api.user.web.*;
import com.cstad.api.user_account.UserAccount;
import com.cstad.api.user_account.UserAccountRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserModelAssembler userModelAssembler;

    private final UserMapper userMapper;

    private final UserAccountRepository userAccountRepository;
    @Override
    public CollectionModel<?> findAll() {
        List<User> users = userRepository.findAll();
        return userModelAssembler.toCollectionModel(users);
    }

    @Override
    public EntityModel<?> findByUuid(String uuid) {
        User user = userRepository.findByUuid(uuid).orElseThrow();
        return userModelAssembler.toModel(user);
    }


    @Override
    public EntityModel<?> createNew(CreateUserDto createUserDto) {
        if (createUserDto == null) {
            throw new IllegalArgumentException("createUserDto cannot be null");
        }

        User user = userMapper.createUserDtoToUser(createUserDto);

        user.setUuid(UUID.randomUUID().toString());
        user.setName(createUserDto.name());
        user.setGender(createUserDto.gender());
        user.setStudentCardNo(createUserDto.studentCardNo());

        user.setIsDeleted(false);
        user.setIsVerified(true);

        userRepository.save(user);
        return userModelAssembler.toModel(user);
    }

    @Transactional
    @Override
    public void deleteByUuid(String uuid) {
        userRepository.deleteByUuid(uuid);
    }

    @Transactional
    @Override
    public String disableByUuid(String uuid) {
        Optional<User> optionalUser = userRepository.findByUuid(uuid);
        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            user.setIsDeleted(true);
            userRepository.save(user);
        }
        return "User UUID :"+ uuid +"is now disable";
    }

    @Override
    public EntityModel<?> updateByUuid(String uuid, UpdateUserDto updateUserDto) {
        Optional<User> optionalUser = userRepository.findByUuid(uuid);
        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            user.setName(updateUserDto.name());
            user.setGender(updateUserDto.gender());
            user.setIsStudent(updateUserDto.isStudent());
            user.setStudentCardNo(updateUserDto.studentCardNo());
            userRepository.save(user);
            return  userModelAssembler.toModel(user);
        }
        throw new RuntimeException("user with this uuid is not found ");
    }

    @Override
    public List<Account> getUserAccounts(String uuid) {
        List<UserAccount> userAccounts = userAccountRepository.findByUuid(uuid);
        List<Account> accounts = userAccounts.stream()
                .map(UserAccount::getAccount)
                .collect(Collectors.toList());
        return accounts;
    }

}
