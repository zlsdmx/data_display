package com.xhwl.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.xhwl.annotation.Auth;
import com.xhwl.po.Notification;
import com.xhwl.service.NotificationService;
@RestController
@RequestMapping(value="notification")
@Controller
public class NotificationController extends BaseController{
    //注入service
    @Autowired
    private NotificationService notificationService;

    /**
     * 跟具id查询Notification
     * @param id
     * @return
     */
    @Auth(checkUserLogin=true,checkAdminLogin=true)
    @RequestMapping("/{notificationId}")        //请求路径占位符映射
    public ResponseEntity<?> getNotificationById(@PathVariable("notificationId")int id) throws Exception{
        Notification notification = notificationService.queryNotificationById(id);
        return this.sendToClient(notification);
    }
    
    @RequestMapping("/rest/{notificationId}")
    @ResponseBody
    public ResponseEntity<?> getNotificationByIdRest(@PathVariable("notificationId")int id){
    	 Notification notification = notificationService.queryNotificationById(id);
         List<Notification> list = new ArrayList<Notification>();
         Notification notification1 = new Notification();
         notification1.setId(1L);
//         notification1.setImageName("image1");
         Notification notification2 = new Notification();
         notification2.setId(2L);
//         notification2.setImageName("image2");
         list.add(notification1);
         list.add(notification2);
          
         return sendToClient(notification,list,true);
    }
    
    @RequestMapping(value="/bypage/{pageNum}/{pageSize}",method=RequestMethod.GET)
    public ResponseEntity<List<Notification>> getNotificationByPage( @PathVariable("pageNum")int pageNum,@PathVariable("pageSize")int pageSize){
        try{
            System.out.println("=========="+pageNum+"\t"+pageSize+"==========");
            List<Notification> list = notificationService.queryByPage(pageNum, pageSize);
            return  ResponseEntity.ok(list);
        }catch(Exception e){
            e.printStackTrace();
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        
    }
    @RequestMapping("/bypagehelper/{pageNum}/{pageSize}")
    @ResponseBody
    public ResponseEntity<PageInfo<Notification>> getNotificationByPageHelper( @PathVariable("pageNum")int pageNum,@PathVariable("pageSize")int pageSize){
        try{
            System.out.println("=========="+pageNum+"\t"+pageSize+"==========");
            PageInfo<Notification> pageInfo = notificationService.queryByPageInfo(null, pageNum, pageSize);
            return ResponseEntity.ok(pageInfo);
        }catch(Exception e){
            e.printStackTrace();
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        
    }
    
    /*@RequestMapping("/num/{num}")
    @ResponseBody
    public ResponseEntity<Notification> getNotificationByNumRest(@PathVariable("num")int num){
        try{
            Notification notification = notificationService.queryNotificationByNum(num);
            return  ResponseEntity.ok(notification);
        }catch(Exception e){
            e.printStackTrace();
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
    @RequestMapping(value="/update" ,method=RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Notification> updateNotification(Notification notification){//@RequestBody 
        try{
//            notification = new Notification();
//            notification.setId(1);
//            notification.setNum(1);
//            notification.setTitle("标题1");
//            notification.setImagePath("图片路径1");
//            notification.setImageName("图片名1");
            notificationService.updateNotification(notification);
            return  ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }catch(Exception e){
            e.printStackTrace();
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
    @RequestMapping(value="/delete" ,method=RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Notification> deleteNotificationById(@PathVariable("id")int id){
        try{
            notificationService.deleteNotificationById(id);
            return  ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }catch(Exception e){
            e.printStackTrace();
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }*/
    
    
    
}
