package com.vermeg.bookstore;

import com.vermeg.bookstore.model.PBook;
import com.vermeg.bookstore.service.implementation.ServicePBook;

import java.sql.SQLException;

public class PaperBookTest {
    public static void main(String[] args) {
        ServicePBook servicePBook=new ServicePBook();

        try {

            System.out.println(servicePBook.findAll());
            servicePBook.insert(new PBook(1,2,"54q54DQFHNQKLS","ggg",
                    "","",444,556));
            servicePBook.insert(new PBook(2,2,"54jjjjDQFHNQKLS","ggg",
                    "","",444,556));
            servicePBook.insert(new PBook(3,2,"54q54DQFooooNQKLS","ggg",
                    "","",444,556));
            System.out.println("*************************************");
            System.out.println(servicePBook.findAll());

               System.out.println("SUPRESSION");
             servicePBook.deleteByISBN(   "54q54DQFHNQKLS");
              System.out.println(servicePBook.findAll());
            PBook p = new PBook(19,2,"54q54DQFHNQKLS","ppppppppppppppppp",
                    "ppppppppppppppp","ppppppppppppppppp",444,556);
            servicePBook.update(p);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
