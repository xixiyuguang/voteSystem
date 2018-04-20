package com.zqq.file;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase.FileSizeLimitExceededException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.zq.po.Candidate;
import com.zq.service.CandidateService;

 

public class UploadServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
			response.setContentType("text/html;charset=utf-8");
			
			String name=null;
			String sex = null;
			int age = 0;
			String address = null;
			String uuidName = null;  //文件名 image
			String introduce = null;
			CandidateService  service = new CandidateService();
			
		try{
			 
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(100*1024);
			factory.setRepository(new File(this.getServletContext().getRealPath("WEB-INF/temp")));
			 
			ServletFileUpload fileUpload = new ServletFileUpload(factory);
			

			if(!fileUpload.isMultipartContent(request)){
				throw new RuntimeException("显示");
			}
			
//			fileUpload.setFileSizeMax(1024*1024*100);//10M
//			fileUpload.setSizeMax(1024*1024*100);	
			fileUpload.setHeaderEncoding("utf-8");			
			
			fileUpload.setProgressListener(new ProgressListener(){
				Long beginTime = System.currentTimeMillis();
				public void update(long bytesRead, long contentLength, int items) {
					BigDecimal br = new BigDecimal(bytesRead).divide(new BigDecimal(1024),2,BigDecimal.ROUND_HALF_UP);
					BigDecimal cl = new BigDecimal(contentLength).divide(new BigDecimal(1024),2,BigDecimal.ROUND_HALF_UP);
					System.out.print(""+items+""+cl+""+br+"KB");
					 
					BigDecimal ll = cl.subtract(br);
					System.out.print(""+ll+"KB");
					 
					BigDecimal per = br.multiply(new BigDecimal(100)).divide(cl,2,BigDecimal.ROUND_HALF_UP);
					System.out.print(""+per+"%");
					 
					Long nowTime = System.currentTimeMillis();
					Long useTime = (nowTime - beginTime)/1000;
					System.out.print(""+useTime+"");
					 
					BigDecimal speed = new BigDecimal(0);
					if(useTime!=0){
						speed = br.divide(new BigDecimal(useTime),2,BigDecimal.ROUND_HALF_UP);
					}
					System.out.print("sudu"+speed+"KB/S");
					 
					BigDecimal ltime = new BigDecimal(0);
					if(!speed.equals(new BigDecimal(0))){
						ltime = ll.divide(speed,0,BigDecimal.ROUND_HALF_UP);
					}
					System.out.print(""+ltime+"");
					
					System.out.println();
				}
				
			});
			
			 
			List<FileItem> list = fileUpload.parseRequest(request);
			  
			for(FileItem item : list){
				if(item.isFormField()){
					 
					String name1 = item.getFieldName();
					String value = item.getString("utf-8");
					System.out.println(name1+":"+value);
					 if(name1.equals("name")){      
                         name = value;  
                         continue;      
					 }else if(name1.equals("sex")){      
                        sex = value;     
                        continue;      
					 }else if(name1.equals("age")){      
                         age = Integer.parseInt(value) ;
                        continue;      
					 } 
					 else if(name1.equals("address")){      
						 address = value ;
                        continue;      
					 }   
					 else if(name1.equals("introduce")){      
						 introduce = value ;
						 continue;      
					 }  
					 
					System.out.println(name1+":"+value);
				}else{
					String filename = item.getName();
					String extension = filename.substring(filename.lastIndexOf(".")+1);//hou zhui
					
					System.out.println(extension);					
					System.out.println(filename);					
					//String uuidName = UUID.randomUUID().toString();//+"_"+filename; 
					uuidName = UUID.randomUUID().toString()+"_."+extension; //文件名
					// 	generate the name in  websapp
					System.out.println(uuidName);
					
					//for create a path
					int hash = uuidName.hashCode();
					String hashStr = Integer.toHexString(hash);  //
					char [] hss = hashStr.toCharArray();
					//String path = this.getServletContext().getRealPath("WEB-INF/upload");
					String path = this.getServletContext().getRealPath("files/images");
					
//					for(char c : hss){
//						path+="/"+c;
//					}
					new File(path).mkdirs();
					
					InputStream in = item.getInputStream();
					OutputStream out = new FileOutputStream(new File(path,uuidName));
					
					IOUtils.In2Out(in, out);
					IOUtils.close(in, out);
					item.delete();
				}
			}
		}catch (FileSizeLimitExceededException e) {
			response.getWriter().write("zheli ");
			return;  //
			//request.setAttribute("msg", "");
			//request.getRequestDispatcher("/login.jsp").forward(request, response);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	
		System.out.println("name"+name);
		Candidate candidate = new Candidate();
		candidate.setName(name);
		candidate.setSex(sex);
		candidate.setAge(age);
		candidate.setAddress(address);
		candidate.setIntroduce(introduce);
		//candidate.setImage(image);
		candidate.setImage(uuidName);
		candidate.setBallot(0);
		System.out.println(candidate.getIntroduce());
		Boolean b = service.addCandidate(candidate);
		if(b){
			System.out.println("add success");
		}
		//response.sendRedirect(request.getContextPath()+"/index.jsp");
		//response.sendRedirect(request.getContextPath()+"/index.jsp");
		response.getWriter().write("add success ! please wait a second! ");
		response.setHeader("refresh", "1;url="+request.getContextPath()+"/candidateList");
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

