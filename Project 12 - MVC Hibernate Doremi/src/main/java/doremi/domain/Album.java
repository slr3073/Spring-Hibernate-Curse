package doremi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
public class Album {
    @NotNull
    private String title;
    private final Genre genre;

    @Min(1950)
    @Max(2022)
    private final int year;
}
