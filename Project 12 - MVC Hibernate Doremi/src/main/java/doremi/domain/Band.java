package doremi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
public class Band {
    @NotEmpty
    private String name;
    private boolean active;
}
