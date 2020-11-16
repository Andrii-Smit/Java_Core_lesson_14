package task2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class Shelf {

	ArrayList<Commodity> shelf = new ArrayList<Commodity>();

	public void addCommodity() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите название товара:");
		String name = scanner.next();
		System.out.println("Введите длинну товара, см:");
		int length = scanner.nextInt();
		System.out.println("Введите ширину товара, см:");
		int width = scanner.nextInt();
		System.out.println("Введите вес товара, г:");
		int weight = scanner.nextInt();

		Commodity commodity = new Commodity(name, length, width, weight);

		shelf.add(commodity);
		System.out.println("Товар " + commodity.toString() + " успешно добавлен на полку!");
	}

	public void removeCommodity() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите название товара:");
		String name = scanner.next();
		System.out.println("Введите длинну товара, см:");
		int length = scanner.nextInt();
		System.out.println("Введите ширину товара, см:");
		int width = scanner.nextInt();
		System.out.println("Введите вес товара, г:");
		int weight = scanner.nextInt();

		boolean typeCorrect = isCommodityExists(shelf, name, length, width, weight);

		if (typeCorrect) {

			Iterator<Commodity> iterator = shelf.iterator();

			while (iterator.hasNext()) {
				Commodity nextCommodity = iterator.next();

				if (nextCommodity.getName().equalsIgnoreCase(name) && nextCommodity.getLength() == length
						&& nextCommodity.getWidth() == width && nextCommodity.getWeight() == weight) {
					iterator.remove();
					System.out.println("Товар " + nextCommodity.toString() + " успешно удален с полки!");
				}
			}

		} else {
			System.out.println("Введенного товара нет на полке!");
		}
	}

	public void replaceCommodity() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите название товара:");
		String name = scanner.next();
		System.out.println("Введите длинну товара, см:");
		int length = scanner.nextInt();
		System.out.println("Введите ширину товара, см:");
		int width = scanner.nextInt();
		System.out.println("Введите вес товара, г:");
		int weight = scanner.nextInt();

		boolean typeCorrect = isCommodityExists(shelf, name, length, width, weight);

		if (typeCorrect) {
			for (Commodity commodity : shelf) {
				if (commodity.getName().equalsIgnoreCase(name) && commodity.getLength() == length
						&& commodity.getWidth() == width && commodity.getWeight() == weight) {
					System.out.println("Введите новое название товара:");
					String newName = scanner.next();
					System.out.println("Введите новую длинну товара, см:");
					int newLength = scanner.nextInt();
					System.out.println("Введите новую ширину товара, см:");
					int newWidth = scanner.nextInt();
					System.out.println("Введите новый вес товара, г:");
					int newWeight = scanner.nextInt();
					commodity.setName(newName);
					commodity.setLength(newLength);
					commodity.setWidth(newWidth);
					commodity.setWeight(newWeight);
					System.out.println("Введенный товар успешно заменен на " + commodity.toString() + "!");
				}
			}
		} else {
			System.out.println("Введенного товара нет на полке!");
		}
	}

	public void sortByName() {
		System.out.println("До сортировки товары располагались на полке в таком порядке:");
		for (Commodity commodity : shelf) {
			System.out.println(commodity);
		}
		
		Collections.sort(shelf, new CommodityNameComparator());
		System.out.println("После сортировки порядок расположения товаров на полке будет следующим:");
		for (Commodity commodity : shelf) {
			System.out.println(commodity);
		}
	}
	
	public void sortByLength() {
		System.out.println("До сортировки товары располагались на полке в таком порядке:");
		for (Commodity commodity : shelf) {
			System.out.println(commodity);
		}
		
		Collections.sort(shelf, new CommodityLengthComparator());
		System.out.println("После сортировки порядок расположения товаров на полке будет следующим:");
		for (Commodity commodity : shelf) {
			System.out.println(commodity);
		}
	}
	
	public void sortByWidth() {
		System.out.println("До сортировки товары располагались на полке в таком порядке:");
		for (Commodity commodity : shelf) {
			System.out.println(commodity);
		}
		
		Collections.sort(shelf, new CommodityWidthComparator());
		System.out.println("После сортировки порядок расположения товаров на полке будет следующим:");
		for (Commodity commodity : shelf) {
			System.out.println(commodity);
		}
	}
	
	public void sortByWeight() {
		System.out.println("До сортировки товары располагались на полке в таком порядке:");
		for (Commodity commodity : shelf) {
			System.out.println(commodity);
		}
		
		Collections.sort(shelf, new CommodityWeightComparator());
		System.out.println("После сортировки порядок расположения товаров на полке будет следующим:");
		for (Commodity commodity : shelf) {
			System.out.println(commodity);
		}
	}
	
	public void getCommodity() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите порядковый номер товара на полке:");
		int i = scanner.nextInt();
		
		if (i < 0 || i > (shelf.size() - 1)) {
			System.out.println("Товара с таким порядковым номером нет на полке!");
		} else {
			System.out.println("Под порядковым номером " + i + " на полке находится " + shelf.get(i).toString());
		}
	}
	
	static boolean isCommodityExists(ArrayList<Commodity> shelf, String name, int length, int width, int weight) {
		boolean flag = false;

		for (Commodity commodity : shelf) {
			if (commodity.getName().equalsIgnoreCase(name) && commodity.getLength() == length
					&& commodity.getWidth() == width && commodity.getWeight() == weight) {
				flag = true;
			}
		}

		return flag;
	}
}