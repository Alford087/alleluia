package com.mars.alleluia.login;

import com.mars.alleluia.base.BaseController;
import com.mars.alleluia.login.bean.User;
import com.mars.alleluia.login.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/users")
public class UserController extends BaseController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "/join", method = RequestMethod.POST)
    @ResponseBody
    public Object createUser(@ModelAttribute User user) {
        Map<String, String> result = new HashMap<>();
        int createResult = 0;
        try {
            createResult=this.userMapper.createUser(user);
        } catch (Exception e) {
            packet(1, e.getMessage(), null);
        }
        if (createResult > 0) {
            packet(0, null, null);
        } else {
            packet(1, "failed", null);
        }
        return result;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public Object getVersion() {
        Map<String, String> result = new HashMap<>();
        result.put("code", "1.0");
        return packet(0, null, result);
    }

    @RequestMapping(value = "/{userid}", method = RequestMethod.GET)
    @ResponseBody
    public User getUser(@PathVariable("userid") int userid) {
        return this.userMapper.queryUserById(userid);
    }
}
