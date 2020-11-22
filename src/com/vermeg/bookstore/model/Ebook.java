package com.vermeg.bookstore.model;

public class Ebook {
        int id, author;
        String  title, description , fileURL,photo;
        float price ;

    public Ebook()
    {}
    public Ebook(int id , int author, String title , String description, String fileURL, String photo, float price)
    {
        this.id=id;
        this.author=author;
        this.title=title;
        this.description=description;
        this.fileURL=fileURL;
        this.photo=photo;
        this.price=price;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title= title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFileURL() {
        return fileURL;
    }

    public void setFileURL(String fileURL) {
        this.fileURL = fileURL;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Ebook{" +
                "id=" + id +
                ", author=" + author +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", fileURL='" + fileURL + '\'' +
                ", photo='" + photo + '\'' +
                ", price=" + price+
                '}';
    }
}
