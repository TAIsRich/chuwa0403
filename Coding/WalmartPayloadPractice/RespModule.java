package Coding.WalmartPayloadPractice;

import Coding.WalmartPayloadPractice.enums.modules.Status;
import Coding.WalmartPayloadPractice.enums.modules.Type;

import java.sql.Timestamp;

public class RespModule {
    private String name;
    private Type type;
    private String version;
    private Status status;
    private RespSchedule schedule;
    private Timestamp publishedDate;
    private String moduleId;
    private String module_id;
    private RespMatchedTrigger matchedTrigger;
}
