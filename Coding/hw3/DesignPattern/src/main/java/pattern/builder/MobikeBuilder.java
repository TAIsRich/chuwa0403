package pattern.builder;

// 具体的构建者，用于构建摩拜单车

public class MobikeBuilder extends Builder {
    @Override
    public void buildFrame() {
        bike.setFrame("碳纤维");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("真皮");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}
