public class ListOfProduct {
    String listToByu = "";
    String nameOfProduct;
    double price;

    public String addToProductList(String nameOfProduct, double price){
        this.nameOfProduct = nameOfProduct;
        this.price = price;
        Formater formater = new Formater();
        return listToByu = listToByu + (nameOfProduct + " - " + formater.rounding(price) + " "
                         + formater.declination(price) + "\n");
    }
}
