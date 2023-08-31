package com.cstad.api.user;
import com.cstad.api.user.web.CreateUserDto;
import com.cstad.api.user.web.UpdateUserDto;
import com.cstad.api.user.web.UserDto;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto mapUsersToUserDto (User user);

    List<UserDto> mapUserToUserDtoList(List<User> users);

    User createUserDtoToUser(CreateUserDto createUserDto);

    void updateUserDtoToUser(UpdateUserDto updateUserDto, @MappingTarget User user);
}
