package com.vermeg.bookstore;

import com.vermeg.bookstore.model.PBook;
import com.vermeg.bookstore.service.ServicePBook;

import java.sql.SQLException;

public class PaperBookTest {
    public static void main(String[] args) {
        ServicePBook servicePBook=new ServicePBook();

        try {

            System.out.println(servicePBook.getPBooks());
            servicePBook.addPBook(new PBook(1,2,"54q54DQFHNQKLS","ggg",
                    "","",444,556));
            servicePBook.addPBook(new PBook(2,2,"54jjjjDQFHNQKLS","ggg",
                    "","",444,556));
            servicePBook.addPBook(new PBook(3,2,"54q54DQFooooNQKLS","ggg",
                    "","",444,556));
            System.out.println("*************************************");
            System.out.println(servicePBook.getPBooks());

               System.out.println("SUPRESSION");
             servicePBook.deletePBook(   "54q54DQFHNQKLS");
              System.out.println(servicePBook.getPBooks());
            PBook p = new PBook(19,2,"54q54DQFHNQKLS","ppppppppppppppppp",
                    "ppppppppppppppp","ppppppppppppppppp",444,556);
            servicePBook.updatePBook(p);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
