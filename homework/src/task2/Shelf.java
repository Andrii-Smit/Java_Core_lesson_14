package task2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class Shelf {

	ArrayList<Commodity> shelf = new ArrayList<Commodity>();

	public void addCommodity() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("������� �������� ������:");
		String name = scanner.next();
		System.out.println("������� ������ ������, ��:");
		int length = scanner.nextInt();
		System.out.println("������� ������ ������, ��:");
		int width = scanner.nextInt();
		System.out.println("������� ��� ������, �:");
		int weight = scanner.nextInt();

		Commodity commodity = new Commodity(name, length, width, weight);

		shelf.add(commodity);
		System.out.println("����� " + commodity.toString() + " ������� �������� �� �����!");
	}

	public void removeCommodity() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("������� �������� ������:");
		String name = scanner.next();
		System.out.println("������� ������ ������, ��:");
		int length = scanner.nextInt();
		System.out.println("������� ������ ������, ��:");
		int width = scanner.nextInt();
		System.out.println("������� ��� ������, �:");
		int weight = scanner.nextInt();

		boolean typeCorrect = isCommodityExists(shelf, name, length, width, weight);

		if (typeCorrect) {

			Iterator<Commodity> iterator = shelf.iterator();

			while (iterator.hasNext()) {
				Commodity nextCommodity = iterator.next();

				if (nextCommodity.getName().equalsIgnoreCase(name) && nextCommodity.getLength() == length
						&& nextCommodity.getWidth() == width && nextCommodity.getWeight() == weight) {
					iterator.remove();
					System.out.println("����� " + nextCommodity.toString() + " ������� ������ � �����!");
				}
			}

		} else {
			System.out.println("���������� ������ ��� �� �����!");
		}
	}

	public void replaceCommodity() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("������� �������� ������:");
		String name = scanner.next();
		System.out.println("������� ������ ������, ��:");
		int length = scanner.nextInt();
		System.out.println("������� ������ ������, ��:");
		int width = scanner.nextInt();
		System.out.println("������� ��� ������, �:");
		int weight = scanner.nextInt();

		boolean typeCorrect = isCommodityExists(shelf, name, length, width, weight);

		if (typeCorrect) {
			for (Commodity commodity : shelf) {
				if (commodity.getName().equalsIgnoreCase(name) && commodity.getLength() == length
						&& commodity.getWidth() == width && commodity.getWeight() == weight) {
					System.out.println("������� ����� �������� ������:");
					String newName = scanner.next();
					System.out.println("������� ����� ������ ������, ��:");
					int newLength = scanner.nextInt();
					System.out.println("������� ����� ������ ������, ��:");
					int newWidth = scanner.nextInt();
					System.out.println("������� ����� ��� ������, �:");
					int newWeight = scanner.nextInt();
					commodity.setName(newName);
					commodity.setLength(newLength);
					commodity.setWidth(newWidth);
					commodity.setWeight(newWeight);
					System.out.println("��������� ����� ������� ������� �� " + commodity.toString() + "!");
				}
			}
		} else {
			System.out.println("���������� ������ ��� �� �����!");
		}
	}

	public void sortByName() {
		System.out.println("�� ���������� ������ ������������� �� ����� � ����� �������:");
		for (Commodity commodity : shelf) {
			System.out.println(commodity);
		}
		
		Collections.sort(shelf, new CommodityNameComparator());
		System.out.println("����� ���������� ������� ������������ ������� �� ����� ����� ���������:");
		for (Commodity commodity : shelf) {
			System.out.println(commodity);
		}
	}
	
	public void sortByLength() {
		System.out.println("�� ���������� ������ ������������� �� ����� � ����� �������:");
		for (Commodity commodity : shelf) {
			System.out.println(commodity);
		}
		
		Collections.sort(shelf, new CommodityLengthComparator());
		System.out.println("����� ���������� ������� ������������ ������� �� ����� ����� ���������:");
		for (Commodity commodity : shelf) {
			System.out.println(commodity);
		}
	}
	
	public void sortByWidth() {
		System.out.println("�� ���������� ������ ������������� �� ����� � ����� �������:");
		for (Commodity commodity : shelf) {
			System.out.println(commodity);
		}
		
		Collections.sort(shelf, new CommodityWidthComparator());
		System.out.println("����� ���������� ������� ������������ ������� �� ����� ����� ���������:");
		for (Commodity commodity : shelf) {
			System.out.println(commodity);
		}
	}
	
	public void sortByWeight() {
		System.out.println("�� ���������� ������ ������������� �� ����� � ����� �������:");
		for (Commodity commodity : shelf) {
			System.out.println(commodity);
		}
		
		Collections.sort(shelf, new CommodityWeightComparator());
		System.out.println("����� ���������� ������� ������������ ������� �� ����� ����� ���������:");
		for (Commodity commodity : shelf) {
			System.out.println(commodity);
		}
	}
	
	public void getCommodity() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("������� ���������� ����� ������ �� �����:");
		int i = scanner.nextInt();
		
		if (i < 0 || i > (shelf.size() - 1)) {
			System.out.println("������ � ����� ���������� ������� ��� �� �����!");
		} else {
			System.out.println("��� ���������� ������� " + i + " �� ����� ��������� " + shelf.get(i).toString());
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