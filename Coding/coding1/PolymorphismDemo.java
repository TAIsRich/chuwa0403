package coding1;

public class PolymorphismDemo {
    public void main(String[] args) {
        Birds penguin = new Penguin();
        penguin.skill();

        Birds ostrich = new Ostrich();
        ostrich.skill();
        //ostrich.skill("biggest");

    }

    abstract class Birds {
        public abstract void skill();

    }

    class Penguin extends Birds {
        @Override
        public void skill() {
            System.out.println("swim");
        }
    }

    class Ostrich extends Birds {
        @Override
        public void skill() {
            System.out.println("run");
        }

        public void skill(String word) {
            System.out.println("Ostrich egg is" + word);
        }
    }
}
