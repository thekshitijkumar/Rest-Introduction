package com.kshitij.restIntro;

import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;
@RestController
public class MyController {

    private Map<Integer, User> users=new HashMap<>();


    //example get request with verbose enabled
//    curl -XGET "127.0.0.1:7000/get_user?my_id=3" -v
    // curl -XGET "127.0.0.1:7000/get_user" -v
    @GetMapping("/get_user")
    public List<User> getUsers(@RequestParam(value = "my_id",required = false)Integer user_id)
    {
        if(user_id==null)
        {
            if(users.values().size()>0)
                return users.values().stream().collect(Collectors.toList());
            else
                return new ArrayList<>();
        }
        else
        {
            return Collections.singletonList(users.get(user_id));
        }
    }


    //example curl request
//    curl -POST "127.0.0.1:7000/insert_user?id=1&name=Kshitij&age=20&country=India"
    @PostMapping("insert_user")
    public void insertUser(@RequestParam(value = "id")int id,@RequestParam(value = "name")String name,@RequestParam(value="age")int age,@RequestParam(value = "country")String country)
    {
        User u=new User(id,name,age,country);
        users.put(id,u);

    }



    //sending json data
//    curl -XPUT "127.0.0.1:7000/modify_user" -H "Content-type:application/json" -d'{"id":1,"name":"Shruti","age":20,"country":"India"}' -v
    @RequestMapping(value = "modify_user",method = RequestMethod.PUT)
    public void updateUser(@RequestBody User user) throws Exception {
        if(user==null)
            throw new Exception("User cannot be null");
        users.put(user.getId(),user);
    }
//    curl -XDELETE "127.0.0.1:7000/delete_user/4" -v
    @DeleteMapping("delete_user/{id}")
    public void deleteUser(@PathVariable("id") int id)
    {
        users.remove(id);
    }
    //curl -X DELETE "127.0.0.1:7000/delete_user?id=1" -v
    @DeleteMapping("delete_user")
    public void deleteUser2(@RequestParam("id") int id)
    {
        users.remove(id);
    }
}
