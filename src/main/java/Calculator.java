public class Calculator {
    double totalPrice;
    int numberOfPerson;
    double priceToPayment;

    public void calculate(double totalPrice, int numberOfPerson){
        this.numberOfPerson = numberOfPerson;
        this.totalPrice = totalPrice;
        priceToPayment = totalPrice / numberOfPerson;
    }
}
