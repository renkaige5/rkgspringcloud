package com.rkg.springcloud.services;

import com.rkg.springcloud.entities.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;



/**
 * 
 * @Description: 修改rkgspringcloud-api工程，根据已经有的DeptClientService接口

新建

一个实现了FallbackFactory接口的类DeptClientServiceFallbackFactory
 * @author zzyy
 * @date 2018年4月21日
 */
//@FeignClient(value = "RKGSPRINGCLOUD-DEPT")
@FeignClient(value = "RKGSPRINGCLOUD-DEPT",fallbackFactory=DeptClientServiceFallbackFactory.class)
public interface DeptClientService
{
	@RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
	public Dept get(@PathVariable("id") long id);

	@RequestMapping(value = "/dept/list", method = RequestMethod.GET)
	public List<Dept> list();

	@RequestMapping(value = "/dept/add", method = RequestMethod.POST)
	public boolean add(Dept dept);
}
