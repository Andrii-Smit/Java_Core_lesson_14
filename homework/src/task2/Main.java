package task2;

import java.util.Scanner;

public class Main {

	static void menu() {
		System.out.println();
		System.out.println("������� 1, ����� �������� ����� �� �����");
		System.out.println("������� 2, ����� ������� ����� � �����");
		System.out.println("������� 3, ����� �������� ����� �� �����");
		System.out.println("������� 4, ����� ������������� ������ �� ����� �� �� ��������");
		System.out.println("������� 5, ����� ������������� ������ �� ����� �� �� �����");
		System.out.println("������� 6, ����� ������������� ������ �� ����� �� �� ������");
		System.out.println("������� 7, ����� ������������� ������ �� ����� �� �� ����");
		System.out.println("������� 8, ����� ������� ����� �� ��� ����������� ������ ���������� �� �����");
		System.out.println("������� 9, ����� ����� �� ���������");
	}

	public static void main(String[] args) {
		Shelf shelf = new Shelf();
		Scanner scanner = new Scanner(System.in);

		while (true) {
			menu();

			switch (scanner.nextInt()) {

			case 1: {
				shelf.addCommodity();
				break;
			}

			case 2: {
				shelf.removeCommodity();
				break;
			}

			case 3: {
				shelf.replaceCommodity();
				break;
			}

			case 4: {
				shelf.sortByName();
				break;
			}

			case 5: {
				shelf.sortByLength();
				break;
			}

			case 6: {
				shelf.sortByWidth();
				break;
			}

			case 7: {
				shelf.sortByWeight();
				break;
			}

			case 8: {
				shelf.getCommodity();
				break;
			}

			case 9: {
				System.exit(0);
				break;
			}

			default: {
				System.out.println("������� ����� �� 1 �� 9!");
				break;
			}
			}
		}

	}

}
