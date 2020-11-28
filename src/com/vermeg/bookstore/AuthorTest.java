package com.vermeg.bookstore;

import com.vermeg.bookstore.model.Author;
import com.vermeg.bookstore.service.implementation.AuthorService;

import java.sql.SQLException;

public class AuthorTest {

    public static void main(String[] args) {

        AuthorService as = new AuthorService();
        try {

             as.insert(new Author("Victor", "Hugo","2020-12-12","220px-Bonnat_Hugo001z"));

             as.insert(new Author("bla bla", "Hba","2020-12-11","220px-Bonnat_Hugo001z"));


             System.out.println("SUPRESSION");
//             as.deleteAuthor(2);
            as.deleteById(4);
            Author a = new Author(1,"victor","hugouo","26-02-1806","lien");
            as.update(a);
            System.out.println(as.findAll());
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Exception" );
        }
}
}
