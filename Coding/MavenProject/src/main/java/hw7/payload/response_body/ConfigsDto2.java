package hw7.payload.response_body;

import java.util.List;

public class ConfigsDto2 {
    private String title;
    private TitleOptions titleOptions;
    private String spBeaconInfo;
    private List<ProductDto> products;

}

class TitleOptions{
    private String fulfillmentBadging;
    private String averageRatings;
    private String productFlags;
}
