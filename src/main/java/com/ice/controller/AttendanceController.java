package com.ice.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.ice.service.ArticleService;
import com.ice.service.AttendanceService;
import com.ice.util.CommonUtil;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {


	 @Autowired
	    private AttendanceService attendanceService;

	    /**
	     * 查询文章列表
	     *
	     * @param request
	     * @return
	     */
	    @RequiresPermissions("attendance:list")
	    @GetMapping("/listAttendance")
	    public JSONObject listAttendance(HttpServletRequest request) {
	        return attendanceService.listAttendance(CommonUtil.request2Json(request));
	    }

	    /**
	     * 新增文章
	     *
	     * @param requestJson
	     * @return
	     */
	    @RequiresPermissions("attendance:add")
	    @PostMapping("/addAttendance")
	    public JSONObject addAttendance(@RequestBody JSONObject requestJson) {
	    	
	        CommonUtil.hasAllRequired(requestJson, "userName,remark");
	        return attendanceService.addAttendance(requestJson);
	    }

	    /**
	     * 修改文章
	     *
	     * @param requestJson
	     * @return
	     */
	    @RequiresPermissions("attendance:update")
	    @PostMapping("/updateAttendance")
	    public JSONObject updateArticle(@RequestBody JSONObject requestJson) {
	        CommonUtil.hasAllRequired(requestJson, "id,userName");
	        return attendanceService.updateAttendance(requestJson);
	    }
	
	
	
	
	
	
	
	
	
	
	
}
