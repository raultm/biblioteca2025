package es.acaex.biblioteca.dtos;

import es.acaex.biblioteca.models.Item;
import jakarta.persistence.Column;
import lombok.Data;

@Data
public class ItemCreate {
    
    private String type;
    private String title;
    private String author;
    private String image;
    private float duration;
    private int minimumAge;

    public Item toItem(){
        Item item = new Item();
        item.setType(type);
        item.setTitle(title);
        item.setAuthor(author);
        item.setImage(image);
        item.setDuration(duration);
        item.setMinimumAge(minimumAge);
        return item;
    }
}
