package pattern.builder;

public class Client {

    public static void main(String[] args) {

        // 创建指挥者用于组装摩拜单车
        Director director = new Director(new MobikeBuilder());
        Bike bike = director.construct();

        System.out.println(bike.getFrame());
        System.out.println(bike.getSeat());

    }
}
