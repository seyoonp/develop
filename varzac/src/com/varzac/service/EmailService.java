package com.varzac.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.varzac.util.EmailSender;

@Service
public class EmailService {

	@Autowired
	private EmailSender emailSender;
	
	public boolean sampleSendEmail(String custId,String fromEmail,String sendEmail,String subject) {
		
		try
		{
			//파라미터 유효성 처리
			if(custId == null || fromEmail == null || sendEmail == null || subject == null)
			{
				return false;
			}
			

			String contents = "구글 테스트 샘플 이메일 발송";
			String cc[] = null;
			
        	//이메일 발송 세팅
			/*
        	BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(Config.getString("system.root")+"/html/mailMemberJoin.html"),"UTF8"));
        	
        	String tempCnt = "";
        	while((tempCnt=in.readLine()) != null){
        		contents = contents +" "+ tempCnt;
        	}
        	contents = contents.replaceAll("#WEBID#", custId);
        	contents = contents.replaceAll("#BRONZE#", custGradeName);
        	contents = contents.replaceAll("#HOST#", Config.getString("system.domain") + "/index.action");
        	contents = contents.replaceAll("#MEN#", Config.getString("system.domain") + "/product/subMain.action?cIdx=" + Config.getString("item.category.men.node"));
        	contents = contents.replaceAll("#WOMEN#", Config.getString("system.domain") + "/product/subMain.action?cIdx=" + Config.getString("item.category.women.node"));
        	contents = contents.replaceAll("#KIDS#", Config.getString("system.domain") + "/product/subMain.action?cIdx=" + Config.getString("item.category.kids.node"));
        	*/
			
	    	this.emailSender.sendEmail(fromEmail, sendEmail, subject, contents, cc);
	    	
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
		
		return true;
		
	}
}