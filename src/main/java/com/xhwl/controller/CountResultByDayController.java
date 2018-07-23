package com.xhwl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xhwl.annotation.Auth;
import com.xhwl.po.CountResultByDay;
import com.xhwl.service.CountResultByDayService;

@RestController
@RequestMapping(value = "CountByDay")
@Controller
public class CountResultByDayController extends BaseController {

	@Autowired
	private CountResultByDayService countResultByDayService;

//	@Auth(checkUserLogin=true,checkAdminLogin=true)
	@RequestMapping("/all")
	public ResponseEntity<List<CountResultByDay>> queryAll() {
		try {
			List<CountResultByDay> list = countResultByDayService.queryAll();
			return ResponseEntity.ok(list);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}
}
