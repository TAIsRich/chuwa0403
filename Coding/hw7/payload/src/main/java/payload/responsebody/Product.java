package payload.responsebody;

import sun.jvm.hotspot.debugger.ProcessInfo;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

public class Product {
    private String id;
    private BigInteger offerId;
    private int orderLimit = 12;
    private int weightIncrement;
    private String fulfillmentType;
    private String availabilityStatus; //enum
    private boolean showAtc;
    private boolean showOptions;
    private String canonicalUrl;
    private String name;
    private BigInteger usItemId;
    private BigInteger ussellerIdtemId;
    private String sellerName;
    private boolean hasSellerBadge;
    private String fulfillmentSpeed;
    private float averageRating;
    private String unitQuantity;
    private String type;
    private ImageInfo imageInfo;
    private PreOrder preOrder;
    private PriceInfo priceInfo;
    private Badges badges;
    private Object sponsoredProduct;

    public class Badges {
        private String flags;
        private List<String> labels;
        private List<Tag> tags;
        public class Tag {
            private String key;
            private String text;
        }
    }

    public class PriceInfo {
        private PriceDisplayCodes priceDisplayCodes;
        private boolean wasPrice;
        private UnitPrice unitPrice;
        private String priceRange;
        private CurrentPrice currentPrice;
        private String shipPrice;

        public class CurrentPrice {
            private String priceString;
            private String priceDisplay;
        }

        public class  UnitPrice {
            private String priceString;
        }
        public class PriceDisplayCodes {
            private Double finalCostByWeight;
            private String priceDisplayCondition;
        }
    }
    public class ImageInfo {
        private String thumbnailUrl;
    }

    public class PreOrder {
        private Date streetDate;
        private Boolean streetDateDisplayable;
        private String streetDateType;
        private boolean isPreOrder;
        private String preOrderMessage;
        private String preOrderStreetDateMessage;
    }

}
