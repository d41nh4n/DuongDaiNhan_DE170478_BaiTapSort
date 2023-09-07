/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Element;
import View.Menu;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Dai Nhan
 */
public class UseSortAlgorithm extends Menu<String> {

    private Element element = new Element();
    private SortAlgorithm algorithm;

    public UseSortAlgorithm() {
        super("Programming", new String[]{
            "Sort", "Exit"
        });
        algorithm = new SortAlgorithm();
    }

    public int numberArray() {
        int n;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("How many number in array(1-20): ");
            try {
                String input = sc.nextLine();
                n = Integer.parseInt(input);
                if (n >= 1 && n <= 20) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Input number from 1 to 20");
            }
        }
        return n;
    }

    public void createElementByRandom(int n) {
        int[] arr = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(100);
        }
        element.setArrayNumber(arr);
        element.setSizeOfArray(n);
    }
//===========================================================================

    @Override
    public void execute() {
        display();
        Scanner sc = new Scanner(System.in);
        String input;
        input = sc.nextLine();
        switch (input) {
            case "1":
                sort();
                break;
            case "2":
                System.out.println("Exit...");
                break;
            default:
                System.out.println("Wrong choice");
        }
    }

    public void sort() {
        int number = numberArray();
        createElementByRandom(number);
        int[] arr = element.getArrayNumber();
        System.out.println("Your random array number");
        for (int i = 0; i < element.getArrayNumber().length; i++) {
            System.out.println(arr[i]);
        }
        String[] mcSearch = {"Linear Search", "Binary Search", "Exit"};
        Menu menu = new Menu("Sort Menu", mcSearch) {
            @Override
            public void execute() {
                Scanner sc = new Scanner(System.in);
                String input;
                input = sc.nextLine();
                switch (input) {
                    case "1":
                        element.setArrayNumber(algorithm.buddleSort(element.getArrayNumber()));
                        System.out.println("Your array number after sort");
                        for (int i = 0; i < element.getArrayNumber().length; i++) {
                            System.out.println(arr[i]);
                        }
                        break;
                    case "2":
                        element.setArrayNumber(algorithm.quickSort(element.getArrayNumber(), 0, number - 1));
                          System.out.println("Your array number after sort");
                        for (int i = 0; i < element.getArrayNumber().length; i++) {
                            System.out.println(arr[i]);
                        }
                        break;
                    case "3":
                        System.out.println("Exit...");
                        break;
                    default:
                        System.out.println("Wrong choice");
                }

            }
        };
        menu.run();
    }
}
