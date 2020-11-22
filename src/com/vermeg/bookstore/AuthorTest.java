package com.vermeg.bookstore;

import com.vermeg.bookstore.model.Author;
import com.vermeg.bookstore.service.implementation.AuthorService;

import java.sql.SQLException;

public class AuthorTest {

    public static void main(String[] args) {

        AuthorService as = new AuthorService();
        try {

             as.addAuthor(new Author("Victor", "Hugo","26/02/1802","220px-Bonnat_Hugo001z"));

             as.addAuthor(new Author("bla bla", "Hba","26/02/1802","220px-Bonnat_Hugo001z"));


             System.out.println("SUPRESSION");
//             as.deleteAuthor(2);
            as.deleteAuthor(4);
            Author a = new Author(1,"victor","hugouo","26-02-1806","lien");
            as.updateAuthor(a);
            System.out.println(as.getAuthors());
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Exception" );
        }
}
}
