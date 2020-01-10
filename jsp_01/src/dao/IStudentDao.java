package dao;

import java.util.List;

import entity.goods;
import entity.goodsClass;

public interface IStudentDao {
	public List<goods> query();
	public goods query(int id);
	public int del(int id);
	public int upd(goods gs);
	public int insert(goods gs);
	public List<goodsClass> nameQuery();
	public goodsClass nameQuery(int id);
}
