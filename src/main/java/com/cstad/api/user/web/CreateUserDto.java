package com.cstad.api.user.web;

import java.util.List;

public record CreateUserDto(
                            String name,

                            String gender,

                            String email,

                            String password,

                            String phoneNumber,

                            Boolean isStudent,
                            String studentCardNo,

                            List<Integer> roleIds) {
}
