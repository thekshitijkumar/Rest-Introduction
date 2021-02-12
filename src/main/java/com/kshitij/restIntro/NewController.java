package com.kshitij.restIntro;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewController {

    private static Logger logger= LoggerFactory.getLogger(NewController.class);
    @Autowired
    User user;

    @GetMapping("/other/test")
    public User test()
    {
        System.out.println(user);
        return user;
    }
    @Autowired
    MyConfiguration myConfiguration;

    @GetMapping("/bean/test")
    public User getUser()
    {

        User u=myConfiguration.getUser();
        logger.debug("user is {}",u);
        return u;
    }
}
