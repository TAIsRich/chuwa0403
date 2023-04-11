package MyCreaditCardDesign;

public class CreditCardUser implements UserObserver {
    private String name;
    private String preferenceType;

    public CreditCardUser(String name, String preferenceType) {
        this.name = name;
        this.preferenceType = preferenceType;
    }

    @Override
   public void receivePrivateNotification(String message) {
        System.out.println("Hey " + name.split("/s")[0] + message);
   }

    @Override
    public void receivePublicNotification(String message) {
        System.out.println(this.name + " received " + this.preferenceType +" message : " + message);

    }

    @Override
    public String getPreference() {
        return this.preferenceType;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
