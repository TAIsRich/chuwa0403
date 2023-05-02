package hw7.payload.response_body;

import java.util.Date;

public class ModuleDto {
    private String name;
    private String type;
    private int version;
    // should be not null
    private String status;
    private Schedule schedule;
    private ConfigsDto1 configs;
    private ConfigsDto2 configs2;
    private ConfigsDto3 configs3;
    private Date publishedDate;
    private String moduleId;
    private MatchedTrigger matchedTrigger;

}

class Schedule{
    private Date start;
    private Date end;
    private int priority;
    private Boolean expEnabled;
}

class MatchedTrigger{
    private String pageType;
    private String pageId;
    private String zone;
    private Boolean inheritable;

}


