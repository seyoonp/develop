package com.varzac.util;


public class CodeUtility 
{
	
	/** 상품 상태 코드를 코드명으로 조회
	 *  주문 Pay VO 와 Map 미 사용 처리위한 넘어온 코드값에 대응되는 코드명으로 조회 
	 *  @param payMethod
	 * */
	public String getApplcationProductStatusName(String applcationProductStatus)
	{
		String applcationProductStatusName = null;

		switch (applcationProductStatus) {
			case "1600100":
				applcationProductStatusName = "미개봉";
				break;
			case "1600110":
				applcationProductStatusName = "개봉후정상";
				break;	
			case "1600120":
				applcationProductStatusName = "개봉후이상";
				break;	
			case "1600130":
				applcationProductStatusName = "파손";
				break;
			default:
				applcationProductStatusName = "";
				break;
		}
		
		return applcationProductStatusName;
	}
	
	/** 신청사유 코드를 코드명으로 조회
	 *  주문 Pay VO 와 Map 미 사용 처리위한 넘어온 코드값에 대응되는 코드명으로 조회 
	 *  @param payMethod
	 * */
	public String getApplicationReasonName(String applicationReasonCode)
	{
		String applicationReasonCodeName = null;

		switch (applicationReasonCode) {
			case "1500100":
				applicationReasonCodeName = "고객변심";
				break;
			case "1500110":
				applicationReasonCodeName = "디자인 불만";
				break;
			case "1500120":
				applicationReasonCodeName = "사이즈 불만";
				break;
			case "1500130":
				applicationReasonCodeName = "제품 손상";
				break;
			case "1500140":
				applicationReasonCodeName = "제품 오염";
				break;
			case "1500150":
				applicationReasonCodeName = "접착 불량";
				break;
			case "1500180":
				applicationReasonCodeName = "잘못 등록";
				break;
			case "1500190":
				applicationReasonCodeName = "장식 불량";
				break;
			default:
				applicationReasonCodeName = "";
				break;
		}
		
		return applicationReasonCodeName;
	}
	
	
	/** 결제방법 코드를 코드명으로 구하는 메소드
	 *  @param payMethod 코드
	 *  @return 코드명 반환
	 * */
	public String getPayMethodName(String payMethod)
	{
		String payMethodName = null;

		switch (payMethod) {
			// 신용카드
			case "1100120":
				payMethodName = "카드결제";
				break;
			// 실계좌이체
			case "1100100":
				payMethodName = "실시간계좌이체";
				break;
			// 가상계좌(무통장)
			case "1100110":
				payMethodName = "가상계좌결제";
				break;
			default:
				payMethodName = "";
				break;
		}
		
		return payMethodName;
	}
	
    /** 상세코드의 코드명을 구하는 메소드
	 *  @param dtlCode 상세코드
	 *  @return 코드명 반환
	 * */
    public String getDtlCodeName(String dtlCode)
	{
		String dtlCodeName = null;
		
		if(dtlCode != null)
		{
			if(dtlCode.equals("1000100")) dtlCodeName = "결제대기";
			else if(dtlCode.equals("1000200")) dtlCodeName = "입금대기";
			else if(dtlCode.equals("1000290")) dtlCodeName = "입금완료";
			else if(dtlCode.equals("1000360")) dtlCodeName = "배송준비중";
			else if(dtlCode.equals("1000370")) dtlCodeName = "배송중";
			else if(dtlCode.equals("1000390")) dtlCodeName = "배송완료";
			else if(dtlCode.equals("1000410")) dtlCodeName = "교환철회";
			else if(dtlCode.equals("1000430")) dtlCodeName = "교환신청";
			else if(dtlCode.equals("1000440")) dtlCodeName = "교환승인";
			else if(dtlCode.equals("1000450")) dtlCodeName = "교환확인";
			else if(dtlCode.equals("1000460")) dtlCodeName = "교환배송준비중";
			else if(dtlCode.equals("1000470")) dtlCodeName = "교환배송중";
			else if(dtlCode.equals("1000490")) dtlCodeName = "교환완료";
			else if(dtlCode.equals("1000510")) dtlCodeName = "반품철회";
			else if(dtlCode.equals("1000530")) dtlCodeName = "반품신청";
			else if(dtlCode.equals("1000540")) dtlCodeName = "반품승인";
			else if(dtlCode.equals("1000550")) dtlCodeName = "반품확인";
			else if(dtlCode.equals("1000590")) dtlCodeName = "반품완료";
			else if(dtlCode.equals("1000610")) dtlCodeName = "취소철회";
			else if(dtlCode.equals("1000630")) dtlCodeName = "취소신청";
			else if(dtlCode.equals("1000690")) dtlCodeName = "취소완료";
			else if(dtlCode.equals("1000790")) dtlCodeName = "미입금취소완료";
			else if(dtlCode.equals("1000800")) dtlCodeName = "구매확인";
			
			else if(dtlCode.equals("1100100")) dtlCodeName = "실시간계좌이체";
			else if(dtlCode.equals("1100110")) dtlCodeName = "가상계좌결제";
			else if(dtlCode.equals("1100120")) dtlCodeName = "카드결제(ISP)";
			else if(dtlCode.equals("1100130")) dtlCodeName = "카드결제(안심결제)";
			else if(dtlCode.equals("1100140")) dtlCodeName = "휴대폰결제";
			else if(dtlCode.equals("1100150")) dtlCodeName = "마일리지";
			else if(dtlCode.equals("1100160")) dtlCodeName = "무료쿠폰결제";
			
			else if(dtlCode.equals("1200100")) dtlCodeName = "전체취소";
			else if(dtlCode.equals("1200110")) dtlCodeName = "전체교환";
			else if(dtlCode.equals("1200120")) dtlCodeName = "전체반품";
			else if(dtlCode.equals("1200130")) dtlCodeName = "부분취소";
			else if(dtlCode.equals("1200140")) dtlCodeName = "부분교환";
			else if(dtlCode.equals("1200150")) dtlCodeName = "부분반품";
			
			else if(dtlCode.equals("1500100")) dtlCodeName = "고객변심";
			else if(dtlCode.equals("1500110")) dtlCodeName = "디자인 불만";
			else if(dtlCode.equals("1500120")) dtlCodeName = "사이즈 불만";
			else if(dtlCode.equals("1500130")) dtlCodeName = "제품 손상";
			else if(dtlCode.equals("1500140")) dtlCodeName = "제품 오염";
			else if(dtlCode.equals("1500150")) dtlCodeName = "접착 불량";
			else if(dtlCode.equals("1500160")) dtlCodeName = "자동취소";
			else if(dtlCode.equals("1500170")) dtlCodeName = "품절";
			else if(dtlCode.equals("1500180")) dtlCodeName = "잘못 등록";
			
			else if(dtlCode.equals("1600100")) dtlCodeName = "미개봉";
			else if(dtlCode.equals("1600110")) dtlCodeName = "개봉 후 정상";
			else if(dtlCode.equals("1600120")) dtlCodeName = "개봉 후 이상";
			else if(dtlCode.equals("1600130")) dtlCodeName = "파손";
			
			else if(dtlCode.equals("1800100")) dtlCodeName = "환불대기";
			else if(dtlCode.equals("1800110")) dtlCodeName = "환불접수";
			else if(dtlCode.equals("1800120")) dtlCodeName = "환불완료";
			
			else if(dtlCode.equals("1900101")) dtlCodeName = "산업은행";
			else if(dtlCode.equals("1900102")) dtlCodeName = "기업은행";
			else if(dtlCode.equals("1900103")) dtlCodeName = "외환은행";
			else if(dtlCode.equals("1900104")) dtlCodeName = "국민은행";
			else if(dtlCode.equals("1900105")) dtlCodeName = "수협";
			else if(dtlCode.equals("1900106")) dtlCodeName = "농협";
			else if(dtlCode.equals("1900107")) dtlCodeName = "우리은행";
			else if(dtlCode.equals("1900108")) dtlCodeName = "SC제일은행";
			else if(dtlCode.equals("1900109")) dtlCodeName = "한국씨티";
			else if(dtlCode.equals("1900110")) dtlCodeName = "대구은행";
			else if(dtlCode.equals("1900111")) dtlCodeName = "부산은행";
			else if(dtlCode.equals("1900112")) dtlCodeName = "광주은행";
			else if(dtlCode.equals("1900113")) dtlCodeName = "제주은행";
			else if(dtlCode.equals("1900114")) dtlCodeName = "전북은행";
			else if(dtlCode.equals("1900115")) dtlCodeName = "경남은행";
			else if(dtlCode.equals("1900116")) dtlCodeName = "새마을금고";
			else if(dtlCode.equals("1900117")) dtlCodeName = "신협";
			else if(dtlCode.equals("1900118")) dtlCodeName = "우체국";
			else if(dtlCode.equals("1900119")) dtlCodeName = "하나은행";
			else if(dtlCode.equals("1900120")) dtlCodeName = "신한은행";
			else if(dtlCode.equals("1900121")) dtlCodeName = "카카오뱅크";
			
			else if(dtlCode.equals("1910100")) dtlCodeName = "현대택배";
			else if(dtlCode.equals("1910101")) dtlCodeName = "우체국택배";
			else if(dtlCode.equals("1910102")) dtlCodeName = "옐로우택배";
			else if(dtlCode.equals("1910103")) dtlCodeName = "한진택배";
			else if(dtlCode.equals("1910104")) dtlCodeName = "훼미리택배";
			else if(dtlCode.equals("1910105")) dtlCodeName = "로젠택배";
			else if(dtlCode.equals("1910106")) dtlCodeName = "삼성HTH";
			else if(dtlCode.equals("1910107")) dtlCodeName = "EMS";
			else if(dtlCode.equals("1910108")) dtlCodeName = "대한통운(미사용)";
			else if(dtlCode.equals("1910109")) dtlCodeName = "CJ대한통운";
			else if(dtlCode.equals("1910110")) dtlCodeName = "아주택배";
			else if(dtlCode.equals("1910111")) dtlCodeName = "일양택배";
			else if(dtlCode.equals("1910112")) dtlCodeName = "CVSNET";
			else if(dtlCode.equals("1910113")) dtlCodeName = "KGB택배";
			else if(dtlCode.equals("1910114")) dtlCodeName = "동부택배";
			else if(dtlCode.equals("1910115")) dtlCodeName = "건영택배";
			else if(dtlCode.equals("1910116")) dtlCodeName = "경동택배";
			else if(dtlCode.equals("1910117")) dtlCodeName = "천일택배";
			else if(dtlCode.equals("1910118")) dtlCodeName = "성화택배";
			else if(dtlCode.equals("1910119")) dtlCodeName = "롯데택배";
			else if(dtlCode.equals("1910120")) dtlCodeName = "KG로지스";
			
			else if(dtlCode.equals("210100")) dtlCodeName = "대기";
			else if(dtlCode.equals("210110")) dtlCodeName = "품절";
			else if(dtlCode.equals("210120")) dtlCodeName = "승인";
			else if(dtlCode.equals("210130")) dtlCodeName = "판매종료";
			else if(dtlCode.equals("210140")) dtlCodeName = "삭제상품";
		}
		
		return dtlCodeName;
	}
	
	/** 결제경로(결제환경) 구분값에 대한 명칭 조회
	 *  @param orderPath 결제경로 구분값
	 *  @return 결제경로 명칭 반환
	 * */
	public String getOrderPathName(String orderPath)
	{
		String orderPathName = null;
		
		if(orderPath != null)
		{
			if(orderPath.equalsIgnoreCase("W") ==true)
			{
				orderPathName = "PC";
			}
			else if(orderPath.equalsIgnoreCase("M") ==true)
			{
				orderPathName = "모바일웹";
			}
			else if(orderPath.equalsIgnoreCase("A") ==true)
			{
				orderPathName = "모바일APP(안드로이드)";
			}
			else if(orderPath.equalsIgnoreCase("I") ==true)
			{
				orderPathName = "모바일APP(아이폰)";
			}
		}
		
		return orderPathName;
	}
	
	/** 상품명을 통해 옵션명을 구하는 메소드
	 *   @param productName 상품명
	 *   @return 옵션명을 반환
	 * */
	public String getOrderProductOptionName(String productName)
	{
		String optionName = null;
		
		if(productName != null && productName.indexOf(",") != -1)
		{
			optionName = productName.substring(productName.indexOf(",") + 1);
		}
		
		return optionName;
	}
	
	/** 브랜드 코드의 코드명을 구하는 메소드
	 *  @param brandCode 브랜드 코드
	 *  @return 브랜드 코드명
	 * */
	public String getBrandCodeName(String brandCode)
	{
		String brandCodeName = null;
		
		if(brandCode != null)
		{
			if(brandCode.equalsIgnoreCase("NB")) brandCodeName = "성인";
			else if(brandCode.equalsIgnoreCase("NK")) brandCodeName = "키즈";
		}
		
		return brandCodeName;
	}
}
