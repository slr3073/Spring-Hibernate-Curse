package doremi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Album {
    private String title;
    private final Genre genre;
    private final int year;
}
