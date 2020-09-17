package cn.itcast.controller;


import cn.itcast.dao.UserMapper;
import cn.itcast.domain.User;
import cn.itcast.service.UserService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.xml.transform.Result;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

 

    @RequestMapping(value = "/updatePassword",produces = "text/html;charset=utf-8")
    public String updatePassword(Integer id,String password){
        User u = userService.selectByPrimaryKey(id);
        u.setPassword(password);
        int result = userService.updateByPrimaryKey(u);
        System.out.println(result+"");
        Map<String,Object> resMap = new HashMap<>();
        if(result>0){
            resMap.put("result",true);
        }else {
            resMap.put("result",false);
        }
        resMap.put("code",200);
        return JSONObject.toJSON(resMap).toString();
    }

    @RequestMapping(value = "/getUser",produces = "text/html;charset=utf-8")
    public String getUser(String name, String password,String userNumber){
        User u = new User();
        u.setName(name);
        u.setUserNumber(userNumber);
        u.setPassword(password);
        User user = userService.getUser(u );
        Map<String,Object> resMap = new HashMap<>();
        if(user!=null){
            System.out.println(user.toString());
            resMap.put("data",user);
            resMap.put("code",200);
            resMap.put("type",user.getType());
        }else {
            System.out.println("null");
            resMap.put("data","null");
            resMap.put("code",500);
         
        }


        return JSONObject.toJSON(resMap).toString();
    }

    @RequestMapping(value = "/findUserById",produces = "text/html;charset=utf-8")
    public String findUserById(Integer id){
        User user = userService.selectByPrimaryKey(id);
        System.out.println(user.toString());
        Map<String,Object> resMap = new HashMap<>();
        resMap.put("data",user);
        resMap.put("code",200);
        resMap.put("type",user.getType());
        return JSONObject.toJSON(resMap).toString();
    }
    @RequestMapping("/selectAll")
    public String selectAll(){
        List<User> all = userService.selectAll();
        Map<String,Object> resMap = new HashMap<>();
        resMap.put("data",all);
        return JSONObject.toJSON(resMap).toString();
    }


}
