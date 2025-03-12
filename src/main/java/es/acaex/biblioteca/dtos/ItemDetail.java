package es.acaex.biblioteca.dtos;

import java.util.List;

import es.acaex.biblioteca.models.Item;
import lombok.Data;

@Data
public class ItemDetail {

    private Long id;
    private String type;
    private String title;
    private String author;
    private String image;
    private float duration;
    private int minimumAge;

    public static ItemDetail fromItem(Item item) {
        ItemDetail itemDetail = new ItemDetail();
        itemDetail.setId(item.getId());
        itemDetail.setType(item.getType());
        itemDetail.setTitle(item.getTitle());
        itemDetail.setAuthor(item.getAuthor());
        itemDetail.setDuration(item.getDuration());
        itemDetail.setMinimumAge(item.getMinimumAge());

        return itemDetail;
    }

    public static List<ItemDetail> fromItemsList(List<Item> items) {
        return items.stream().map(ItemDetail::fromItem).toList();
    }
}
