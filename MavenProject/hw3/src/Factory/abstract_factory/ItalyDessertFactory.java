package Factory.abstract_factory;

public class ItalyDessertFactory implements DessertFactory{
    @Override
    public Coffee createCoffee() {
        return new LatteCoffee();
    }
    public Dessert createDessert(){
        return new Trimisu();
    }
}
