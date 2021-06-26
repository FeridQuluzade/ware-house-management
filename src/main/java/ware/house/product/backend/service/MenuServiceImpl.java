package ware.house.product.backend.service;

import ware.house.product.backend.config.AutoFill;

import java.util.Scanner;

public class MenuServiceImpl implements MenuService {

    private final AutoFill autoFill;
    private final Scanner scanner;

    public MenuServiceImpl(AutoFill autoFill,Scanner scanner) {
        this.autoFill=autoFill;
        this.scanner=scanner;
    }

    @Override
    public void menuItem() {
        while (true) {

            System.out.println("1.Find All products \n" +
                    "2.Find by Id for product \n" +
                    "3.Add product \n" +
                    "4.Update product \n" +
                    "5.Delete product \n" +
                    "6.Exit to menu");

            System.out.println();
            System.out.print("Enter the number:");
            int n = scanner.nextInt();
            if (n == 1) {
                autoFill.findAll();
            } else if (n == 2) {
                autoFill.findById();
            } else if (n == 3) {
                autoFill.addItem();
            } else if (n == 4) {
                autoFill.updateItem();
            } else if (n == 5) {
                autoFill.deleteItem();
            } else if (n == 6) {
                System.exit(0);
            } else {
                System.out.println("Please enter a valid number !");
            }
        }
    }
}
