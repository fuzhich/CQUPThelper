package com.example;

import com.example.mapper.Usermapper;
import com.example.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    private Usermapper usermapper;
    @Test
    public void testlistuser(){
        List<User> userList = usermapper.list();
        userList.stream().forEach(user->{
            System.out.println(user);
        });
    }

}
