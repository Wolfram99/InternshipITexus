package org.example.util;

import org.example.Models.Book;

public class ParserStringToBook {

    public static Book parse(String str){
        String[] temp = str.trim().split(",");
        return new Book(Integer.parseInt(temp[0]),
                            temp[1],
                            temp[2],
                            Integer.parseInt(temp[3]),
                            Integer.parseInt(temp[4]),
                            Integer.parseInt(temp[5]),
                            Integer.parseInt(temp[6]),
                            Integer.parseInt(temp[7]));

    }
}
