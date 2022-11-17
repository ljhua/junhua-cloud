package me.junhua.system.controller.mock;

import me.junhua.common.result.Result;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
public class UserController {

    @CrossOrigin
    @PostMapping("/vue-admin-template/user/login")
    public Result<?> login(@RequestBody UserLoginDTO userLoginDTO) {
        UserLoginInfo userLoginInfo = new UserLoginInfo();
        userLoginInfo.setToken("admin-token");
        return Result.data(userLoginInfo);
    }

    @CrossOrigin
    @PostMapping("/vue-admin-template/user/logout")
    public Result<?> logout() {
        return Result.data("success");
    }

    @CrossOrigin
    @GetMapping("/vue-admin-template/user/info")
    public Result<?> info(String token) {
        UserInfo userInfo = new UserInfo();
        userInfo.setRoles(Arrays.asList("admin"));
        userInfo.setIntroduction("我是超级管理员");
        userInfo.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        userInfo.setName("超级管理员");
        return Result.data(userInfo);
    }
}
