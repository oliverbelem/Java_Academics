package application;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import entities.Product;

public class App {

	public static void main(String[] args) {
		
		// Instanciações necessárias
		App app = new App();
		List<Product> stockList = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		//String response = "";
		
		App.Clear_Terminal();
		App.Visual_Title();
	
		String response = app.Stock_Menu(stockList, scanner);
		
		try {			
			while (!response.equals("Exit")) {
				response = app.Stock_Visual_Table(stockList, scanner);
			}
		} 
		catch (Exception e) {
			System.out.printf("A error appears: %s\n", e);
		}finally {			
			App.Visual_Title();
			System.out.println("\nThe application was finished...\n");
			System.exit(0);
		}

		scanner.close();
	}
	
	// Metodo para limpeza do terminal
	private static void Clear_Terminal() {
		System.out.print("\033[H\033[2J");
	    System.out.flush();
	}

	// Metodo principal. Essa função é responsável pela organização central do menu principal
	private String Selector_Menu(int selector, List<Product> stockList, Scanner scanner) {
		
		switch (selector) {
		case 1:
			App.Clear_Terminal();
			Add_On_Stock(scanner, stockList);
			break;
		case 2:
			App.Clear_Terminal();
			Add_Quantity(scanner, stockList);
			break;
		case 3:
			App.Clear_Terminal();
			Remove_Quantity(scanner, stockList);
			break;
		case 99:
			App.Clear_Terminal();
			return "Exit";
		default:
			break;
		}
		return "";
	}
	
	// Metodo de apresentação de estoque
	private String Stock_Menu(List<Product> stockList, Scanner scanner) {

		int selector = 0;

		System.out.println("Options: ");
		System.out.println("1 - Add a new product");
		System.out.println("2 - Add a quantity on product");
		System.out.println("3 - Remove a quantity on product");
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("99 - Exit");
		System.out.println("-------------------------------------------------------------------------");
		selector = scanner.nextInt();
		
		String response = Selector_Menu(selector, stockList, scanner);
		return response;
	}

	// Metodo de adição de quantidade de itens ao estoque
	private void Add_On_Stock(Scanner scanner, List<Product> stockList) {
		Product product = new Product();

		App.Visual_Title();
		scanner.nextLine();

		System.out.println("Enter the product data:");
		System.out.print("Name: ");
		product.Name = scanner.nextLine();
		System.out.print("Price: ");
		product.Price = scanner.nextDouble();
		System.out.print("Quantity: ");
		product.Quantity = scanner.nextInt();
		
		stockList.add(product);
		
		System.out.print("\nItem Added: ");
		System.out.println(product);
	}
	
	// Metodo de remoção de quantidade de itens em estoque
	private void Add_Quantity(Scanner scanner, List<Product> stockList) {
		scanner.nextLine();
		
		System.out.println("Select a item for add more quantity: ");
		int item_for_add = scanner.nextInt();
		
		System.out.println("How much items to add? ");
		int add_quant = scanner.nextInt();

		Product item = stockList.get((item_for_add - 1)); 
		item.AddProducts(add_quant);
	}

	private void Remove_Quantity(Scanner scanner, List<Product> stockList) {
		scanner.nextLine();
		
		System.out.println("Select a item for remove quantity: ");
		int item_for_add = scanner.nextInt();
		
		System.out.println("How much items to remove? ");
		int remove_quant = scanner.nextInt();
		
		Product item = stockList.get((item_for_add - 1)); 
		item.RemoveProducts(remove_quant);
	}
	
	// Metodo para impressão dos produtos em estoque
	private String Stock_Visual_Table(List<Product> stockList,Scanner scanner) {
		App.Clear_Terminal();
		App.Visual_Title();
		System.out.printf("%-25s%-15s%-13s%-15s\n", "Product Name", "Price", "Quantity", "Total Value");
		System.out.println("-------------------------------------------------------------------------");
		
		for (Product productsProduct : stockList) {
			System.out.printf(
					"%-25s%-15s%-13s%-15s\n",
					productsProduct.Name, 
					productsProduct.Price,
					productsProduct.Quantity,
					productsProduct.TotalValueStock());
		}
		System.out.println("-------------------------------------------------------------------------");
		
		String response = Stock_Menu(stockList, scanner);
		return response;
	}
	
	// Titulo
	public static void Visual_Title() {
		System.out.println("-------------------------------------------------------------------------");
		System.out.println("                                 STOCK ADDER                             ");
		System.out.println("-------------------------------------------------------------------------");
	}
}
