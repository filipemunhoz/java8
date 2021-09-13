package br.com.streams;

import java.util.Optional;

public class MapTest {

	public static void main(String[] args) {

		new MapTest().executa();

	}

	void executa() {
		String text = "";

		String defaultText = Optional.ofNullable(text).orElseGet(this::getMyDefault);
		System.out.println(defaultText);

	}

	public String getMyDefault() {
		return "Default Value";
	}
}
