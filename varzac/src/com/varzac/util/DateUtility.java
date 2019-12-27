package com.varzac.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.joda.time.Interval;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.springframework.beans.factory.annotation.Value;

public class DateUtility
{
	
	@Value("#{config['system.session.attrNameForNowDate']}")
	private String attrNameForNowDate;
	
	/** 몇 달 전 날짜 가져 오기
	 *  @param mon    개월 수, 해당 개월 수 이전의 날짜를 가져온다.
	 *  @param format 문자열로 출력할 날짜 형식
	 *  @return
	 */
	public static String getMinusMonth(int mon, String format)
	{
		Calendar sDay = Calendar.getInstance();
		sDay.add(Calendar.MONTH, mon);
		Date monthago = sDay.getTime();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);

		return simpleDateFormat.format(monthago);
	}

	/** 현재일 기준 특정날짜 사이남은 기간 년, 월, 일, 시, 분, 초 리턴
	 *  @param1 formatDate : 시작일(yyyy-MM-dd HH:mm:ss)
	 *  @param2 formatDate : 테스트 현재 날짜(yyyy-MM-dd HH:mm:ss)
	 *  @return 잔여 시간 정보가 포함된 맵
	 *  @throws java.text.ParseException
	 */
	public Map<String, Object> getPeriodPartOfFullDateTime(String formatDate, Date testDate) throws ParseException
	{
		Map<String, Object> timeMap = new HashMap<String, Object>();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

		Date now = Calendar.getInstance().getTime();
		Date endDate = simpleDateFormat.parse(formatDate);

		// 테스트를 위한 전달된 파라미터
		if (testDate != null) {
			now = testDate;
		}

		boolean periodIsBefore = now.compareTo(endDate) < 0 ? true : false;

		int periodYear = 0;
		int periodMonth = 0;
		int periodDay = 0;
		int periodHour = 0;
		int periodMinute = 0;
		int periodSecond = 0;
		int periodMilSecond = 0;

		if (periodIsBefore)
		{
			Interval interval = new Interval(now.getTime(), endDate.getTime());
			Period period = interval.toPeriod(PeriodType.yearMonthDayTime());
			periodYear = period.getYears();
			periodMonth = period.getMonths();
			periodDay = period.getDays();
			periodHour = period.getHours();
			periodMinute = period.getMinutes();
			periodSecond = period.getSeconds();
			periodMilSecond = period.getMillis();
		}

		timeMap.put("periodIsBefore", periodIsBefore);
		timeMap.put("periodYear", periodYear);
		timeMap.put("periodMonth", periodMonth);
		timeMap.put("periodDay", periodDay);
		timeMap.put("periodHour", periodHour);
		timeMap.put("periodMinute", periodMinute);
		timeMap.put("periodSecond", periodSecond);
		timeMap.put("periodMilSecond", periodMilSecond);

		return timeMap;
	}

	/** HTTP 세션을 통해서 현재 시간 정보를 가져오는 메소드 <br>
	 *  세션에 현재 시간 정보가 저장되어 있는 경우 해당 시간을 가져오고, <br>
	 *  세션에 현재 시간 정보가 없을 경우 시스템의 현재 시간을 가져온다.
	 *  @param session HttpSession 객체
	 *  @return 현재 시간을 반환
	 */
	public Date getNowByHttpSession(HttpSession session)
	{
		Date now = null;
		if(session != null && session.getAttribute(this.attrNameForNowDate) != null) {
			now = (Date)session.getAttribute(this.attrNameForNowDate);
		} else {
			now = Calendar.getInstance().getTime();
		}
		return now;
	}
	
	/**
	 * 포멧팅된 현재시간을 문자열 형태로 리턴
	 * 
	 * @param format 포메팅 문자열
	 * @return 포멧팅된 현재시간을 문자열 형태로 반환 
	 */
	public String getCurrentDate(String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
    	Date date = new Date();
    	return sdf.format(date);
	}
}