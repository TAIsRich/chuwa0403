package Coding.WalmartPayloadPractice;

import Coding.WalmartPayloadPractice.enums.banners.FreeDeliveryAvailable;
import Coding.WalmartPayloadPractice.enums.banners.Type;
import Coding.WalmartPayloadPractice.enums.modules.Plan;

public class RespBanner {
    private String title;
    private Plan planInfo;
    private String strikeString;
    private String description;
    private String additionalInfo;
    private Type bannerType;
    private String buttonTitle;
    private boolean showBanner;
    private Boolean hasCloseButton;
    private Boolean isOptedIn;
    private Boolean isTrialEligible;
    private FreeDeliveryAvailable freeDeliveryAvailable;
}
