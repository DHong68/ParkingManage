package com.pms.command;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class TestCommand implements Command{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {


		String path = request.getSession().getServletContext().getRealPath("fileUpload");
		File Folder = new File(path);

		// �ش� ���丮�� ������� ���丮�� �����մϴ�.
		if (!Folder.exists()) {
			try{
			    Folder.mkdir(); //���� �����մϴ�.
			    System.out.println("������ �����Ǿ����ϴ�.");
		        } 
		        catch(Exception e){
			    e.getStackTrace();
			}        
	         }else {
			System.out.println("�̹� ������ �����Ǿ� �ֽ��ϴ�.");
		}
		

		System.out.println("��� : " + path +"<br/>");
		
	    String subject ="";
		int maxSize =1024 *1024 *10;
		
		MultipartRequest multi =new MultipartRequest(request,path,maxSize,"utf-8",new DefaultFileRenamePolicy());
        
        String name = multi.getFilesystemName("fileName");


        String now = new SimpleDateFormat("yyyyMMddHmsS").format(new Date());  //����ð�
  
        File oldFile = new File(path + name);
        File newFile = new File(path + now);
       
        oldFile.renameTo(newFile); // ���ϸ� ����

		
        //File f = multi.getFile("fileName");
        
        return null;
		//return "stat/test";
	}
	
}
