package hw7.payload.response_body;

import java.util.Date;
import java.util.List;

public class ProductDto {
    private String id;
    private String offerId;
    private Integer orderLimit;
    private Integer weightIncrement;
    private String fulfillmentType;
    private String availabilityStatus;
    private Boolean showAtc;
    private Boolean showOptions;
    private String canonicalUrl;

    private String name;
    private String usItemId;
    private String sellerId;
    private String sellerName;
    private Boolean hasSellerBadge;
    private String fulfillmentSpeed;

    private Double averageRating;
    private Integer unitQuantity;
    private String type;
    private ImageInfo imageInfo;

    private Preorder preorder;
    private PriceInfo priceInfo;
    private BadgeDto badges;

    private ProductDto sponsoredProduct;

}

class ImageInfo{
    private String thumbnailUrl;
}

class Preorder{
    private Date streetDate;
    private Boolean streetDateDisplayable;
    private String streetDateType;
    private Boolean isPreOrder;

    private String preOrderMessage;

    private String preOrderStreetDateMessage;

}

class PriceInfo{
    private PriceDisplayCodeDto priceDisplayCodes;
    private Double wasPrice;
    private PriceDto unitPrice;
    private String priceRange;
    private PriceDto currentPrice;
    private PriceDto shipPrice;

}

class PriceDisplayCodeDto{
    private String finalCostByWeight;
    private String priceDisplayCondition;
}

