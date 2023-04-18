package hw3.design_credit_card;

import java.util.HashMap;
import java.util.Map;

public class RegisterContentFactory implements ContentFactory {

    private HashMap<String, String> map= new HashMap<>();

    @Override
    public Content createContent() {
        RegisterContent content =  new RegisterContent();
        content.modify(map);
        return content;
    }

    @Override
    public HashMap<String, String> getMap() {

        return map;
    }

    @Override
    public void addInfo(String s, String v) {
        map.put(s, v);
    }



}
