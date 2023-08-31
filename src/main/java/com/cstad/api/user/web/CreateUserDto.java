package com.cstad.api.user.web;

import java.util.List;

public record CreateUserDto(
                            String name,

                            String gender,

                            Boolean isStudent,
                            String studentCardNo,

                            List<Integer> roleIds) {
}
