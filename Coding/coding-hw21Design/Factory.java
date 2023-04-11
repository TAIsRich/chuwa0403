package designhw3;

public class Factory {
    public static NotiType getPlan(String notiType) {
        if (notiType == null) {
            return null;
        }
        if (notiType.equalsIgnoreCase("EMAIL")) {
            return new Email();
        } else if (notiType.equalsIgnoreCase("SMS")) {
            return new SMS();
        } else if (notiType.equalsIgnoreCase("WHATSAPP")) {
            return new WhatsApp();
        }
        return null;
    }
}
