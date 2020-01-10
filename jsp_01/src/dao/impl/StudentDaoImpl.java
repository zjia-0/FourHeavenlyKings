package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.BaseDao;
import dao.IStudentDao;
import entity.goods;
import entity.goodsClass;

public class StudentDaoImpl extends BaseDao implements IStudentDao {

	@Override
	public List<goods> query() {
		String sql="SELECT g.goodsId,g.`goodsName`,c.`goodsClassName`,g.`goodsType`,g.`goodsPrice` FROM goods g,goodsClass c"
				+ " WHERE g.`goodsClassId`=c.`goodsClassId`;";
		List<goods> list=new ArrayList<>();
		ResultSet set=super.select(sql);
		try {
			while(set.next()) {
				goods gs=new goods(set.getString(1), set.getString(2), set.getString(3), set.getString(4), set.getString(5));
				list.add(gs);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			super.closeAll(set);
		}
		return list;
	}

	@Override
	public int upd(goods gs) {
		String sql="UPDATE goods g SET g.`goodsName`=?,g.`goodsClassId`=?,g.`goodsType`=?,g.`goodsPrice`=? WHERE g.`goodsId`=?";
		return super.All(sql, gs.getGoodsName(),gs.getClassName(),gs.getType(),gs.getPrice(),gs.getGoodsId());
	}

	@Override
	public int del(int id) {
		String sql="delete from goods where goodsId=?";
		return super.All(sql, id);
	}

	@Override
	public int insert(goods gs) {
		String sql="INSERT goods VALUES(NULL,?,?,?,?)";
		return super.All(sql, gs.getGoodsName(),gs.getType(),gs.getClassName(),gs.getPrice());
	}

	@Override
	public goods query(int id) {
		String sql="SELECT g.goodsId,g.`goodsName`,c.`goodsClassId`,g.`goodsType`,g.`goodsPrice` FROM goods g,goodsClass c"
				+ " WHERE g.`goodsClassId`=c.`goodsClassId` AND g.`goodsId`=?";
		ResultSet set= super.select(sql, id);
		try {
			if(set.next()) {
				goods gs=new goods(set.getString(1), set.getString(2), set.getString(3), set.getString(4), set.getString(5));
				return gs;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			super.closeAll(set);
		}
		return null;
	}

	@Override
	public List<goodsClass> nameQuery() {
		String sql="select * from goodsClass";
		ResultSet set=super.select(sql);
		List<goodsClass> list=new ArrayList<>();
		try {
			while(set.next()) {
				goodsClass gsC=new goodsClass(set.getString(1), set.getString(2));
				list.add(gsC);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public goodsClass nameQuery(int id) {
		String sql="select * from goodsClass where goodsClassId=?";
		ResultSet set=super.select(sql,id);
		try {
			while(set.next()) {
				goodsClass gsC=new goodsClass(set.getString(1), set.getString(2));
				return gsC;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
