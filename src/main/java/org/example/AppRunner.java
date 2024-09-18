package org.example;

import org.example.CustomException.ValidException;
import org.example.Models.Book;
import org.example.Service.BookDAO.BookDMLCommand;
import org.example.Service.BookDAO.BookDQLCommand;

import org.example.Service.ParserStringToBook;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class AppRunner {
    private final BookDMLCommand dml;
    private final BookDQLCommand dql;

    @Autowired
    public AppRunner(BookDMLCommand dml, BookDQLCommand dql) {
        this.dml = dml;
        this.dql = dql;
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        boolean active = true;

        while (active) {
            String HEADER_MENU = """
                    --------------------------------------------------------------
                    Enter the sequence number of the operation you want to perform:
                    (Enter an integer!)
                    --------------------------------------------------------------
                    1) Show all User.
                    2) Create User.
                    3) Edit User.
                    4) Delete User.
                    6) Exit.
                    """;

            System.out.println(HEADER_MENU);

            while (!sc.hasNextInt()) {
                System.out.println("You have entered a text value, you must enter an integer value!");
                sc.nextLine();
            }

            int idOperation = sc.nextInt();
            sc.nextLine();
            List<Book> temp = dql.findAll();

            switch (idOperation) {
                case 1 -> temp.forEach(System.out::println);
                case 2 -> {
                    System.out.println("Create User: ");
                    System.out.println("Enter a new user in the format: id,name,author,short description");
                    dml.insert(ParserStringToBook.parse(sc.nextLine()));
                }
                case 3 ->{

                    temp.forEach(System.out::println);
                    System.out.println("Enter the id of the user you want to update: ");
                    System.out.println("Enter the user you want to change with the same id in the format: id,name,author,short description");
                    dml.update(ParserStringToBook.parse(sc.nextLine()));
                }
                case 4 ->{
                    System.out.println("Enter the id of the user you want to delete: ");
                    temp.forEach(System.out::println);
                    dml.delete(sc.nextInt());
                    sc.nextLine();
                }
                case 6 -> {
                    System.out.println("The work is completed!");
                    active = false;

                }
                default -> {
                    try {
                        throw new ValidException("The entered value is incorrect!");
                    } catch ( ValidException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
    }
}
