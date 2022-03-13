package doremi.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Band {

    @Id
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String name;
    private boolean active;

    @OneToMany(mappedBy = "band")
    private List<Album> albums = new ArrayList<>();

    public Band(String name, boolean active) {
        this.name = name;
        this.active = active;
    }

    public boolean getActive(){
        return active;
    }

    public void addAlbum(Album a) {
        if (albums.contains(a)) return;

        albums.add(a);
        a.setBand(this);
    }

    public void removeAlbum(Album a) {
        albums.remove(a);
        a.setBand(null);
    }
}
