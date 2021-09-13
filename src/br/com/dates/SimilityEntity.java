package br.com.dates;

import java.time.LocalDateTime;

public class SimilityEntity {

	private String contextCode;
	private LocalDateTime dateTime;
	
	public SimilityEntity() {}

	public SimilityEntity(String contextCode, LocalDateTime dateTime) {
		super();
		this.contextCode = contextCode;
		this.dateTime = dateTime;
	}

	public String getContextCode() {
		return contextCode;
	}

	public void setContextCode(String contextCode) {
		this.contextCode = contextCode;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
}
