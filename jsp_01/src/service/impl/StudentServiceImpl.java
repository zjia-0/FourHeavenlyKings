package service.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import dao.IStudentDao;
import dao.impl.StudentDaoImpl;
import entity.goods;
import entity.goodsClass;
import service.IStudentService;

public class StudentServiceImpl implements IStudentService {
	IStudentDao dao=new StudentDaoImpl();
	@Override
	public List<goods> query() {
		return dao.query();
	}

	@Override
	public int upd(goods gs) {
		return dao.upd(gs);
	}

	@Override
	public int del(int id) {
		return dao.del(id);
	}

	@Override
	public int insert(goods gs) {
		return dao.insert(gs);
	}

	@Override
	public goods query(int id) {
		return dao.query(id);
	}

	@Override
	public List<goodsClass> nameQuery() {
		return dao.nameQuery();
	}

	@Override
	public goodsClass nameQuery(int id) {
		return dao.nameQuery(id);
	}
		
}
