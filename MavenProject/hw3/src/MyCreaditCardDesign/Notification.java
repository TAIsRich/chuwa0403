package MyCreaditCardDesign;

import java.util.ArrayList;
import java.util.List;

public class Notification implements CreditCardSubject {
    private List<UserObserver> CreditCardUserList = new ArrayList<UserObserver>();

    @Override
    public void attach(UserObserver observer) {
        CreditCardUserList.add(observer);

    }

    @Override
    public void notifyPrivate(String name,String preferenceType, String message) throws Exception {
        if(preferenceType.equals("SMS") || preferenceType.equals("EMAIL") || preferenceType.equals("WHATSAPP")) {
            for (UserObserver observer : CreditCardUserList) {
                if (observer.getName().equals(name)) {
                    if (observer.getPreference().equals(preferenceType)) {
                        observer.receivePrivateNotification(message);
                    } else {
                        throw new Exception("Preference type is not match !");
                    }
                }
            }
        }else{
            throw new Exception("No Such a preference type!");
        }
    }

    @Override
    public void notifyPublic(String message) {
         for(UserObserver observer:CreditCardUserList){
             observer.receivePublicNotification(message);
         }
    }
}

