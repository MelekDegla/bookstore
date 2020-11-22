package com.vermeg.bookstore;

import com.vermeg.bookstore.model.Categorie;
import com.vermeg.bookstore.service.implementation.CategorieService;

import java.sql.SQLException;

public class CategorieTest {

    public static void main(String[] args) {
//        launch(args);
        CategorieService cs = new CategorieService();
        try {
            //System.out.println(cs.getCategories());

           /* cs.addCategorie(new Categorie("Horror",
                    "An horror film is one that seeks to elicit fear in its audience for entertainment" +
                            " purposes. Horror films additionally aim to evoke viewers nightmares, fears," +
                            " revulsions and terror of the unknown and macabre."));*/
            cs.addCategorie(new Categorie("Romantic",
                    "Romance films or romance movies are romantic love stories recorded in visual" +
                            " media for broadcast in theaters and on TV that focus on passion, emotion, and the" +
                            " affectionate romantic involvement of the main characters and the journey that " +
                            "their love takes them through dating, courtship or marriage. Romance films make" +
                            " the romantic love story or the search for strong and pure love and romance the" +
                            " main plot focus"));
            cs.addCategorie(new Categorie("Adventure",
                    "Adventure films are a genre of film whose plots feature elements of travel." +
                            " They typically involve protagonists who must leave their home or place of comfort" +
                            " and go to far away lands to fulfill a goal. Settings play an important role " +
                            "in Adventure films, sometimes as big as the characters themselves."));
            cs.deleteCategorie(9);
           /* System.out.println("*************************************");
            System.out.println(cs.getCategories());
            cs.addCategorie(new Categorie("bla bla","bla bla"));
            System.out.println("SUPRESSION");

            System.out.println(cs.getCategories());*/

            /*Categorie c = new Categorie("Comedy",
                    "This category is reserved for films that make people laugh. The judges are looking" +
                            " for films that have funny moments, comedic situations, fun dialogue," +
                            " humorous acting, and great characters. This event has screened great musicals," +
                            " sketch comedy, stand-up comedy, family comedy, silent comedy, slapstick comedy," +
                            " romantic comedy, action comedy, student comedy, mockumentary, web series episodes," +
                            " comedy TV pilots, fake commercials and more at our past events.");
            cs.addCategorie(c);*/
            Categorie c = new Categorie(5, "Comedy moviesss", "This category is reserved for films that make people laugh. The judges are looking" +
                    " for films that have funny moments, comedic situations, fun dialogue," +
                    " humorous acting, and great characters. This event has screened great musicals," +
                    " sketch comedy, stand-up comedy, family comedy, silent comedy, slapstick comedy," +
                    " romantic comedy, action comedy, student comedy, mockumentary, web series episodes," +
                    " comedy TV pilots, fake commercials and more at our past events.");
            cs.updateCategorie(c);


        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Exception");
        }
    }
}


