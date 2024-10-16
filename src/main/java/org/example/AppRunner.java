package org.example;

import org.example.Service.BookDMLService;
import org.example.Service.BookDQLService;
import org.example.CustomException.ValidException;
import org.example.Loggers.Logger;
import org.example.Models.Book;

import org.example.util.ParserStringToBook;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

@Component
public class AppRunner {
    private final BookDMLService dml;
    private final BookDQLService dql;
    private final Logger logger;
    private final MessageSource messageSource;
    public static String lang;


    @Autowired
    public AppRunner(@Qualifier("bookServiceImpl") BookDMLService dml, @Qualifier("bookServiceImpl") BookDQLService dql, Logger logger, MessageSource messageSource) {
        this.dml = dml;
        this.dql = dql;
        this.logger = logger;
        this.messageSource = messageSource;
    }

    public void run() {

        Scanner sc = new Scanner(System.in);
        logger.print(messageSource.getMessage("application.startMessage",null,null));
        lang = sc.nextLine();

        boolean active = true;

        while (active) {


            logger.print(messageSource.getMessage("application.headerMenu",null, Locale.forLanguageTag(lang)));


            validNumber(sc);
//            while (!sc.hasNextInt()) {
//                logger.print(messageSource.getMessage("validation.enteringIntegerNumber",null,Locale.forLanguageTag(lang) ));
//                sc.nextLine();
//            }

            int idOperation = sc.nextInt();
            sc.nextLine();
            List<Book> temp = dql.findAll();

            switch (idOperation) {
                case 1 -> temp.forEach(user -> logger.print(user.toString()));
                case 2 -> {

                    logger.print(messageSource.getMessage("application.titleFindById",null,Locale.forLanguageTag(lang)));
                    validNumber(sc);
                    Book tempBook = dql.findById(sc.nextInt());
                    logger.print(tempBook.toString());
                    sc.nextLine();
                }
                case 3 -> {
                    logger.print(messageSource.getMessage("application.titleCreate",null, Locale.forLanguageTag(lang)));
                    dml.insert(ParserStringToBook.parse(sc.nextLine()));
                }
                case 4 ->{

                    temp.forEach(user -> logger.print(user.toString()));
                    logger.print(messageSource.getMessage("application.titleUpdate",null,Locale.forLanguageTag(lang)));
                    dml.update(ParserStringToBook.parse(sc.nextLine()));
                }
                case 5 ->{
                    logger.print(messageSource.getMessage("application.titleDelete",null,Locale.forLanguageTag(lang)));
                    temp.forEach(user -> logger.print(user.toString()));
                    dml.delete(sc.nextInt());
                    sc.nextLine();
                }
                case 6 -> {
                    logger.print(messageSource.getMessage("application.titleExit",null,Locale.forLanguageTag(lang)));
                    active = false;

                }
                default -> {
                    try {
                        throw new ValidException(messageSource.getMessage("exceptionMessage.validException",null,Locale.forLanguageTag(lang)));
                    } catch ( ValidException e) {
                        logger.print(e.getMessage());
                    }
                }
            }
        }
    }


    private void validNumber(Scanner sc){
        while (!sc.hasNextInt()) {
            logger.print(messageSource.getMessage("validation.enteringIntegerNumber",null,Locale.forLanguageTag(lang) ));
            sc.nextLine();
        }
    }
}
