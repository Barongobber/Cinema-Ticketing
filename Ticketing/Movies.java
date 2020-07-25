public class Movies extends Item{
    int seatQuantity;
    public Movies(String n, double p){
        name = n;
        price = p;
        seatQuantity = 40;
	}
    public int getQuantity(){ return seatQuantity; }
    public void setQuantity(int sQ){ seatQuantity = sQ; }
}