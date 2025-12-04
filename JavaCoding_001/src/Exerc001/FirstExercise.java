package Exerc001;

import java.util.ArrayList;
import java.util.List;

public class FirstExercise {
		
	private static List<Integer> inteiros = new ArrayList<>();
	
	public static void main(String[] args) {
		
		int number_1 = 25;
		int number_2 = 40;

		diferent(number_1, number_2);
		
		for (int i = 0; i < inteiros.size(); i++) {
			System.out.println("List Number " + (i+1) + "° : " + inteiros.get(i));
		}
		
	}
	
	public static void diferent(int number_1, int number_2) {
		int multiplication = number_1 * number_2;
		int sum = number_1 + number_2;
		int minus = number_1 - number_2;
		int division = number_1 / number_2;
		
		inteiros.add(multiplication);
		inteiros.add(sum);
		inteiros.add(minus);
		inteiros.add(division);
	}
}
