package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//���ݷ��ʲ�
public class BaseDao {
	private String user="root";
	private String pwd="123456";
	private String url="jdbc:mysql://localhost:3306/test";
	private String driver="com.mysql.jdbc.Driver";
	 
	 //���Ӷ���
	 Connection conn;
	 //Ԥ����
	 PreparedStatement pre;
	 
	 //���ӷ���
	 public void open(){		 
	 	try {
	 		//��������
			Class.forName(driver);
			//��������
			conn=DriverManager.getConnection(url, user, pwd);
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	 }
	//�ر�
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
	 //ͨ�õ���ɾ�ķ���
	 public int All(String sql,Object...obj){
		 int num=0;
		 //��������
		 	this.open();
		 //����
		 	try {
				pre=conn.prepareStatement(sql);
				//�������
				if (pre!=null) {
					for (int i = 0; i < obj.length; i++) {
						pre.setObject(1+i, obj[i]);
					}
				}
				//��������
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
	 //ͨ�õĲ�ѯ����
	 public ResultSet select(String sql,Object...obj){
		 //��������
		 this.open();
		 //����
		 try {
			pre=conn.prepareStatement(sql);
			//�������
			if (pre!=null) {
				for (int i = 0; i < obj.length; i++) {
					pre.setObject(1+i, obj[i]);
				}
			}
			//��������
			return pre.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return null;
	 }
}

