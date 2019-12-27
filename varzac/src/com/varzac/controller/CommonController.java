package com.varzac.controller;

import java.io.File;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.varzac.service.CommonService;
import com.varzac.util.Util;
import com.varzac.vo.FileVo;

@Controller
public class CommonController {
	
	private static final Logger logger = LoggerFactory.getLogger(CommonController.class);
	
	@Autowired
	private CommonService commonService; 
	
	@Value("#{config['file.upload.path']}")
	private String fileUploadPath;

	/**
	 * 파일 업로드 컨트롤러 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/common/multiUpload", method=RequestMethod.POST, produces="text/plain")
    public ModelAndView multiUpload(MultipartHttpServletRequest request) throws Exception {
		
        // 응답용 객체를 생성하고, jsonView 를 사용하도록 합니다.
		ModelAndView model = new ModelAndView("jsonView");
		Iterator<String> iter =  request.getFileNames();
		Map<String, Object> json = new HashMap<String, Object>();
		
        if(iter.hasNext()) {
        	
        	// 단일 파일 업로드일 경우
        	// MultipartFile multipartFile = request.getFile(iter.next());
        	
            // 멀티 파일 업로드
            for(MultipartFile multipartFile : request.getFiles(iter.next())) {
            	
            	// 파일 정보 출력
            	logger.info(":: Original :: " +  multipartFile.getOriginalFilename());
            	logger.info(":: New :: " + multipartFile.getName());
            	logger.info(":: Size :: " +  multipartFile.getSize());
            	
            	// 파일 확장자
            	String fileExt = FilenameUtils.getExtension(multipartFile.getOriginalFilename()).toLowerCase();
            	
            	// 일자별 경로 만들고, 파일명 겹치지 않도록 리네임
    			String currentDate = Util.date.getCurrentDate("yyyyMMdd");
    			String currentFullDateTime = Util.date.getCurrentDate("YYYYMMddHHmmssSSS");
    			String saveFileName = currentFullDateTime + "." + fileExt;
    			String saveFilePath = fileUploadPath + "\\" + currentDate;
    			
                File file = new File(saveFilePath + "\\" + saveFileName);
                multipartFile.transferTo(file);
                
                // 파일전송 성공 이후, 파일 테이블에 관련 정보 등록
                FileVo fileVo = new FileVo();
                fileVo.setOrgFileName(multipartFile.getOriginalFilename());
                fileVo.setSaveFileName(saveFileName);
                fileVo.setSavePath(currentDate);
                commonService.insertFile(fileVo);
            }
            
            json.put("code", "true");
            model.addObject("result", json);
        } else {
            json.put("code", "false");
            model.addObject("result", json);
        }
        return model;
    }
	
	/**
	 * 파일 다운로드 컨트롤러
	 * 
	 * @param fileIdx 파일 데이터 고유값
	 * @param response 서버로부터 파일정보를 응답받을 객체
	 * @throws Exception
	 */
	@RequestMapping("/common/fileDownload/{fileIdx}")
	public void downloadFile(@PathVariable("fileIdx") int fileIdx, HttpServletResponse response) throws Exception {
		FileVo fileVo = commonService.selectFile(fileIdx);
        String orgFileName = fileVo.getOrgFileName();
        String savePath = fileVo.getSavePath();
        String saveFileName = fileVo.getSaveFileName();
        byte[] fileByte = FileUtils.readFileToByteArray(new File(fileUploadPath + "\\" + savePath + "\\" + saveFileName));
        
        // 웹서버는 브라우저로 전송될 페이지가 html 인경우 text/html을 표준 MIME 타입으로 지정합니다. 
        // 그러나 필요에 의해서 이 MIME 타입을 변경하고자 할 경우나 또는 캐릭터의 인코딩셋을 변경하고자 할때 
        // setContentType 메소드를 사용할 수 있습니다. octet-stream 이라는 놈은 이름 그대로 8비트 바이너리 배열을 의미하며 
        // http나 이메일상에서 application 형식이 지정되지 않았거나 형식을 모를때 사용합니다. 
        // 결국 브라우저는 octet-stream 으로 MIME 타입이 지정된 경우 단지 바이너리 데이터로서 다운로드만 가능하게 처리하게 됩니다.
        response.setContentType("application/octet-stream");
        response.setContentLength(fileByte.length);
        
        // Content-Disposition 속성을 이용하여 데이터의 형식을 지정할 수 있는데 attachment로 지정되어 있는데 첨부 파일을 말한다. 
        // 그 뒤에 fileName이라고 적혀있는 것은 다운로드 할 때 기본으로 적혀있던 파일 이름을 말한다. 
        // 그 뒤에 인코더 되있는 부분은 한글파일의 경우 UTF-8로 인코딩 되어 있지 않으면 깨진 이름으로 나오는데 이를 방지하기 위함이다. 
        // attachment;와 fileName 사이에는 띄워쓰기를 꼭 해주어야 하고 인코드하는 뒤 부분 "\" 부분도 꼭 써줘야 다운로드가 가능하다.
        response.setHeader("Content-Disposition", "attachment; fileName=\"" + URLEncoder.encode(orgFileName,"UTF-8")+"\";");
        // Content-Transfer-Encoding 는 전송되는 데이터의 안의 내용물들의 인코딩 방식을 말하며 여기에선 binary 방식을 택한 것이다.
        response.setHeader("Content-Transfer-Encoding", "binary");
        // 위에서 byte[] 타입으로 변환한 파일을 response를 통해 클라이언트로 보내준다.
        response.getOutputStream().write(fileByte);
        // response를 중지하고 닫아준다.
        response.getOutputStream().flush();
        response.getOutputStream().close();
	}
}