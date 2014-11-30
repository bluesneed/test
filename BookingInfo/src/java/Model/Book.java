/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author JiawenHuang
 */
public class Book {
   private String title;
   private  String author;
   private  String publisher;
   private  String topic;
   private Float price;
   private String comment;

    public Book() {
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getTopic() {
        return topic;
    }

    public Float getPrice() {
        return price;
    }
    
    public String getComment(){
        return comment;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
    
    
    public void setCommnet(String comment) {
        this.comment = comment;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
    
    
   
   
   
    
    
}
