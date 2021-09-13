package br.com.dates;

import java.util.ArrayList;
import java.util.List;

public class SimilityCache {
	
	String key;

	List<SimilityEntity> entities = new ArrayList<SimilityEntity>();

	
	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public List<SimilityEntity> getEntities() {
		return entities;
	}

	public void setEntities(List<SimilityEntity> entities) {
		this.entities = entities;
	}
}
