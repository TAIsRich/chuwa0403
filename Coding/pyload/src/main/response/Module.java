package response;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class Module {
    private String name;
    private ModuleType type;
    private Integer version;
    private Status status;
    private Schedule schedule;
    private ModuleConfig configs;
    private Timestamp publishedDate;
    private String moduleId;
    private String module_id;
    private MatchedTrigger matchedTrigger;

}
enum ModuleType{
    CartWplusBanner,CartBookslotWalmartPlusBanner,SmartNudgesModule,WalmartRewards
}
enum Status{
    published
}