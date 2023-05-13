package response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Definition {
    private DefinitionType type;
    private String flow;

    private List<DefinitionContent> content;
}

enum DefinitionType{
    container
}