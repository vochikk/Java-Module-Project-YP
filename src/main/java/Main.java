import java.util.Scanner;

// dev branch for Y.Practicum
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Formater formater = new Formater(); //объект для форматирования скланения во всей программе


        System.out.println("На сколько человек необходимо разделить счет");
        int numberOfPerson;
        while (!scanner.hasNextInt()){
            System.out.println("Некорректный ввод,повторите попытку");
            scanner.next();
        }
        numberOfPerson = scanner.nextInt();

        while (true){
            if (numberOfPerson <= 1){
                System.out.println("Некорректный ввод,повторите попытку");
                while (!scanner.hasNextInt()){
                    System.out.println("Некорректный ввод,повторите попытку");
                    scanner.next();
                }
                numberOfPerson = scanner.nextInt();

            } else {
                break;
            }
        }
        System.out.println("Счет необходимо разделить на " + numberOfPerson);

        Calculator calculator = new Calculator(); //объект для проведения расчетов
        calculator.numberOfPerson = numberOfPerson;

        ListOfProduct listOfProducts = new ListOfProduct(); //объект для хранения списка покупок
        while (true){
            System.out.println("Введите название товара или команду завершить");
            listOfProducts.nameOfProduct = scanner.next();

            String conditionToExit = "завершить";
            if (conditionToExit.equalsIgnoreCase(listOfProducts.nameOfProduct)){
                break;
            }

            System.out.println("Введите цену на товар");
            while (!scanner.hasNextDouble()){
                System.out.println("Некорректный ввод,повторите попытку");
                scanner.next();
            }
            listOfProducts.price = scanner.nextDouble();
            while (listOfProducts.price < 0){
                System.out.println("Некорректный ввод, повторите попытку");
                while (!scanner.hasNextDouble()){
                    System.out.println("Некорректный ввод,повторите попытку");
                    scanner.next();
                }
                listOfProducts.price = scanner.nextDouble();
            }

            listOfProducts.listToByu = listOfProducts.addToProductList(listOfProducts.nameOfProduct, listOfProducts.price);

            System.out.println("Товар успешно добавлен");
            calculator.totalPrice = calculator.totalPrice + listOfProducts.price;
        }

        if (calculator.totalPrice == 0){
            System.out.println("У Вас нет покупок");
        } else {
            String rubl = formater.declination(calculator.totalPrice);
            System.out.println("Вы купили:" + "\n" + listOfProducts.listToByu + "На сумму: "
                                                   + formater.rounding(calculator.totalPrice) + " " + rubl);

            calculator.calculate(calculator.totalPrice, numberOfPerson);
            System.out.println("Каждому необходимо заплатить по: " + formater.rounding(calculator.priceToPayment) + " "
                                                                   + formater.declination(calculator.priceToPayment));
        }
    }
}