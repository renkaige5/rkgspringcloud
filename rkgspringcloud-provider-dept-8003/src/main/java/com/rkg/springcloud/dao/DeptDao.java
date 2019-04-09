package com.rkg.springcloud.dao;

import java.util.List;

import com.rkg.springcloud.entities.Dept;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface DeptDao
{
	public boolean addDept(Dept dept);

	public Dept findById(Long id);

	public List<Dept> findAll();
}
