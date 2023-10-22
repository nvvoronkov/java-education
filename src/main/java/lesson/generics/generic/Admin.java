package lesson.generics.generic;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Admin extends Human {
    @Override
    public String getName() {
        return "Admin";
    }
}
