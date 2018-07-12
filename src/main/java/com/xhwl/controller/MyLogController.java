package com.xhwl.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.xhwl.po.MyLog;
import com.xhwl.service.MyLogService;

@RequestMapping(value="myLog")
@Controller
public class MyLogController extends BaseController{
    //注入service
    @Autowired
    private MyLogService myLogService;

    /**
     * 跟具id查询MyLog
     * @param id
     * @return
     */
    //@Auth(checkMyLogLogin=true,checkAdminLogin=true)
    @RequestMapping("/{myLogId}")        //请求路径占位符映射
    public ResponseEntity<MyLog> getMyLogById(@PathVariable("myLogId")int id){
        MyLog myLog = myLogService.queryMyLogById(id);
        return this.sendToClient(myLog);
    }
    
    @RequestMapping("/bypage/{pageNum}/{pageSize}")
    @ResponseBody
    public ResponseEntity<List<MyLog>> getMyLogByPage( @PathVariable("pageNum")int pageNum,@PathVariable("pageSize")int pageSize){
        try{
            System.out.println("=========="+pageNum+"\t"+pageSize+"==========");
            List<MyLog> list = myLogService.queryByPage(pageNum, pageSize);
            return  ResponseEntity.ok(list);
        }catch(Exception e){
            e.printStackTrace();
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        
    }
    @RequestMapping("/bypagehelper/{pageNum}/{pageSize}")
    @ResponseBody
    public ResponseEntity<PageInfo<MyLog>> getMyLogByPageHelper( @PathVariable("pageNum")int pageNum,@PathVariable("pageSize")int pageSize){
        try{
            System.out.println("=========="+pageNum+"\t"+pageSize+"==========");
            PageInfo<MyLog> pageInfo = myLogService.queryByPageInfo(null, pageNum, pageSize);
            return ResponseEntity.ok(pageInfo);
        }catch(Exception e){
            e.printStackTrace();
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        
    }
    
    /*@RequestMapping("/num/{num}")
    @ResponseBody
    public ResponseEntity<MyLog> getMyLogByNumRest(@PathVariable("num")int num){
        try{
            MyLog myLog = myLogService.queryMyLogByNum(num);
            return  ResponseEntity.ok(myLog);
        }catch(Exception e){
            e.printStackTrace();
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
    @RequestMapping(value="/update" ,method=RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<MyLog> updateMyLog(MyLog myLog){//@RequestBody 
        try{
//            myLog = new MyLog();
//            myLog.setId(1);
//            myLog.setNum(1);
//            myLog.setTitle("标题1");
//            myLog.setImagePath("图片路径1");
//            myLog.setImageName("图片名1");
            myLogService.updateMyLog(myLog);
            return  ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }catch(Exception e){
            e.printStackTrace();
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
    @RequestMapping(value="/delete" ,method=RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<MyLog> deleteMyLogById(@PathVariable("id")int id){
        try{
            myLogService.deleteMyLogById(id);
            return  ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }catch(Exception e){
            e.printStackTrace();
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }*/
    
    
    
}
