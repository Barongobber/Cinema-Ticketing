public abstract class Item {
    protected String name;
    protected double price;

    public String getName(){ return name; }
    public double getPrice(){ return price; }
    public abstract int getQuantity();
    public abstract void setQuantity(int sQ);
}