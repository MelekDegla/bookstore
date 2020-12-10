package com.vermeg.bookstore.service.implementation;

import com.vermeg.bookstore.model.PBook;
import com.vermeg.bookstore.service.IPBookService;
import com.vermeg.bookstore.utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;

public class ServicePBook implements IPBookService {
    private Connection cnx;
    public ServicePBook(){cnx = DBConnection.getInstance().getConnection();}



    public void insert(PBook PBook) throws SQLException {
    String request=" INSERT INTO `book` (`isbn`, `title`, `description`, `photo`, `price`, `quantity`)" +
            " VALUES ('"+  PBook.getIsbn()+ "','"+PBook.getTitle()+ "','"+
            PBook.getDescription()+ "','"+ PBook.getPhoto()+
            "',"+PBook.getPrice()+ ","+ PBook.getQuantity() + ")";
        Statement stm = cnx.createStatement();
        stm.executeUpdate(request);
    }

    public ArrayList<PBook> findAll() throws SQLException {
        ArrayList<PBook> PBooks = new ArrayList<>();
        String request = "SELECT * FROM `book`";
        Statement stm = cnx.createStatement();
        ResultSet rst = stm.executeQuery(request);
        while (rst.next()) {
            PBook PBook = new PBook();
            PBook.setId(rst.getInt(1));
            PBook.setIsbn(rst.getString(2));
            PBook.setTitle(rst.getString(3));
            PBook.setDescription(rst.getString(4));
            PBook.setPhoto(rst.getString(5));
            PBook.setPrice(rst.getDouble(6));
            PBook.setQuantity(rst.getInt(7));
            PBooks.add(PBook);
        }
        return PBooks;
    }

    @Override
    public PBook findById(int id) throws SQLException {
        return null;
    }


    public PBook findById(String ISBN) throws SQLException {
    String request="SELECT * FROM `book`  WHERE isbn =" + ISBN ;
    Statement stm=cnx.createStatement();
    ResultSet rst=stm.executeQuery(request);
    if (rst.next()){
    PBook PBook= new PBook();
    PBook.setId(rst.getInt(1));
    PBook.setIsbn(rst.getString(2));
        PBook.setTitle(rst.getString(3));
        PBook.setDescription(rst.getString(4));
        PBook.setPhoto(rst.getString(5));
        PBook.setPrice(rst.getDouble(6));
        PBook.setQuantity(rst.getInt(7));
        return PBook;
    }
        return null;
    }

    public void update(PBook PBook) throws SQLException {
        String request = "UPDATE `book` SET `isbn` = ?, `title` = ?," +
                " `description` = ?, `photo` = ?, `price` = ?," +
                " `quantity` = ? WHERE `id` = ?;";
        PreparedStatement pst = cnx.prepareStatement(request);

        pst.setInt(7, PBook.getId());
        pst.setString(1, PBook.getIsbn());
        pst.setString(3, PBook.getDescription());
        pst.setString(4, PBook.getPhoto());
        pst.setDouble(5, PBook.getPrice());
        pst.setInt(6, PBook.getQuantity());
        pst.setString(2, PBook.getTitle());
        pst.executeUpdate();
    }

    @Override
    public void delete(PBook entity) throws SQLException {

    }

    @Override
    public void deleteById(int id) throws SQLException {

    }

    public void deleteByISBN(String ISBN)throws  SQLException{
            String request = "DELETE FROM `book` WHERE isbn ='" + ISBN + "'";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(request);
        }
}
