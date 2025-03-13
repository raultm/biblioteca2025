package es.acaex.biblioteca.dtos;

import java.time.LocalDate;

import es.acaex.biblioteca.models.Item;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemCreate {

    private String type;
    private String title;
    private String author;
    private String image;
    private int duration;
    private int minimumAge;
    private LocalDate releasedAt;
    private int numCopias;

    public Item toItem() {
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
