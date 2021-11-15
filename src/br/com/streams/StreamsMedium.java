package br.com.streams;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamsMedium {

	List<Integer> listaInteger = List.of(2, 7, 16, 19, 32, 1, 6, 23);
	List<String> listaString = List.of("Angra", "Tim Maia", "Raimundos", "Matanza", "Ultraje a Rigor");	
	List<Banda> listaBandas = List.of(
			new Banda("Angra", 200, 23000, "São Paulo"),
			new Banda("Tim Maia", 100, 23000, "Rio de Janeiro"),
			new Banda("Raimundos", 150, 25000, "Brasilia"),
			new Banda("Matanza", 340, 56000, "São Paulo"),
			new Banda("Ultraje a Rigor", 45, 67000, "São Paulo"));
	
	public void distintos() {
		listaInteger.stream()
			.distinct()
			.forEach(System.out::println);
	}
	
	public void limite() {
		listaInteger.stream()
			.limit(2)
			.forEach(System.out::println);
	}
	
	public void pular() {
		listaInteger.stream()
			.skip(2)
			.forEach(System.out::println);
	}
	
	// Imprimir maiúsculas
	public void maisculas() {		
		listaString.stream().
			map(String::toUpperCase)
			.forEach(System.out::println);
	}
	
	public void tamanhoNomeBanda() {
		listaString.stream()
		.mapToInt(banda -> banda.length())
		.forEach(System.out::println);
	}
	
	public void anyMatch() {
		boolean existe = listaBandas.stream()
		.anyMatch(banda -> banda.getCidade().equals("São Paulo"));
		System.out.println(existe);
	}
	
	public void allMatch() {
		boolean todas = listaBandas.stream()
		.allMatch(banda -> banda.getCidade().equals("São Paulo"));
		System.out.println(todas);
	}
	
	public void noneMatch() {
		boolean nenhumEncontrado = listaBandas.stream()
		.noneMatch(banda -> banda.getCidade().equals("Acre"));
		System.out.println(nenhumEncontrado);
	}
	
	public void findFirst() {
		Optional<Banda> bandaOptional = listaBandas.stream()
		.filter(banda -> banda.getCidade().equals("São Paulo"))
		.findFirst();
		
		System.out.println(bandaOptional.get().getNome());
	}
	
	public void somarFaturamento() {
		int soma = listaBandas.stream()
		.mapToInt(banda -> banda.getFaturamento())
		.sum();
		System.out.println(soma);
	}
	
	public void menorFaturamento() {
		OptionalInt resultado = listaBandas.stream()
		.mapToInt(banda -> banda.getFaturamento())
		.min();
		System.out.println(resultado.getAsInt());
	}
	
	public void maiorFaturamento() {
		OptionalInt resultado = listaBandas.stream()
		.mapToInt(banda -> banda.getFaturamento())
		.max();
		System.out.println(resultado.getAsInt());
	}	
	
	public void coletaNomesParaLista() {
		List<String> listaNomes = listaBandas.stream()
		.map(Banda::getNome)
		.collect(Collectors.toList());		
		listaNomes.forEach(System.out::println);
	}
	
	public void coletaCidadesParaSet() {
		Set<String> listaCidades = listaBandas.stream()
		.map(Banda::getCidade)
		.collect(Collectors.toSet());		
		listaCidades.forEach(System.out::println);
	}
	
	public void contarDiscosVendidos() {
		long contagem = listaBandas.stream()
				.filter(banda -> banda.getDiscos() > 100)
				.collect(Collectors.counting());
		System.out.println(contagem);
	}
	
	public void bandaMenorFaturamento() {
		Optional<Banda> banda = listaBandas.stream()
				.collect(Collectors.minBy(Comparator.comparing(Banda::getFaturamento)));
		System.out.println(banda.get().getNome());
	}
	
	public void bandaMaiorFaturamento() {
		Optional<Banda> banda = listaBandas.stream()
				.collect(Collectors.maxBy(Comparator.comparing(Banda::getFaturamento)));
		System.out.println(banda.get().getNome());
	}
	
	public void mediaFaturamentoBandas() {
		double media = listaBandas.stream()
		.collect(Collectors.averagingInt(banda -> banda.getFaturamento()));
		System.out.println(media);
	}
	
	public void agruparPorCidade() {
		Map<String, List<Banda>> lista = listaBandas.stream()
					.collect(Collectors.groupingBy(Banda::getCidade));
		lista.forEach((k, v) -> System.out.println("key=" + k + " value=" + v));
	}
	
	// Agrupar onde a chave é o pais e o valor é a soma de todos os salarios daquele pais
	public void agruparPorFaturamento() {
		
		Map<String, Integer> lista = listaBandas.stream()
				.collect(Collectors.groupingBy(Banda::getCidade, Collectors.summingInt(Banda::getFaturamento)));
		
		lista.forEach((k, v) -> System.out.println("key=" + k + " value=" + v));
	}
	
	public static void main(String[] args) {
		StreamsMedium s = new StreamsMedium();
		s.distintos();
		s.limite();
		s.pular();
		s.maisculas();
		s.tamanhoNomeBanda();
		s.anyMatch();
		s.allMatch();
		s.noneMatch();
		s.findFirst();
		s.somarFaturamento();
		s.menorFaturamento();
		s.maiorFaturamento();
		s.coletaNomesParaLista();
		s.coletaCidadesParaSet();
		s.contarDiscosVendidos();
		s.bandaMenorFaturamento();
		s.bandaMaiorFaturamento();
		s.mediaFaturamentoBandas();
		s.agruparPorCidade();
		s.agruparPorFaturamento();
	}
	
}

class Banda {
	
	private String nome;
	private Integer discos;
	private Integer faturamento;
	private String cidade;
	
	public Banda(String nome, Integer discos, Integer faturamento, String cidade) {
		super();
		this.nome = nome;
		this.discos = discos;
		this.faturamento = faturamento;
		this.cidade = cidade;
	}

	public String getNome() { return nome; }
	public void setNome(String nome) { this.nome = nome; }
	public Integer getDiscos() { return discos; }
	public void setDiscos(Integer discos) { this.discos = discos; }
	public Integer getFaturamento() { return faturamento; }
	public void setFaturamento(Integer faturamento) { this.faturamento = faturamento; }
	public String getCidade() { return cidade; }
	public void setCidade(String cidade) {this.cidade = cidade;}
}
