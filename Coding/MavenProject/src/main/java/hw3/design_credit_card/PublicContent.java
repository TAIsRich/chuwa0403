package hw3.design_credit_card;

import java.util.HashMap;

public class PublicContent extends Content {


    private String content = "40% off when you buy Popeyes between 06/13 - 06/19";
    @Override
    public String getContent() {
        return content;
    }

    @Override
    public void modify(HashMap<String, String> map) {
        for(String s: map.keySet()){
            content.replace(s, map.get(s));
        }
    }
}
