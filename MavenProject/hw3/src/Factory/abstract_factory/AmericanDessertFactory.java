package Factory.abstract_factory;

public class AmericanDessertFactory implements DessertFactory {
    @Override
    public Coffee createCoffee() {
        return new AmericanCoffee();
    }
    public Dessert createDessert(){
        return new MatchMousse();
    }
}
