package payload.responsebody;

import com.sun.org.apache.xpath.internal.operations.Bool;

public class Banner {
    private String title;
    private String description;
    private String additionalInfo;
    private String bannerType; //enum;
    private Boolean hasCloseButton;
    private Boolean isOptedIn;
    private Boolean isTrialEligible;
    private String freeDeliveryAvailable; // enum

    private boolean showBanner;
    private String buttonTitle;
    private boolean isOptInBanner;

    private Object optedInTitle;
    private Object optedInAdditionalInfo;
    private Object optedInButtonAnalyticsName;
    private Object optedInButtonTitle;

    private String buttonAnalyticsName;
    private ImageUrl imageUrl;
    private ButtonLink buttonLink;

    private String programType;
    private String programSubType;
    private Boolean isBelowMinimumPriceBanner;

    public class ButtonLink {
        private String linkText;
        private String title;
        private ClickThrough clickThrough;

        public class ClickThrough {
            private String value;
        }
    }

}
