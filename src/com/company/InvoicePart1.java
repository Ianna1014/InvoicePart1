package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InvoicePart1 {

	private static List<String> products = new ArrayList<>();
	private static List<Double> prices = new ArrayList<>();

	public static void addProducts() {

		products.add("Bison Sweater");
		prices.add(Double.valueOf(55.99));

		products.add("Bison Tee");
		prices.add(Double.valueOf(14.99));

		products.add("Bison Hoodie");
		prices.add(Double.valueOf(23.99));

		products.add("Bison Bumpersticker");
		prices.add(Double.valueOf(4.99));
	}

	public static void userOptions() {

		Scanner input = new Scanner(System.in);
		String answer = "";
		List<Integer> purchases = new ArrayList<>();

		do {
			System.out.println("What do you want");
			System.out.println("1) Add Purchase 2) change Purchase 3) show purchase 4) finish transaction");
			answer = input.nextLine();

			if (answer.equals("1")) {

				addPurchase(purchases, input);

			} else if (answer.equals("2")) {

				changePurchase(purchases, input);

			} else if (answer.equals("3")) {
				showPurchases(purchases);

			} else if (answer.equals("4")) {

				showTotal(purchases);
			}

		} while (!answer.equals("4"));

	}

	public static void printMenu() {

		int i = 0;
		for (String element : products) {

			System.out.println("Enter " + i + " for " + element);
			i++;
		}

	}

	public static void addPurchase(List<Integer> purchases, Scanner scanner) {

		int selectedProduct = 100;
		printMenu();
		selectedProduct = scanner.nextInt();

		if (selectedProduct < 0 || selectedProduct > products.size() - 1) {
			System.out.println("Invalid Product entered");
		} else {
			purchases.add(selectedProduct);
		}
	}

	private static void changePurchase(List<Integer> purchases, Scanner input) {
		int selectedProduct = 100;
		int replacedProduct = 100;
		System.out.println("Enter the product number to be replaced");
		replacedProduct = input.nextInt();
		System.out.println("Enter the product to be replaced with");
		selectedProduct = input.nextInt();

		if (selectedProduct < 0 || selectedProduct > products.size() - 1) {
			System.out.println("Invalid Product entered");
		}else {


		if (replacedProduct < 0 || replacedProduct > purchases.size() - 1) {
			System.out.println("Invalid Product selected for replacement");
		} else {
			purchases.set(replacedProduct, selectedProduct);
		}

		}
	}

	private static void showPurchases(List<Integer> purchases) {

		System.out.println("\n Following products in purchase list so far:");
		int i = 0;
		for (int element : purchases) {
			System.out.println(i + ") " + products.get(element));
			i++;
		}

	}

	private static void showTotal(List<Integer> purchases) {

		double total = purchases.stream().map(element -> prices.get(element)).reduce(0.0,
				(subtotal, element) -> subtotal + element);
		System.out.println("Total price: " + total);
	}

	public static void main(String[] args) {
		addProducts();
		userOptions();
	}
}
