package br.com.maps;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;



public class Map1 {

	public static void main(String[] args) {

		Map<String, List<String>> myMap = new HashMap<>();

		myMap.put("K1", List.of("V1", "V2"));
		myMap.put("K2", List.of("V3", "V4"));
		myMap.put("K3", List.of("V5", "V6"));
		myMap.put("K4", List.of("V7", "V8"));
		myMap.put("K5", null);
		
		Boolean e1 = Optional.ofNullable(myMap)
				.map(s -> s.get("K1"))
				.map(f -> f.contains("V1"))
				.orElse(Boolean.FALSE);

		Boolean e2 = Optional.ofNullable(myMap)
				.map(s -> s.get("K1"))
				.map(f -> f.contains("NAO_EXISTENTE_NA_LISTA_DE_STRING_DENTRO_DO_MAP"))
				.orElse(Boolean.FALSE);
		
		Boolean e3 = Optional.ofNullable(myMap)
				.map(s -> s.get("NAO_EXISTE_A_KEY"))
				.map(f -> f.contains("V1"))
				.orElse(Boolean.FALSE);
		
		Boolean e4 = Optional.ofNullable(myMap)
				.map(s -> s.get("K5"))
				.map(f -> f.contains("V1"))
				.orElse(Boolean.FALSE);		
		
		myMap = null;
		Boolean e5 = Optional.ofNullable(myMap)
				.map(s -> s.get("O MAPA EH NULL"))
				.map(f -> f.contains("V1"))
				.orElse(Boolean.FALSE);
		
		System.out.println(e1);
		System.out.println(e2);
		System.out.println(e3);
		System.out.println(e4);
		System.out.println(e5);
	}

}
