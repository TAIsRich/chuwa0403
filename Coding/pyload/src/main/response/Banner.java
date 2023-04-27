package response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Banner {
    private String title;
    private String description;
    private String additionalInfo;
    private BannerType bannerType;
    private boolean hasCloseButton;
    private boolean isOptedIn;
    private boolean isTrialEligible;
    private FreeDeliveryAvailable freeDeliveryAvailable;

}

enum BannerType{
    shipping,delivery
}

enum FreeDeliveryAvailable{
    Any
}
