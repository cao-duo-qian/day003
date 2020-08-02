package com.xiaoshu.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaoshu.dao.DeviceMapper;
import com.xiaoshu.dao.TypeMapper;
import com.xiaoshu.entity.Device;
import com.xiaoshu.entity.DeviceVo;
import com.xiaoshu.entity.Type;

@Service
public class DeviceService {

	@Autowired
	DeviceMapper deviceMapper;
	
	@Autowired
	TypeMapper typeMapper;
	
	
	public List<Type> findType(){
		return typeMapper.selectAll();
	}

	
	public PageInfo<DeviceVo> findPage(DeviceVo deviceVo , Integer pageNum , Integer pageSize){
		PageHelper.startPage(pageNum, pageSize);
		List<DeviceVo> list = deviceMapper.findList(deviceVo);
		return new PageInfo<DeviceVo>(list);
	}
	public Device findByName(String deviceName){
		Device d = new Device();
		d.setDeviceName(deviceName);
		return deviceMapper.selectOne(d);
	}

	
	
	
	public void addDevice(Device device){
		device.setCreatetime(new Date());
		deviceMapper.insert(device);
	}
	
	public void updateDevice(Device device){
		deviceMapper.updateByPrimaryKeySelective(device);
	}
	public void deleteDevice(Integer deviceid){
		deviceMapper.deleteByPrimaryKey(deviceid);
	}
	
	public List<DeviceVo> countDevice(){
		return deviceMapper.CountDevice();
	}
	
	
}
