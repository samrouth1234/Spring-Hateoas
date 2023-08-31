package com.cstad.api.user.web;


public record UpdateUserDto(
        String name,
        String gender,
        String studentCardNo,
        Boolean isStudent,
        Boolean isDeleted
) {
}
