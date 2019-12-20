package com.varzac.util;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;


/** SMTP 서버를 통해 이메일을 발송하는 클래스
 *  @author 방영호
 * */
public class EmailSender
{
	/** Spring framework에서 지원하는 메일 발송 처리 클래스에 대한 객체 */
	private JavaMailSender javaMailSender;
	
	/** Log를 기록하는 클래스에 대한 객체 */
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	/** EmailSender 객체를 초기화하는 생성자<br/>
	 *  메일 발송 처리를 담당하는 객체를 인자로 받음.
	 *  @param javaMailSender : Spring framework에서 지원하는 메일 발송 처리 클래스에 대한 객체
	 * */
	public EmailSender(JavaMailSender javaMailSender)
	{
		this.javaMailSender = javaMailSender;
	}
	
	/** 이메일 발송
	 *  @param from : 메일을 보내는 사람의 주소
	 *  @param to : 메일을 받는 사람의 주소
	 *  @param title : 메일 제목
	 *  @param contents : 메일 본문 내용
	 *  @param cc : 메일 참조자
	 *  @return true : 메일 발송 성공, false : 메일 발송 실패
	 *  @throws MessagingException */
	public boolean sendEmail(String from, String to, String subject, String contents, String cc[]) 
	{
		try
		{
			MimeMessage message = this.javaMailSender.createMimeMessage();
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "utf-8");
			
			messageHelper.setSubject(subject);
			messageHelper.setText(contents, true);
			messageHelper.setFrom(from);
			messageHelper.setTo(to);
			
			if(cc != null && cc.length > 0)
			{
				messageHelper.setCc(cc);
			}
			
			this.javaMailSender.send(message);
			
			return true;
		}
		catch(MessagingException e)
		{
			this.logger.error(e.getMessage(), e);
			return false;
		}
	}
}
