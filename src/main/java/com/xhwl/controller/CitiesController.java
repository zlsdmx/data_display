package com.xhwl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xhwl.annotation.Auth;
import com.xhwl.po.Cities;
import com.xhwl.service.CitiesService;

@RestController
@RequestMapping(value="cities")
@Controller
public class CitiesController extends BaseController{

	//注入service
	@Autowired
	private CitiesService citiesService;
		
	 /**
     * 跟具id查询cities
     * @param id
     */
    @Auth(checkUserLogin=true,checkAdminLogin=true)
    @RequestMapping("/{citiesId}")        //请求路径占位符映射
    public ResponseEntity<?> getCitiesById(@PathVariable("citiesId")int id) throws Exception{
        Cities cities = citiesService.queryCitiesById(id);
        System.out.println("hello jrebel!");
        return this.sendToClient(cities);
    }
	
}
