package doremi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article {

    @PositiveOrZero
    private int articleId;

    @NotEmpty
    private String title;
    private String category;
}
