package response;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Layout {
    private LayoutType type;
    private String name;
    private Definition definition;
    private LayoutChannel channel;
    private String version;
    private LayoutStatus status;
}

enum LayoutType{
    base
}

enum LayoutStatus{
    ACTIVE
}