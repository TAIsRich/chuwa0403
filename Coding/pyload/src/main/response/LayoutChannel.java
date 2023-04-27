package response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LayoutChannel {
    private String id;
    private ChannelStatus status;
}

enum ChannelStatus{
    ACTIVE
}