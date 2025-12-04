package principal_method;

import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		
		Application app = new Application();
		Scanner scan = new Scanner(System.in);
		
		boolean entradavalida = false;
				
		Double[] X = new Double[3];
		Double[] Y = new Double[3];
		
		Double Xp, Area_X, Yp, Area_Y;
		
		titles('X');
		for(int i = 0; i < 3; i++) {
			while(!entradavalida) {
				try {
					X[i] = scan.nextDouble();
					entradavalida = true;
				}catch (Exception e) {
					System.out.println("Please, digit a valid number.");
					System.out.printf("Try Again on %d° number...", i+1);
					scan.next();
				}
			}
			entradavalida = false;
		}
		
		Xp = app.P_Mesure(X[0], X[1], X[2]);
		// X[0] = a; X[1] = b ; X[2] = c
		Area_X	 = app.TriaguleArea(Xp, X[0], X[1], X[2]);
		

		titles('Y');
		for(int i = 0; i < 3; i++) {
			while(!entradavalida) {
				try {
					Y[i] = scan.nextDouble();
					entradavalida = true;
				}catch (Exception e) {
					System.out.println("Please, digit a valid number.");
					System.out.printf("Try Again on %d° number...", i+1);
					scan.next();
				}
			}
			
			entradavalida = false;
		}
		
		Yp = app.P_Mesure(Y[0], Y[1], Y[2]);
		// Y[0] = a; Y[1] = b ; Y[2] = c
		Area_Y = app.TriaguleArea(Yp, Y[0], Y[1], Y[2]);
		
		results(Area_X, Area_Y);
		
		scan.close();

	}
	
	
	public static void titles(char word) {
		System.out.println("Enter the measures of triangle " + word);
	}

	public static void results(Double Area_X, Double Area_Y) {
		System.out.printf("The area of X triagule is: %.2f%n", Area_X);
		System.out.printf("The area of Y triagule is: %.2f%n", Area_Y);
	}
	
	private Double P_Mesure(Double a, Double b, Double c) {
		Double p = (a + b + c) / 2; 
		return p;
	}
	
	public Double TriaguleArea(Double p, Double a, Double b, Double c) {
		Double Area = Math.sqrt(p * (p - a)*(p - b)*(p - c));
		return Area;
	}

}
