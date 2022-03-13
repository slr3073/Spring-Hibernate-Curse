package doremi.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@Entity
public class Album {

    @Id
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String title;

    private Genre genre;

    @Min(1950)
    @Max(2022)
    private int year;

    public Album(String title, Genre genre, int year) {
        this.title = title;
        this.genre = genre;
        this.year = year;
    }
}
