package com.cstad.api.user.web;

import java.util.List;

public record UpdateUserDto(
                            String name,
                            String gender,
                            String email,
                            Boolean isStudent,
                            String phoneNumber,
                            List<Integer> roleIds) {
}
