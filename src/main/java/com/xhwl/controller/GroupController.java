package com.xhwl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.xhwl.po.Group;
import com.xhwl.service.GroupService;

@RequestMapping(value="group")
@Controller
public class GroupController extends BaseController{
    //注入service
    @Autowired
    private GroupService groupService;

    /**
     * 跟具id查询Group
     * @param id
     * @return
     */
    //@Auth(checkGroupLogin=true,checkAdminLogin=true)
    @RequestMapping("/{groupId}")        //请求路径占位符映射
    public ResponseEntity<Group> getGroupById(@PathVariable("groupId")int id){
        Group group = groupService.queryGroupById(id);
        return this.sendToClient(group);
    }
    
    @RequestMapping("/rest/querygroup")
    @ResponseBody
    public ResponseEntity<List<Group>> getGroupByIdRest(){
    	try{
    	List<Group> group = groupService.queryGroup(1);
            return  ResponseEntity.ok(group);
        }catch(Exception e){
            e.printStackTrace();
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        
    }
    @RequestMapping("/rest/querygroup4")
    @ResponseBody
    public ResponseEntity<List<Group>> getGroup4(){
        try{
            List<Group> group = groupService.queryGroup4(1);
            return  ResponseEntity.ok(group);
        }catch(Exception e){
            e.printStackTrace();
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        
    }
    @RequestMapping("/rest/querygroup5")
    @ResponseBody
    public ResponseEntity<Group> getGroup5(){
        try{
            Group group = groupService.queryGroup5(1);
            System.out.println(group.toString());
            return ResponseEntity.ok(group);
            
        }catch(Exception e){
            e.printStackTrace();
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        
    }
    
    @RequestMapping("/bypage/{pageNum}/{pageSize}")
    @ResponseBody
    public ResponseEntity<List<Group>> getGroupByPage( @PathVariable("pageNum")int pageNum,@PathVariable("pageSize")int pageSize){
        try{
            System.out.println("=========="+pageNum+"\t"+pageSize+"==========");
            List<Group> list = groupService.queryByPage(pageNum, pageSize);
            return  ResponseEntity.ok(list);
        }catch(Exception e){
            e.printStackTrace();
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        
    }
    @RequestMapping("/bypagehelper/{pageNum}/{pageSize}")
    @ResponseBody
    public ResponseEntity<PageInfo<Group>> getGroupByPageHelper( @PathVariable("pageNum")int pageNum,@PathVariable("pageSize")int pageSize){
        try{
            System.out.println("=========="+pageNum+"\t"+pageSize+"==========");
            PageInfo<Group> pageInfo = groupService.queryByPageInfo(null, pageNum, pageSize);
            return ResponseEntity.ok(pageInfo);
        }catch(Exception e){
            e.printStackTrace();
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        
    }
    
    /*@RequestMapping("/num/{num}")
    @ResponseBody
    public ResponseEntity<Group> getGroupByNumRest(@PathVariable("num")int num){
        try{
            Group group = groupService.queryGroupByNum(num);
            return  ResponseEntity.ok(group);
        }catch(Exception e){
            e.printStackTrace();
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
    @RequestMapping(value="/update" ,method=RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Group> updateGroup(Group group){//@RequestBody 
        try{
//            group = new Group();
//            group.setId(1);
//            group.setNum(1);
//            group.setTitle("标题1");
//            group.setImagePath("图片路径1");
//            group.setImageName("图片名1");
            groupService.updateGroup(group);
            return  ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }catch(Exception e){
            e.printStackTrace();
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    
    @RequestMapping(value="/delete" ,method=RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Group> deleteGroupById(@PathVariable("id")int id){
        try{
            groupService.deleteGroupById(id);
            return  ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }catch(Exception e){
            e.printStackTrace();
            return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }*/
    
    
    
}
