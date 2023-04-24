import java.util.List;

public class Payload {
    private P13n p13n;
    private boolean enableWplusCashbackValue;
    private boolean enableWplusBannersPostCartLoadPageValue;
    private boolean enableWplusRetentionNudge;
    private boolean enableGenericWalmartCash;
    private boolean enableGenericPageContext;
    private String tenant;

    public P13n getP13n() {
        return p13n;
    }

    public void setP13n(P13n p13n) {
        this.p13n = p13n;
    }

    public boolean isEnableWplusCashbackValue() {
        return enableWplusCashbackValue;
    }

    public void setEnableWplusCashbackValue(boolean enableWplusCashbackValue) {
        this.enableWplusCashbackValue = enableWplusCashbackValue;
    }

    public boolean isEnableWplusBannersPostCartLoadPageValue() {
        return enableWplusBannersPostCartLoadPageValue;
    }

    public void setEnableWplusBannersPostCartLoadPageValue(boolean enableWplusBannersPostCartLoadPageValue) {
        this.enableWplusBannersPostCartLoadPageValue = enableWplusBannersPostCartLoadPageValue;
    }

    public boolean isEnableWplusRetentionNudge() {
        return enableWplusRetentionNudge;
    }

    public void setEnableWplusRetentionNudge(boolean enableWplusRetentionNudge) {
        this.enableWplusRetentionNudge = enableWplusRetentionNudge;
    }

    public boolean isEnableGenericWalmartCash() {
        return enableGenericWalmartCash;
    }

    public void setEnableGenericWalmartCash(boolean enableGenericWalmartCash) {
        this.enableGenericWalmartCash = enableGenericWalmartCash;
    }

    public boolean isEnableGenericPageContext() {
        return enableGenericPageContext;
    }

    public void setEnableGenericPageContext(boolean enableGenericPageContext) {
        this.enableGenericPageContext = enableGenericPageContext;
    }

    public String getTenant() {
        return tenant;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }

    public static class P13n {
        private UserClientInfo userClientInfo;
        private UserReqInfo userReqInfo;

        public UserClientInfo getUserClientInfo() {
            return userClientInfo;
        }

        public void setUserClientInfo(UserClientInfo userClientInfo) {
            this.userClientInfo = userClientInfo;
        }

        public UserReqInfo getUserReqInfo() {
            return userReqInfo;
        }

        public void setUserReqInfo(UserReqInfo userReqInfo) {
            this.userReqInfo = userReqInfo;
        }

        public static class UserClientInfo {
            private String deviceType;
            private String callType;

            public String getDeviceType() {
                return deviceType;
            }

            public void setDeviceType(String deviceType) {
                this.deviceType = deviceType;
            }

            public String getCallType() {
                return callType;
            }

            public void setCallType(String callType) {
                this.callType = callType;
            }
        }

        public static class UserReqInfo {
            private int preferredStoreId;
            private List<Integer> storeIds;
            private CartContext cartContext;
            private List<String> requestType;

            public int getPreferredStoreId() {
                return preferredStoreId;
            }

            public void setPreferredStoreId(int preferredStoreId) {
                this.preferredStoreId = preferredStoreId;
            }

        }
    }
}