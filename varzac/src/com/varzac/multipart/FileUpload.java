package com.varzac.multipart;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileUpload {
	
    private MultipartFile multipartFile;
    
    /** 파일 확장자명 */
    private String extension;
    
    /** 저장소에 저장된 물리적인 파일명 */
    private String saveFileName;
    
    /** 저장소에 저장된 섬네일의 물리적인 파일명 */
    private String[] saveThumbnailFilenames;
    
    /** 저장된 파일의 물리적인 경로 (S3의 경우 Key가 여기에 해당함) */
    private String saveFilePath;
    
    /** 저장소에 저장할 수 있는 최대 파일 크기 (단위 : 바이트) */
    private long max_size;
    
    /** 저장소에 저장 가능한 파일 종류 (MIME 타입의 집합)  */
    private Set<String> allowedTypesSet = Collections.emptySet();
    
    /** 저장소에 저장 가능한 파일 확장자명 목록 */
    private Set<String> allowedExtensionsSet = Collections.emptySet();
    
    /** 저장 가능한 파일의 종류를 체크할지 여부 
     *  @see UploadFile 클래스의 allowedTypesSet 맴버변수 참고*/
    private boolean type_check = true;
    
    /** 파일명을 자동으로 생성하기 위한 SimpleDateFormat 객체, 날짜데이터를 이용하여 파일명을 생성한다.  */
    private SimpleDateFormat sdf = null;

    public FileUpload(MultipartFile multipartFile) throws IOException {
        this.multipartFile = multipartFile;
        this.max_size = 0;
        this.extension = FilenameUtils.getExtension(multipartFile.getOriginalFilename()).toLowerCase();
        this.allowedExtensionsSet = new HashSet<String>();
        this.allowedTypesSet = new HashSet<String>();    
        this.sdf = new SimpleDateFormat("YYYYMMddHHmmssSSS");
    }
    
    /** 저장소에 저장될 파일명을 자동으로 생성하는 메소드
     *  @param bucketName S3 버킷 이름
     *  @param saveFilePath S3 버킨 내에 저장될 파일 경로  */
    private String generateSaveFileName(String bucketName, String saveFilePath)
    {
    	String saveFileFullPath = null;
    	String saveFileName = null;
    	int fileNumber = 1;
    	
//    	do
//    	{
//    		saveFileName = Config.getString("nb.brandcode") + this.sdf.format(Calendar.getInstance().getTime()) + String.format("%03d", fileNumber) + "." + this.getExtension();
//    		saveFileFullPath = saveFilePath + saveFileName;
//    		saveFileFullPath = saveFileFullPath.replaceAll("\\\\", "/").replaceAll("/{2,}", "/").replaceAll("^/", "").replaceAll("/$", "");
//    		
//    		fileNumber++;
//    	}
//    	while(this.isExistsFileInS3(bucketName, saveFileFullPath) == true);
//    	saveFileName = Config.getString("nb.brandcode") + this.sdf.format(Calendar.getInstance().getTime()) + String.format("%03d", fileNumber) + "." + this.getExtension();
    	
    	saveFileName = this.sdf.format(Calendar.getInstance().getTime()) + String.format("%03d", fileNumber) + "." + this.extension;
		saveFileFullPath = saveFilePath + saveFileName;
		saveFileFullPath = saveFileFullPath.replaceAll("\\\\", "/").replaceAll("/{2,}", "/").replaceAll("^/", "").replaceAll("/$", "");
		fileNumber++;
    	return saveFileName;
    }
}