public class Formater {
    String rubl;

    public String declination(double num){
        double numToFormat = Math.floor(num);
        double lastDigit = numToFormat % 10; //отделяем последнюю цифру
        numToFormat /= 10; //готовим число для отделения еще одной цифры
        double secondToLastDigit = numToFormat % 10; //отделяем предпоследнюю цифру

        if (secondToLastDigit == 1){
            return rubl = "рублей";
        } else {
            switch (String.valueOf(lastDigit)) {
                case "1":
                    return rubl = "рубль";
                case "2":
                    return rubl = "рубля";
                case "3":
                    return rubl = "рубля";
                case "4":
                    return rubl = "рубля";
                default:
                    return rubl = "рублей";
            }
        }
    }

    public String rounding(double price){
        return String.format("%.2f", price);
        }
}
            