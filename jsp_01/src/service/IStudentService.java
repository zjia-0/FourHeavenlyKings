package service;

import java.util.List;

import entity.goods;
import entity.goodsClass;

public interface IStudentService  {
	public List<goods> query();
	public int del(int id);
	public int upd(goods stu);
	public int insert(goods gs);
	public goods query(int id);
	public List<goodsClass> nameQuery();
	public goodsClass nameQuery(int id);
}
