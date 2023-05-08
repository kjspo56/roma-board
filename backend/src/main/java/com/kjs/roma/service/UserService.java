package com.kjs.roma.service;

import com.kjs.roma.dto.user.UserDTO;
import com.kjs.roma.environment.response.ApiResponse;
import com.kjs.roma.response.ResponseCode;

public class UserService {
    public ApiResponse login(UserDTO userDTO) {

        return ApiResponse.createSuccess(ResponseCode.SUCCESS.code());
    }
}
