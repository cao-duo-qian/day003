package com.xiaoshu.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiaoshu.dao.DeviceMapper;
import com.xiaoshu.entity.Device;

@Service
public class DeviceService {

	@Autowired
	DeviceMapper deviceMapper;
	
	public PageInfo<Device> findPage(Device device , Integer pageNum , Integer pageSize){
		PageHelper.startPage(pageNum, pageSize);
		List<Device> list = deviceMapper.findList(device);
		return new PageInfo<Device>(list);
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
}
