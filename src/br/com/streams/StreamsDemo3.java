package br.com.streams;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.Collectors;

// https://medium.com/javarevisited/stream-api-most-useful-operations-28e3988002d0
public class StreamsDemo3 {

	final List<Funcionario> listaFuncionarios = List.of(
			new Funcionario("Joao", 23, 23000, "Brasil"),
			new Funcionario("Jose", 53, 23000, "Brasil"),
			new Funcionario("Mario", 63, 25000, "Panama"),
			new Funcionario("Maria", 34, 56000, "Chile"),
			new Funcionario("Joana", 45, 67000, "Brasil"),
			new Funcionario("Josefina", 51, 54000, "Chile"));
	
	List<Integer> listaInteger = List.of(1, 12, 23, 32, 56, 6, 23);
	
	final List<String> listaString = List.of("Joao", "Jose", "Mario", "Maria", "Joana", "Josefina");
		
	// Imprimir valores unicos em caso de duplicados
	public void distinct() {
		listaInteger.stream()
			.distinct()
			.forEach(System.out::println);
	}
	
	// Limitar o retorno para 3 valores
	public void limit() {
		listaInteger.stream()
			.limit(3)
			.forEach(System.out::println);
	}	

	// Pular os dois primeiros valores
	public void skip() {
		listaInteger.stream()
			.skip(2)
			.forEach(System.out::println);
	}
	
	// Imprimir maiúsculas
	public void toUpperCase() {		
		listaString.stream().
			map(String::toUpperCase)
			.forEach(System.out::println);
	}
	
	// Imprimir o tamanho de cada nome
	public void nameLength() {
		listaString.stream()
			.mapToInt(name -> name.length())
			.forEach(System.out::println);
	}
	
	// Verificar se existe algum funcionario que resida no Brasil
	public void anyMatch() {
		boolean reside = listaFuncionarios.stream()
			.anyMatch(funcionario -> funcionario.getPais().equals("Brasil"));
		System.out.println(reside);
	}

	// Verificar se todos os funcionarios residem no Brasil
	public void allMatch() {
		boolean reside = listaFuncionarios.stream()
			.allMatch(funcionario -> funcionario.getPais().equals("Brasil"));
		System.out.println(reside);
	}
	
	// Verificar se todos os funcionarios nao residem na China
	public void noneMatch() {
		boolean reside = listaFuncionarios.stream()
			.noneMatch(funcionario -> funcionario.getPais().equals("China"));
		System.out.println(reside);
	}
	
	// Retornar o primeiro que encontrar
	public void findFirst() {
		Optional<Funcionario> funcionario = listaFuncionarios.stream()
			.filter(func -> func.getPais().equals("Brasil"))
			.findFirst();
		System.out.println(funcionario.get().getNome());
	}
	
	// Somar o salario dos funcionarios com reduce
	public void reduce() {
		Optional<Integer> total = listaFuncionarios.stream()
			.map(func -> func.getSalario())
			.reduce((a, b) -> a + b);

		System.out.println(total.get());
	}

	// Somar o salario dos funcionarios com sum
	public void sum() {
		int total = listaFuncionarios.stream()
			.mapToInt(Funcionario::getSalario)
			.sum();

		System.out.println(total);
	}

	// Retornar o menor salario
	public void min() {
		OptionalInt menor = listaFuncionarios.stream()
			.mapToInt(Funcionario::getSalario)
			.min();

		System.out.println(menor.getAsInt());
	}
	
	// Retornar o maior salario
	public void max() {
		OptionalInt maior = listaFuncionarios.stream()
			.mapToInt(Funcionario::getSalario)
			.max();

		System.out.println(maior.getAsInt());
	}
	
	// Coletar em uma lista todos os nomes
	public void toList() {
		
		List<String> nomes = listaFuncionarios.stream()
				.map(func -> func.getNome())
				.collect(Collectors.toList());
		nomes.forEach(System.out::println);		
	}
	
	// Coletar em ua set todos os paises
	public void toSet() {
		
		Set<String> paises = listaFuncionarios.stream()
				.map(func -> func.getPais())
				.collect(Collectors.toSet());
		paises.forEach(System.out::println);
	}

	// Coletar elementos para uma nova collection
	public void toCollection() {		
		LinkedList<String> nomes = listaFuncionarios.stream()
				.map(func -> func.getNome())
				.collect(Collectors.toCollection(LinkedList::new));
		nomes.forEach(System.out::println);
	}
	
	// Agregação - Contagem
	public void counting() {
		long count = listaFuncionarios.stream()
				.filter(func -> func.getIdade() > 30)
				.collect(Collectors.counting());

		System.out.println(count);
	}

	// Retornar o funcionario com o menor salario
	public void minBy() {
		Optional<Funcionario> funcionario = listaFuncionarios.stream()
				.collect(Collectors.minBy(Comparator.comparing(Funcionario::getSalario)));

		System.out.println(funcionario.get().getNome());
	}

	// Retornar o funcionario com o maior salario
	public void maxBy() {
		Optional<Funcionario> funcionario = listaFuncionarios.stream()
				.collect(Collectors.maxBy(Comparator.comparing(Funcionario::getSalario)));

		System.out.println(funcionario.get().getNome());
	}
	
	// Somar todos os salarios
	public void summingInt() {
		int salario = listaFuncionarios.stream()
				.collect(Collectors.summingInt(func -> func.getSalario()));

		System.out.println(salario);
	}

	// Media salarial
	public void averagingInt() {
		double salario = listaFuncionarios.stream()
				.collect(Collectors.averagingInt(func -> func.getSalario()));

		System.out.println(salario);
	}
	
	// Juntar todas as strings
	public void joining() {
		String string = listaString.stream()
		.collect(Collectors.joining());

		System.out.println(string);
	}
	
	// Sumarizar
	public void summarizingInt() {
		IntSummaryStatistics statistics = listaFuncionarios.stream()
					.collect(Collectors.summarizingInt(Funcionario::getSalario));
		
		System.out.println(statistics);
	}
	
	// Operações de agrupamento
	public void groupingBy() {
		Map<String, List<Funcionario>> lista = listaFuncionarios.stream()
					.collect(Collectors.groupingBy(Funcionario::getPais));
		lista.forEach((k, v) -> System.out.println("key=" + k + " value=" + v));
	}
	
	// Agrupar onde a chave é o pais e o valor é a soma de todos os salarios daquele pais
	public void groupingBySalary() {
		
		Map<String, Integer> lista = listaFuncionarios.stream()
				.collect(Collectors.groupingBy(Funcionario::getPais, Collectors.summingInt(Funcionario::getSalario)));
		
		lista.forEach((k, v) -> System.out.println("key=" + k + " value=" + v));
	}

	// Agrupar o resultado em um set
	public void groupingOnSet() {
		
		Map<String, Set<Funcionario>> lista = listaFuncionarios.stream()
				.collect(Collectors.groupingBy(Funcionario::getPais, Collectors.toSet()));
		
		lista.forEach((k, v) -> System.out.println("key=" + k + " value=" + v));
	}
	
	// Agrupar o resultado pelo funcionario que tem o maior salario naquele pais
	public void groupingOnMaxSalary() {
		
		Map<String, Optional<Funcionario>> lista = listaFuncionarios.stream()
				.collect(Collectors.groupingBy(Funcionario::getPais, Collectors.maxBy(Comparator.comparingInt(Funcionario::getSalario))));
		
		lista.forEach((k, v) -> System.out.println("key=" + k + " value=" + v.get().getNome()));
	}
	
	
	public static void main(String[] args) {
		StreamsDemo3 demo = new StreamsDemo3();
		demo.distinct();
		demo.limit();
		demo.skip();
		demo.toUpperCase();
		demo.nameLength();
		demo.anyMatch();
		demo.allMatch();
		demo.noneMatch();
		demo.findFirst();
		demo.reduce();
		demo.sum();
		demo.min();
		demo.max();
		demo.toList();
		demo.toSet();
		demo.toCollection();
		demo.counting();
		demo.minBy();
		demo.maxBy();
		demo.summingInt();
		demo.averagingInt();
		demo.joining();
		demo.summarizingInt();
		demo.groupingBy();
		demo.groupingBySalary();
		demo.groupingOnSet();
		demo.groupingOnMaxSalary();
	}
}

class Funcionario {
	
	private String nome;
	private Integer idade;
	private Integer salario;
	private String pais;
	
	
	public Funcionario(String nome, Integer idade, Integer salario, String pais) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.salario = salario;
		this.pais = pais;
	}
	
	public String getNome() { return nome;}
	public void setNome(String nome) { this.nome = nome;}
	public Integer getIdade() { return idade;}
	public void setIdade(Integer idade) { this.idade = idade;}
	public Integer getSalario() { return salario;	}
	public void setSalario(Integer salario) { this.salario = salario;}
	public String getPais() { return pais;	}
	public void setPais(String pais) { this.pais = pais; }
}