package com.cstad.api.user;

import com.cstad.api.role.Role;
import com.cstad.api.user.web.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserModelAssembler userModelAssembler;

    private final UserMapper userMapper;

    private final UserRoleRepository userRoleRepository;

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
    public void createUserRoles(Integer userId, List<Integer> roleIds) {
        roleIds.forEach(id -> {
            UserRole userRole = UserRole.builder()
                    .user(User.builder().id(Long.valueOf(userId)).build())
                    .role(Role.builder().id(Long.valueOf(id)).build())
                    .build();
            userRoleRepository.save(userRole);
        });
    }

    @Override
    public EntityModel<?> createNew(CreateUserDto createUserDto) {
        User user = userMapper.createUserDtoToUser(createUserDto);
        user.setUuid(UUID.randomUUID().toString());
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
            user.setEmail(updateUserDto.email());
            user.setPhoneNumber(updateUserDto.phoneNumber());
            userRepository.save(user);
            return  userModelAssembler.toModel(user);
        }
        throw new RuntimeException("user whit this uuid is not found ");
    }
}
