package response;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class DefinitionContent {

    private DefinitionContentType type;
    private String flow;

    private DefContentContent content;
}

enum DefinitionContentType{
    container
}
