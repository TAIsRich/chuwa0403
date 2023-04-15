package Q1.Encapsulation;

public class EncTest {
    public static void main(String[] args) {
        UserAccountBad bad = new UserAccountBad("bad", 0.0);
        UserAccountGood good = new UserAccountGood("good", 0.0);

        bad.username = "bad2";
        bad.balance = 100.0;

        good.setUsername("good2");
        good.setBalance(100.0);

        System.out.println(bad.username);
        System.out.println(bad.balance);

        System.out.println(good.getUsername());
        System.out.println(good.getBalance());
    }
}
