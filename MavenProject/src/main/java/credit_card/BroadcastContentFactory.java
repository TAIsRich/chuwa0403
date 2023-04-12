package credit_card;

public class BroadcastContentFactory implements ContentFactory {

    @Override
    public Content generateContent(User user) {
        return new BroadCastContent("40% off when you buy Popeyes between 06/13 - 06/19");
    }
}
