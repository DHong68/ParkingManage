package com.pms.command;
import java.io.File;
import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.pms.dao.PmsLogDao;
import com.pms.dto.PmsDto;

public class LoglmgModifyAction implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String savepath=request.getServletContext().getRealPath("/WEB-INF/views/img");
		int sizeLimit =300*200*15;
		com.pms.dao.PmsLogDao dao =PmsLogDao.getInstance();
		PmsDto dto =new PmsDto();
		MultipartRequest multi= new MultipartRequest(request, savepath, sizeLimit, "utf-8", new DefaultFileRenamePolicy());
		int idx=Integer.parseInt(multi.getParameter("idx"));
	    Enumeration fileNames=multi.getFileNames(); //���� �̸� ��ȯ //
        int update=0;
        boolean save= true;
        String fileInput="";//������ �޾ƿ� ���� �̸� 
        String fileName="";//����� ���� �̸�
        String originFileName="";
        String type="";//�̹��� Ÿ��
        File fileobj=null;//���� ��ü
        String fileExtend="";
        String filesize="";
        String newFileName ="log_"+System.currentTimeMillis();//�ٲ��̸�
        System.out.println("newFileName:"+newFileName);
      
        while(fileNames.hasMoreElements()) {
        	fileInput =(String)fileNames.nextElement();
        	fileName=multi.getFilesystemName(fileInput);
        	fileobj=multi.getFile(fileInput);
        	originFileName =multi.getOriginalFileName(fileInput);
        	fileExtend=fileName.substring(fileName.lastIndexOf(".")+1);//Ȯ����
        	filesize=String.valueOf(fileobj.length());
        	String[]splitType=type.split("/");
        	
        	if(splitType[0].equals("")) {
        		save=false;
        		fileobj.delete();
        		break;
        	}else {
        		newFileName +="."+fileExtend;
        		fileobj.renameTo(new File(savepath+"\\"+newFileName));    		
        	}	
        	
        }
        
		if(save) {
	
			
			
		}
	
		
		
		return null;
	}

}
