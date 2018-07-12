package com.xhwl.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.xhwl.annotation.SystemLog;
import com.xhwl.po.User;
import com.xhwl.service.UserService;

@RequestMapping(value="user")
@Controller
public class UserController extends BaseController{
    //注入service
    @Autowired
    private UserService userService;

    /**
     * 跟具id查询User
     * @param id
     * @return
     */
    @SuppressWarnings("rawtypes")
	//@Auth(checkUserLogin=true,checkAdminLogin=true)
    @RequestMapping("/{userId}")        //请求路径占位符映射
    public ResponseEntity getUserById(@PathVariable("userId")Long id) throws Exception{
        User user = userService.queryUserById(id);
        return this.sendToClient(user);
    }
    
    
    
    
    @SystemLog(methods = "用户查询",module = "用户管理")
    @RequestMapping("/rest/{userId}")
    @ResponseBody
    public ResponseEntity<?> getUserByIdRest(@PathVariable("userId")Long id){
    	 User user = userService.queryUserById(id);
         List<User> list = new ArrayList<User>();
         User user1 = new User();
         user1.setId(1L);
//         user1.setImageName("image1");
         User user2 = new User();
         user2.setId(2L);
//         user2.setImageName("image2");
         list.add(user1);
         list.add(user2);
         
         return sendToClient(user,list,true);
    }
    
    @RequestMapping("/bypage/{pageNum}/{pageSize}")
    @ResponseBody
    public ResponseEntity<List<User>> getUserByPage( @PathVariable("pageNum")int pageNum,@PathVariable("pageSize")int pageSize) throws Exception{
        System.out.println("=========="+pageNum+"\t"+pageSize+"==========");
        List<User> list = userService.queryByPage(pageNum, pageSize);
        return  ResponseEntity.ok(list);
    }
    
    
    @RequestMapping("/byUserId/{userId}")
    @ResponseBody
    public ResponseEntity<User> getUserByuserId( @PathVariable("userId")String userId) throws Exception{
        User user = userService.queryByUserId(userId);
        return  ResponseEntity.ok(user);
    }
    
    @RequestMapping("/bypagehelper/{pageNum}/{pageSize}")
    @ResponseBody
    public ResponseEntity<PageInfo<User>> getUserByPageHelper( @PathVariable("pageNum")int pageNum,@PathVariable("pageSize")int pageSize) throws Exception{
        System.out.println("=========="+pageNum+"\t"+pageSize+"==========");
        PageInfo<User> pageInfo = userService.queryByPageInfo(null, pageNum, pageSize);
        return ResponseEntity.ok(pageInfo);
    }
    
    /*@RequestMapping("/num/{num}")
    @ResponseBody
    public ResponseEntity<User> getUserByNumRest(@PathVariable("num")int num){
        try{
            User user = userService.queryUserByNum(num);
            return  ResponseEntity.ok(user);
        }catch(Exception e){
            e.printStackTrace();
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
    @RequestMapping(value="/update" ,method=RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<User> updateUser(User user){//@RequestBody 
        try{
//            user = new User();
//            user.setId(1);
//            user.setNum(1);
//            user.setTitle("标题1");
//            user.setImagePath("图片路径1");
//            user.setImageName("图片名1");
            userService.updateUser(user);
            return  ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }catch(Exception e){
            e.printStackTrace();
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
    @RequestMapping(value="/delete" ,method=RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<User> deleteUserById(@PathVariable("id")int id){
        try{
            userService.deleteUserById(id);
            return  ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }catch(Exception e){
            e.printStackTrace();
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }*/
    
    
    
}
