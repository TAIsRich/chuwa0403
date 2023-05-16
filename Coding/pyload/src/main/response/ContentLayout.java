package response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ContentLayout {
    private PageMetadata pageMetadata;
    private List<Module> modules;
    private List<Layouts> layouts;
}
