package com.vermeg.bookstore.model;

        import com.itextpdf.text.BadElementException;
        import com.itextpdf.text.DocumentException;
        import com.itextpdf.text.Element;
        import com.itextpdf.text.FontFactory;
        import com.itextpdf.text.Image;
        import com.itextpdf.text.Paragraph;
        import com.itextpdf.text.Phrase;
        import com.itextpdf.text.pdf.PdfWriter;
        import java.io.FileNotFoundException;
        import java.io.FileOutputStream;
        import java.io.IOException;
        import java.sql.SQLException;
        import java.util.concurrent.ThreadLocalRandom;
        import java.util.logging.Level;
        import java.util.logging.Logger;


public class PDF {
    public void pdf(Categorie p) throws SQLException, FileNotFoundException, DocumentException, BadElementException, IOException {
        try {
            // System.out.println("Haouet------------------------------------->"+nom);

            // nextInt is normally exclusive of the top value,
            // so add 1 to make it inclusive
            int randomNum = ThreadLocalRandom.current().nextInt(1, 100 + 1);

            com.itextpdf.text.Document document = new com.itextpdf.text.Document();
            PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\nouha\\Desktop\\bookstoreProject\\bookstoreDesktop\\" + randomNum + ".pdf"));
            document.open();
            Paragraph adrr = new Paragraph(new Phrase("Libelle : "+p.getLibelle(), FontFactory.getFont(FontFactory.HELVETICA, 12)));
            Paragraph adrr1 = new Paragraph(new Phrase("Description  : "+p.getDescription(), FontFactory.getFont(FontFactory.HELVETICA, 12)));
            Paragraph par=new Paragraph(" votre Catégorie  ", FontFactory.getFont(FontFactory.TIMES));
            par.setAlignment(Element.ALIGN_CENTER);
            document.add(par);

            document.add(adrr);
            document.add(adrr1);
            document.add(new Paragraph("date ajout de catégorie  : "+p.getDateajout(), FontFactory.getFont(FontFactory.TIMES)));
            document.add(new Paragraph("date modification de catégorie : "+p.getDatemodif(), FontFactory.getFont(FontFactory.TIMES)));


            document.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(PDF.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
