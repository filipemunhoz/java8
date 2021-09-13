package br.com.dates;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class WorkingDates {
	
	private final static String LOGON = "LOGON";

	public static void main(String[] args) throws InterruptedException {
		new WorkingDates().executa();
	}

	private void executa() throws InterruptedException {
		
		SimilityCache cache = new SimilityCache();
		cache.setKey("123456789");
		
		
		for(int i=0; i < 15; i++) {			
			SimilityEntity entity = new SimilityEntity();
			entity.setContextCode(LOGON);		
			entity.setDateTime(LocalDateTime.now());
			
			cache.entities.add(entity);
			Thread.sleep((long)(Math.random() * 10E+2));
			System.out.println("Adding: " + i);
		}
		
		
		cache.getEntities().forEach(s -> {
			System.out.println("####" + s.getDateTime().getHour() + ":" + s.getDateTime().getMinute() + ":" + s.getDateTime().getSecond());
		});
		
		SimilityEntity s = cache.getEntities().stream()
				  .sorted(Comparator.comparing(SimilityEntity::getDateTime).reversed())
				  .collect(Collectors.toList())
				  .get(0);
		
		LocalDateTime aaa = s.getDateTime();
		System.out.println(aaa.getHour() + ":" + aaa.getMinute() + ":" + aaa.getSecond());
		
		
//		for (LocalDateTime d: entity.getDateTime()) {
//			System.out.println(d.getHour() + ":" + d.getMinute() + ":" + d.getSecond());
//		}
		
//		LocalDateTime datetie = Collections.max(entity.getDateTime());
//		System.out.println("ocaldateTime: " + datetie.getHour() + ":" + datetie.getMinute() + ":" + datetie.getSecond());
//		
//		String ad = entity.getDateTime()
//					.stream().max(Comparator.naturalOrder()).map(d -> d.getHour() + ":" + d.getMinute() + ":" + d.getSecond()).toString();
//		
//		System.out.println("ad: " + ad);
//		
//		String aa = entity.getDateTime().stream()
//	    					.min(Comparator.comparingLong(x -> ChronoUnit.DAYS.between(x , LocalDateTime.now())))
//	    					.map(d -> d.getHour() + ":" + d.getMinute() + ":" + d.getSecond()).toString();
//		
		//System.out.println(aa);
	    					
	}
//
//	public void getNearestDate(List<Date> dates, Date targetDate) {
//		Date nearestDate = null;
//		int index = 0;
//		long prevDiff = -1;
//		long targetTS = targetDate.getTime();
//		for (int i = 0; i < dates.size(); i++) {
//			Date date = dates.get(i);
//			long currDiff = Math.abs(date.getTime() - targetTS);
//			if (prevDiff == -1 || currDiff < prevDiff) {
//				prevDiff = currDiff;
//				nearestDate = date;
//				index = i;
//			}
//		}
//		System.out.println("Nearest Date: " + nearestDate);
//		System.out.println("Index: " + index);
//	}
}
