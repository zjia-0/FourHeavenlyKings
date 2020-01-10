package com.accp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.accp.domain.Model;
import com.accp.mapper.ModelMapper;

@Service
@Transactional
public class modelService {

	@Autowired
	ModelMapper mm;
	
	public List<Model> query(Integer id){
		return mm.selectLevel(id);
	}
}
