package payload.responsebody;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

public class Module {
    private String name;
    private String type;
    private Integer version;
    private String status; //enum
    private Schedule schedule;
    private BigInteger publishedDate;
    private String moduleId;

    private MatchedTrigger matchedTrigger;

    public class MatchedTrigger {
        private String pageType;
        private String pageId;
        private String zone;
        private boolean inheritable;
    }

    public class Schedule {
        private Date start;
        private Date end;
        private Integer priority;
        private Boolean expEnabled;
    }

    public class Configs {
        private List<Banner> banners;
        private String title;
        private TitleOptions titleOptions;
        private SpBeaconInfo spBeaconInfo;
        private List<Product> products;

        public class SpBeaconInfo {

        }

        public class TitleOptions {
            private boolean fulfillmentBadging;
            private boolean averageRatings;
            private boolean productFlags;
        }
    }
}
