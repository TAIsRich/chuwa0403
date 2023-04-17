public class ShoppingCartUtil {
    private static final List<String> ALTERNATIVE_ITEMS = Arrays.asList("Apple", "Orange", "Banana", "Grape");
    public static Optional<String> getFirstItemName(Customer customer) {
        return Optional.ofNullable(customer).map(Customer::getShoppingCart).map(ShoppingCart::getItems).filter(items -> !items.isEmpty()).map(items -> items.get(0)).map(Item::getName);
    }
    public static double getTotalPrice(Optional<Customer> customer) {
        return customer.map(Customer::getShoppingCart).map(ShoppingCart::getItems).map(items -> items.stream().mapToDouble(Item::getPrice).sum()).orElse(0.0);
    }
    public static String getFirstItemNameWithAlternative(Customer customer) {
        return Optional.ofNullable(customer).map(Customer::getShoppingCart).map(ShoppingCart::getItems).filter(items -> !items.isEmpty()).map(items -> items.get(0)).map(Item::getName).orElseGet(ShoppingCartUtil::getRandomAlternativeItem);
    }
    public static String getFirstItemNameOrThrowException(Customer customer) throws EmptyCartException {
        return Optional.ofNullable(customer).map(Customer::getShoppingCart).map(ShoppingCart::getItems).filter(items -> !items.isEmpty()).map(items -> items.get(0)).map(Item::getName).orElseThrow(() -> new EmptyCartException("empty cart"));
    }
    public static void checkItemsInCart(Customer customer) {
        Optional<List<Item>> optional = Optional.ofNullable(customer).map(Customer::getShoppingCart).map(ShoppingCart::getItems).filter(items -> !items.isEmpty());
        if (optional.isPresent())
            System.out.println("in stock");
        else
            System.out.println("out of stock");
    }
    public static void printItemsInCart(Customer customer) {
        Optional.ofNullable(customer).map(Customer::getShoppingCart).map(ShoppingCart::getItems).filter(items -> !items.isEmpty()).ifPresent(items -> items.forEach(item -> System.out.println(item.getName())));
    }
    public static String getRandomAlternativeItem() {
        Random random = new Random();
        int randomIndex = random.nextInt(ALTERNATIVE_ITEMS.size());
        return ALTERNATIVE_ITEMS.get(randomIndex);
    }
}