package com.cstad.api.user.web;

import java.util.List;

public record UpdateUserDto(
        String name,
        String gender,
        String studentCardNo,
        Boolean isStudent
) {
}
