package br.com.manipulacao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ManipulacaoJson {
	
    private static final long MEGABYTE = 1024L * 1024L;
    private static List<Agencia> agencias = null;
    
	public static void main(String[] args) throws IOException {
		ManipulacaoJson m = new ManipulacaoJson();
		//m.geraJson();
				
		try {
			InputStream inJson = ManipulacaoJson.class.getResourceAsStream("/341_agencias.json");
			agencias = Arrays.asList(new ObjectMapper().readValue(inJson, Agencia[].class));
			
			long startTime = System.currentTimeMillis();
			m.executa("9000");				
			
			long endTime = System.currentTimeMillis();
		    System.out.println("Total execution time: " + (endTime-startTime) + " ms");
		    m.showMemoryUsage();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void executa(String agencia) {
		for (Agencia item : agencias) {
			if(item.getCodigo().equals(Integer.valueOf(agencia))) {
				break;
			}
		}		 
		//showMemoryUsage();
	}
	

	private void showMemoryUsage() {
		Runtime runtime = Runtime.getRuntime();
		long memoryFinal = runtime.totalMemory() - runtime.freeMemory();
		System.out.println("Used memory is bytes: " + memoryFinal);
		System.out.println("Used memory is megabytes: " + bytesToMegabytes(memoryFinal));
	}

	public static long bytesToMegabytes(long bytes) {
        return bytes / MEGABYTE;
    }


	
	public void geraJson() {		
		Random rand = new Random();
		List<String> estados = List.of("SP","RJ","MG","AC","RS","MT");
		
		for(int i=0; i<9001; i++) {
			
			String codigo = String.format("%04d", i);
			String uf = estados.get(rand.nextInt(estados.size()));
			
			String json = "{\"codigo\": \"" + codigo + "\",";
			String ufjson = "\"uf\": \"" + uf + "\"},\n"; 
			System.out.print(json + ufjson);
		}		
	}
	
}

class Agencia {
	
	private Integer codigo;
	private String uf;
	
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
}