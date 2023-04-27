package response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MatchedTrigger {
    private PageType pageType;
    private Integer pageId;
    private String zone;
    private boolean inheritable;

}

enum PageType{
    PostCartLoadPage
}