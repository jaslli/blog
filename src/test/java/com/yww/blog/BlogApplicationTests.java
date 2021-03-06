package com.yww.blog;

import com.yww.blog.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BlogApplicationTests {

    @Autowired
    UserServiceImpl userService;

    @Test
    void contextLoads() {
        userService.getUserList();
    }

}
