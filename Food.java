public class Food extends Item{
    static int foodQuantity = 500;
    Food(String _name, double _price) {
        name = _name;
        price = _price;
    }
    public int getQuantity(){ return foodQuantity; }
    public void setQuantity(int sQ){ foodQuantity = sQ; }
}