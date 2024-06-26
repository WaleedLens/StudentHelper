package core.utils;

public class PatternUtils {


    public static int getPriceAsInteger(String price){
        price = price.replaceAll(",","");
        int priceExtracted = Integer.parseInt(price.replaceAll("\\s","").replaceAll("SAR",""));
        return priceExtracted;
    }
    /**
     * Convert integer into string (e.g., 1 to one , 2 to two ...etc)
     * Note. Max number of adults is ten-> 10
     * @param number
     * @return
     */
    public static String getAdultsNumber(int number){
        switch (number){
            case 1:
                return "one";
            case 2:
                return "two";
            case 3:
                return "three";
            case 4:
                return "four";
            case 5:
                return "five";
            case 6:
                return "six";
            case 7:
                return "seven";
            case 8:
                return "eight";
            case 9:
                return "nine";
            case 10:
                return "ten";

            default:
                throw new IllegalStateException("Number n should be between 1 <= n <= 10 ");
        }
    }


}
