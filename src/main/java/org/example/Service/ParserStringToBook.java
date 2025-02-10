package org.example.Service;

import org.example.Models.Book;

public class ParserStringToBook {

    public static Book parse(String str){
        String[] temp = str.trim().split(",");
        return new Book(Integer.parseInt(temp[0]),
                            temp[1],
                            temp[2],
                            temp[3]);

    }
}
