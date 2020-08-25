package com.pms.dao;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.pms.dto.ManagerBean;
import com.pms.util.DBConnectionMgr;






public class ManagerDAO {
		
		DBConnectionMgr pool = DBConnectionMgr.getInstance();
		
		//�����ͺ��̽��� �ѻ���� ȸ�� ������ �������ִ� �޼ҵ�
		public void insertManager(ManagerBean mbean) {
			Connection con = null;
			PreparedStatement pstmt = null;			
			
			try{
				con = pool.getConnection();
				//������ �������� �غ��Ͽ�..
				String sql = "insert into pms_admin values(?,?,?,?,?)";
				//������ ����ϵ��� ����
				pstmt = con.prepareStatement(sql); //jsp���� ������ ����ϵ��� ����
				
				// ?�� �°� �����͸� ����
				pstmt.setString(1, mbean.getId());
				pstmt.setString(2, mbean.getPass());
				pstmt.setString(3, mbean.getName());
				pstmt.setString(4, mbean.getEmail());
				pstmt.setString(5, mbean.getTel());
				
				
				// ����Ŭ���� ������ �����Ͻÿ�
				pstmt.executeUpdate();//insert, update, delete �� ����ϴ� �޼ҵ�	
				
				//�ڿ� �ݳ�
				con.close();
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
		
		
		//��񿡼� �Ƶ� ����� ã�ƿ� �α���â�� �ۼ��ѰŶ� ������ �α���~
		public int loginManager(String id, String pwd) {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String sql = "select admin_id,pwd from pms_admin where admin_id=?";
			String db_pwd;
			int re = -1;
			try{
				con = pool.getConnection();
				
			
				pstmt = con.prepareStatement(sql); //jsp���� ������ ����ϵ��� ����
				pstmt.setString(1, id);
				rs=pstmt.executeQuery();
				
				
				if(rs.next()) {
					
					db_pwd = rs.getString("PWD");
					
					if(db_pwd.equals(pwd)) {
						re=1;
					}else {
						re=0;
					}
				}else {
					re=-1;
				}
				
				rs.close();
				pstmt.close();
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			
			return re;
			
		}
		
		
		public String MdSearchId(ManagerBean idbean) {
			
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String id = "";
			String sql = "select admin_id from pms_admin where name=? and email=? and phone=?";
			
			try{
				con = pool.getConnection();
				
			
				pstmt = con.prepareStatement(sql); //jsp���� ������ ����ϵ��� ����
				pstmt.setString(1, idbean.getName());
				pstmt.setString(2, idbean.getEmail());
				pstmt.setString(3, idbean.getTel());
				rs=pstmt.executeQuery();
				if(rs.next()) {
					id = rs.getString(1);
				}else {
					id = "����";
				}
				
				
				rs.close();
				pstmt.close();
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			return id;
			
			
		}
		
public String MdSearchPass(ManagerBean passbean) {
			
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String pass = "";
			String sql = "select pwd from pms_admin where name=? and admin_id=? and email=? and phone=?";
			
			try{
				con = pool.getConnection();
				
			
				pstmt = con.prepareStatement(sql); //jsp���� ������ ����ϵ��� ����
				pstmt.setString(1, passbean.getName());
				pstmt.setString(2, passbean.getId());
				pstmt.setString(3, passbean.getEmail());
				pstmt.setString(4, passbean.getTel());
				rs=pstmt.executeQuery();
				if(rs.next()) {
					pass = rs.getString(1);
				}else {
					pass = "����";
				}
				
				
				rs.close();
				pstmt.close();
				con.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			return pass;
			
			
		}
		
	

}




























