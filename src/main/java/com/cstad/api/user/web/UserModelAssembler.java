package com.cstad.api.user.web;

import com.cstad.api.user.User;
import com.cstad.api.user.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class UserModelAssembler extends RepresentationModelAssemblerSupport<User, EntityModel<UserDto>> {

    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @SuppressWarnings("unchecked")
    public UserModelAssembler() {
        super(UserController.class, (Class<EntityModel<UserDto>>) (Class<?>) EntityModel.class);
    }

    @Override
    public EntityModel<UserDto> toModel(User entity) {
        UserDto userDto = userMapper.mapUsersToUserDto(entity);
        // add link
        Link selflink= linkTo(methodOn(UserController.class).getUser(entity.getUuid())).withSelfRel();
        Link collectionLink= linkTo(methodOn(UserController.class).getAllUsers()).withRel(IanaLinkRelations.COLLECTION);
        return EntityModel.of(userDto,selflink,collectionLink);
    }

    @Override
    public CollectionModel<EntityModel<UserDto>> toCollectionModel(Iterable<? extends User> entities) {
        return super.toCollectionModel(entities);
    }

}
