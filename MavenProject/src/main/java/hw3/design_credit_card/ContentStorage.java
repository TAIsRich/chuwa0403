package hw3.design_credit_card;

import java.util.HashMap;

public class ContentStorage {
    private ContentFactory factory;

    public void setFactory(ContentFactory factory){
        this.factory = factory;
    }

    public Content pickContent(HashMap<String, String> map){
        Content content = factory.createContent();
        content.modify(map);
        return content;
    }
}

