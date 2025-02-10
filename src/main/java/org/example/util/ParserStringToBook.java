package org.example.util;

import org.bson.types.ObjectId;
import org.example.Entity.Author;
import org.example.Entity.Book;
import org.example.Entity.CoverType;
import org.example.Entity.Genre;

public class ParserStringToBook {

    public static Book parse(String str){
        String[] temp = str.trim().split(",");
//        return new Book(Integer.parseInt(temp[0]),
//                            temp[1],
//                            temp[2],
//                            new Author(Integer.parseInt(temp[3]),null,null,null,null),
//                            new Genre(Integer.parseInt(temp[4]),null),
//                            Integer.parseInt(temp[5]),
//                            Integer.parseInt(temp[6]),
//                            new CoverType(Integer.parseInt(temp[7]),null),
//                            new ObjectId());
//

        return null;
    }


}
