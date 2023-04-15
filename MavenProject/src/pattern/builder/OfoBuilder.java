package MavenProject.src.pattern.builder;

public class OfoBuilder extends Builder{
    @Override
    public void buildFrame() {
        bike.setFrame("frame2");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("seat2");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}
