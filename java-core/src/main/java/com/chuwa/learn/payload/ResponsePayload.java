package com.chuwa.learn.payload;

import java.util.List;

public class ResponsePayload {
    private Data data;

    public static class Data {
        private ContentLayout contentLayout;
    }

    public static class ContentLayout {
        private PageMetadata pageMetadata;
        private List<Module> modules;

        private List<Layout> layouts;
    }

    public static class PageMetadata {
        private Object athPage;
    }

    public static class Module {
        private String name;
        private String type;
        private int version;
        private String status;
        private Schedule schedule;
        private Configs configs;
        private long publishedDate;
        private String moduleId;
        private String module_id;
        private MatchedTrigger matchedTrigger;
    }

    public static class Schedule {
        private Object start;
        private Object end;
        private int priority;
        private boolean expEnabled;
    }

    public static class Configs {
        private List<Banner> banners;
        private String title;
        private TileOptions tileOptions;
        private Object spBeaconInfo;
        private List<Product> products;
    }

    public static class Banner {
        private String title;
        private String description;
        private String additionalInfo;
        private String bannerType;
        private String hasCloseButton;
        private String isOptedIn;
        private String isTrialEligible;
        private String freeDeliveryAvailable;
        private String planInfo;
        private String strikeString;
        private String showBanner;
        private String buttonTitle;
        private String isOptInBanner;
        private String optedInTitle;
        private String optedInAdditionalInfo;
        private String optedInButtonAnalyticsName;
        private String optedInButtonTitle;
        private String buttonAnalyticsName;
        private ImageURL imageURL;
        private ButtonLink buttonLink;
        private String programType;
        private Object programSubType;
        private String isBelowMinimumPriceBanner;
    }

    public static class TileOptions {
        private String fulfillmentBadging;
        private String averageRatings;
        private String productFlags;
    }

    public static class Product {
        private String id;
        private String offerId;
        private int orderLimit;
        private int weightIncrement;
        private String fulfillmentType;
    }

    public static class ImageURL {
        private String title;
        private String src;
        private String alt;
        private String height;
        private String width;
    }

    public static class ButtonLink {
        private String linkText;
        private String title;
        private ClickThrough clickThrough;
    }

    public static class ClickThrough {
        private String value;
        private String title;
    }

    public static class MatchedTrigger {
        private String pageType;
        private Object pageId;
        private String zone;
        private boolean inheritable;
    }

    public static class Layout {
        private String id;
        private LayoutDetail layout;
        private Channel channel;
        private String version;
        private String status;

        public static class LayoutDetail {
            private String type;
            private String name;
            private Definition definition;

            public static class Definition {
                private String type;
                private String flow;
                private List<Content> content;

                public static class Content {
                    private String type;
                    private String flow;
                    private Object content;
                }
            }
        }

        public static class Channel {
            private String id;
            private String status;
        }
    }

}

