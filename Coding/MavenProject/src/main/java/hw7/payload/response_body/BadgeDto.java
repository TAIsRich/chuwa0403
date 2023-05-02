package hw7.payload.response_body;

import java.util.List;

public class BadgeDto {
    private String flags;
    private List<String> labels;
    private List<Tag> tags;
}

class Tag{
    private String key;
    private String text;
}
