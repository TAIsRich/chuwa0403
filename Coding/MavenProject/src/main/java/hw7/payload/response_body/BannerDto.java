package hw7.payload.response_body;

import java.util.List;

public class BannerDto {
    private String title;
    private String description;
    private String additionalInfo;
    private String bannerType;
    private Boolean hasCloseButton;
    private Boolean isOptedIn;
    private Boolean isTrialEligible;
    private String freeDeliveryAvailable;

    private String planInfo;
    private String strikeString;
    private Boolean showBanner;
    private String buttonTitle;
    private Boolean isOptInBanner;
    private String optedInTitle;
    private String optedInAdditionalInfo;
    private String optedInButtonAnalyticsName;
    private String optedInButtonTitle;
    private String buttonAnalyticsName;
    private List<ImageURLDto> imageURL;
    private ButtonLink buttonLink;

    private String programType;
    private String programSubType;
    private Boolean isBelowMinimumPriceBanner;





}

class ButtonLink{
    private String linkText;
    private String title;
    private ClickThrough clickThrough;
}

class ClickThrough{
    private String value;
}
