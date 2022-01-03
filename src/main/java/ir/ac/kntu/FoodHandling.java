package ir.ac.kntu;

public class FoodHandling {
    public static void welcomePage(){
        System.out.println("Welcome to Food service handler of Golestan");
        System.out.println("0:Breakfast 1:Lunch");
    }
    public static void orderLunch(){
        System.out.println("Choose between options Kebab(0), Fish n Chips(1), Burger(2) and Pizza(3)");
        System.out.println("Choose between drinks Soda(0) and Water(1)");
        System.out.println("Choose between salads Shirazi(0), Cabbage(1) and Caesar(2)");
    }
    public static void orderBreakfast(){
        System.out.println("Choose between options Nimroo(0), Kalapch(1), Non panir(2) and Kare asal(3)");
    }
}
