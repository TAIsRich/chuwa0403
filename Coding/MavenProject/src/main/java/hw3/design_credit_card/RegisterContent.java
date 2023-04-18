package hw3.design_credit_card;

import java.util.HashMap;

public class RegisterContent extends Content{

    private String content = "Hey $name$, you have successfully registered to add and here is your ," +
            " please use this for future references.";

    public RegisterContent() {
    }

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
