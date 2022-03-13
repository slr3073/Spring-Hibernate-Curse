package doremi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Band {
    private String name;
    private boolean active;
}
