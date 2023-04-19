package hw3.design_credit_card;

import java.util.HashMap;

public interface ContentFactory {
    public Content createContent();
    public HashMap<String, String> getMap();
    public void addInfo(String s, String v);

}
