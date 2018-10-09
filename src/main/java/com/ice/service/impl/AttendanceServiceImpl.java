package com.ice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.ice.dao.AttendanceDao;
import com.ice.service.AttendanceService;
import com.ice.util.CommonUtil;

@Service
public class AttendanceServiceImpl implements AttendanceService{

	@Autowired
	private AttendanceDao attendanceDao;
	
	
	
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public JSONObject addAttendance(JSONObject jsonObject) {
		attendanceDao.addAttendance(jsonObject);
	      return CommonUtil.successJson();
	}

	@Override
	public JSONObject listAttendance(JSONObject jsonObject) {
		 CommonUtil.fillPageParam(jsonObject);
	       int count = attendanceDao.countAttendance(jsonObject);
	        List<JSONObject> list = attendanceDao.listAttendance(jsonObject);
	        return CommonUtil.successPage(jsonObject, list, count);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public JSONObject updateAttendance(JSONObject jsonObject) {
		attendanceDao.updateAttendance(jsonObject);
        return CommonUtil.successJson();
	}

	
	
	
	
	
	
	
	
	
}
