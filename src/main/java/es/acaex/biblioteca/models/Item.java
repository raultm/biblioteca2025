package es.acaex.biblioteca.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity(name = "items")
@Data
// @Builder
public class Item {
    
    public static final String LIBRO = "libro";
    public static final String DISCO = "disco";
    public static final String JUEGO = "juego";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String type;
    private String title;
    private String author;
    private String image;
    private float duration;
    @Column(name="minimum_age")
    private int minimumAge;
    // @Column(name="released_at")
    // @Temporal(TemporalType.DATE)
    // private Date releasedAt;
}
