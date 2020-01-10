package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//数据访问层
public class BaseDao {
	private String user="root";
	private String pwd="123456";
	private String url="jdbc:mysql://localhost:3306/test";
	private String driver="com.mysql.jdbc.Driver";
	 
	 //连接对象
	 Connection conn;
	 //预编译
	 PreparedStatement pre;
	 
	 //连接方法
	 public void open(){		 
	 	try {
	 		//加载驱动
			Class.forName(driver);
			//建立连接
			conn=DriverManager.getConnection(url, user, pwd);
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	 }
	//关闭
	 public void closeAll(ResultSet set){
		 if (set!=null) {
			try {
				set.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		 if(pre!=null){
			 try {
				pre.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 if (conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	 }
	 //通用的增删改方法
	 public int All(String sql,Object...obj){
		 int num=0;
		 //调用连接
		 	this.open();
		 //编译
		 	try {
				pre=conn.prepareStatement(sql);
				//代替参数
				if (pre!=null) {
					for (int i = 0; i < obj.length; i++) {
						pre.setObject(1+i, obj[i]);
					}
				}
				//输出结果集
				num=pre.executeUpdate();
				return num;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 	finally{
		 		this.closeAll(null);
		 	}
		 return -1;
	 }
	 //通用的查询方法
	 public ResultSet select(String sql,Object...obj){
		 //调用连接
		 this.open();
		 //编译
		 try {
			pre=conn.prepareStatement(sql);
			//代替参数
			if (pre!=null) {
				for (int i = 0; i < obj.length; i++) {
					pre.setObject(1+i, obj[i]);
				}
			}
			//输出结果集
			return pre.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return null;
	 }
}

