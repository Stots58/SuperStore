// SuperStore Exercise: Access Modifiers & Object Modeling Focus
//java.util.Arrays;
// TODO: Define a class called Product with:
// - A protected String field called name
// - A protected double field called price
// - A private final int productId
// - A public static int nextId to help generate unique IDs
// - A constructor that sets name, price, and assigns a unique ID
// - Public getters for all fields
// - Override toString() to return formatted product details
// - Override equals(Object o) to compare name and productId
class Product{
    protected String name;
    protected double price;
    private final int productId;
    public static int nextId = 0;

    public Product(String name, double price){
        this.name = name;
        this.price = price;
        productId = nextId++;
    }

    public String getName(){
        return this.name;
    }

    public double getPrice(){
        return this.price;
    }

    public int getProductId(){
        return this.productId;
    }

    public int getNextId(){
        return this.nextId;
    }

    @Override
    public String toString(){
        return "Name: " + name + "\nPrice: " + price + "\nproductId" + productId + "\nNextId: " + nextId;
    }

    public boolean equals(Object o) {
        // If both references point to the same object in memory, they're equal
        if (this == o) return true;

        // If o is not an Animal (or subclass), they can't be equal
        if (!(o instanceof Product)) return false;

        // Since we've already confirmed o is an Animal (or subclass), it's now safe to cast it
        Product product = (Product) o;

        // Compare the names of both animals
        return name.equals(product.name);
    }
}

// TODO: Define a subclass Electronics that extends Product
// - Add a private String field called brand
// - Add a private boolean field called hasBattery
// - Constructor takes all fields and uses super for shared ones
// - Override toString() to include brand and battery status
class Electronics extends Product{
    private String brand;
    private boolean hasBattery;

    public Electronics(String name, double price, String brand, boolean hasBattery){
        super(name, price);
        this.brand = brand;
        this.hasBattery = hasBattery;
    }

    public final void warrantyInfo(){
        System.out.println("aa");
    }

    @Override
    public String toString(){
        return "Brand: " + brand + "\nhasBattery: " + hasBattery;
    }

}

// TODO: Define a subclass Grocery that extends Product
// - Add a private double field called weight (in kg)
// - Add a private boolean field called isPerishable
// - Constructor takes all fields and uses super for shared ones
// - Override toString() to include weight and perishability
class Grocery extends Product{
    private double weight;
    private boolean isPerishable;

    public Grocery(String name, double price, double weight, boolean isPerishable){
        super(name, price);
        this.weight = weight;
        this.isPerishable = isPerishable;
    }

    @Override
    public String toString(){
        return "Weight: " + weight + "kg" + "\nIsPerishable: " + isPerishable;
    }
}

// TODO: Define a final class Toy that extends Product
// - Add a private int field called minAge
// - Constructor takes all fields and uses super for shared ones
// - Override toString() to include minAge
final class Toy extends Product{
    private int minAge;

    public Toy(String name, double price, int minAge){
        super(name, price);
        this.minAge = minAge;
    }

    @Override
    public String toString(){
        return "MinAge: " + minAge;
    }
}

// TODO: Define class SuperStoreTest with a main method
// - Create at least one instance of each subclass
// - Store them in a Product[] array
// - Loop through and print each item
// - Call equals() to compare two products with the same ID and name
class SuperStoreTest{
    public static void main(String[] args) {
        Product c1 = new Electronics("Laptop", 2000.99, "ROG", true);
        Product c2 = new Grocery("Whisky ", 58.00, 2.5, false);
        Product c3 = new Toy("Lego", 150.99, 17);

        Product[] productArray = {c1, c2, c3};

        for (int i = 0; i < productArray.length; i++){
            //System.out.println("counter = " + i);
            System.out.println(productArray[i]);
        }

        System.out.println("Is ROG the best laptop brand? " + c1.equals(c1));
    }
}

// Additional TODOs:
// 1. Try to extend Toy — what happens and why?
/*
class RockemSockemRobots extends toy{
    System.out.println("Peek childhood");
    // Since Toy is set to "final" it can not have a child/it can't extend. Won't Run.
}
/*

 */
// 2. Make a class Coupon with a final discountRate and apply it to a Product
class Coupon extends Electronics{
    final double discountRate = 0.50;

    public Coupon(String name, double price, String brand, boolean hasBattery){
        super(name, price, brand, hasBattery);
    }
}
// 3. Add a method to Electronics called warrantyInfo() and mark it final

// 4. Use access modifiers appropriately and explain your choices in comments
// I did all the stuff for the TODOs and for the stuff I made public so that everyone has access.
