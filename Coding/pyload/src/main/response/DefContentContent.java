package response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DefContentContent {
    private DefContentContentType type;
    private String flow;

    private List<Mapping> mappings;
}

enum DefContentContentType{
    slot
}
