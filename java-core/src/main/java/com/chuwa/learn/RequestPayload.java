package com.chuwa.learn;


import java.util.List;

public class RequestPayload {
    private P13n p13n;
    private boolean enableWplusCashbackValue;
    private boolean enableWplusBannersPostCartLoadPageValue;
    private boolean enableWplusRetentionNudge;
    private boolean enableGenericWalmartCash;
    private boolean enableGenericPageContext;
    private String tenant;

    // getters and setters

    public static class P13n {
        private UserClientInfo userClientInfo;
        private UserReqInfo userReqInfo;

        // getters and setters

        public static class UserClientInfo {
            private String deviceType;
            private String callType;

            // getters and setters
        }

        public static class UserReqInfo {
            private int preferredStoreId;
            private List<Integer> storeIds;
            private CartContext cartContext;
            private List<String> requestType;

            // getters and setters

            public static class CartContext {
                private String cartIntent;
                private String slotType;
                private ThresholdInfo thresholdInfo;
                private String slotExpirationTime;
                private String slotExpirationTime_SC;
                private boolean isUnScheduledPickUp;
                private List<Item> items;

                // getters and setters

                public static class ThresholdInfo {
                    private int balanceToMinimumThreshold;
                    private Object belowMinFee;
                    private Object deliveryMinFee;

                    // getters and setters
                }

                public static class Item {
                    private String id;
                    private String availableQty;
                    private String fulfillmentType;
                    private double price;
                    private Object wasPrice;
                    private String fulfillmentGroup;
                    private List<String> badges;

                    // getters and setters
                }
            }
        }
    }
}
