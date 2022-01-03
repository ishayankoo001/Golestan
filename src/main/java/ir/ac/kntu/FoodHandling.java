package ir.ac.kntu;

import java.util.Scanner;

public class FoodHandling {
    static Scanner s = new Scanner(System.in);

    public static int welcomePage() {
        int operation;

        System.out.println("Welcome to Food service handler of Golestan");
        System.out.println("0:Breakfast 1:Lunch");
        operation = s.nextInt();
        s.nextLine();
        switch (operation) {
            case 0:
                return orderBreakfast();
            case 1:
                return orderLunch();
            default:
                return 0;
        }
    }

    public static int orderLunch() {
        int operation;
        mainCourse myMainCourse;
        drink myDrink;
        salad mySalad;
        PlaceToReceive myPlaceToReceive;
        System.out.println("Choose between options Kebab(0), Fish n Chips(1), Burger(2) and Pizza(3)");
        operation = s.nextInt();
        s.nextLine();
        switch (operation) {
            case 0:
                myMainCourse = mainCourse.KEBAB;
                break;
            case 1:
                myMainCourse = mainCourse.FISHANDCHIPS;
                break;
            case 2:
                myMainCourse = mainCourse.BURGER;
                break;
            case 3:
                myMainCourse = mainCourse.PIZZA;
                break;
            default:
                myMainCourse = mainCourse.KEBAB;
                break;
        }
        System.out.println("Choose between drinks Soda(0) and Water(1)");
        operation = s.nextInt();
        s.nextLine();
        switch (operation) {
            case 0:
                myDrink = drink.SODA;
                break;
            case 1:
                myDrink = drink.WATER;
                break;
            default:
                myDrink = drink.WATER;
                break;
        }
        System.out.println("Choose between salads Shirazi(0), Cabbage(1) and Caesar(2)");
        operation = s.nextInt();
        s.nextLine();
        switch (operation) {
            case 0:
                mySalad = salad.SHIRAZI;
                break;
            case 1:
                mySalad = salad.CABBAGE;
                break;
            case 2:
                mySalad = salad.CAESAR;
                break;
            default:
                mySalad = salad.SHIRAZI;
                break;
        }
        System.out.println("Choose where you would want to receive your food: Uni(0), Dorm(1)");
        operation = s.nextInt();
        s.nextLine();
        switch (operation){
            case 0:
                myPlaceToReceive = PlaceToReceive.UNIVERSITY;
                break;
            case 1:
                myPlaceToReceive = PlaceToReceive.DORMITORY;
                break;
            default:
                myPlaceToReceive=PlaceToReceive.UNIVERSITY;
                break;
        }
        Lunch myLunch = new Lunch(myMainCourse, mySalad, myDrink, myPlaceToReceive);
        System.out.println("Your order total would be " + myLunch.price + " Tomans");
        return myLunch.price;
    }

    public static int orderBreakfast() {
        int operation;
        BreakfastOptions myBreakfastOptions;
        PlaceToReceive myPlaceToReceive;
        System.out.println("Choose between options Nimroo(0), Kalapch(1), Non panir(2) and Kare asal(3)");
        operation = s.nextInt();
        s.nextLine();
        switch (operation) {
            case 0:
                myBreakfastOptions = BreakfastOptions.NIMROO;
                break;
            case 1:
                myBreakfastOptions = BreakfastOptions.KALAPCH;
                break;
            case 2:
                myBreakfastOptions = BreakfastOptions.NONPANIR;
                break;
            case 3:
                myBreakfastOptions = BreakfastOptions.KAREASAL;
                break;
            default:
                myBreakfastOptions = BreakfastOptions.NONPANIR;
        }
        System.out.println("Choose where you would want to receive your food: Uni(0), Dorm(1)");
        operation = s.nextInt();
        s.nextLine();
        switch (operation){
            case 0:
                myPlaceToReceive = PlaceToReceive.UNIVERSITY;
                break;
            case 1:
                myPlaceToReceive = PlaceToReceive.DORMITORY;
                break;
            default:
                myPlaceToReceive=PlaceToReceive.UNIVERSITY;
                break;
        }
        Breakfast myBreakfast = new Breakfast(myBreakfastOptions,myPlaceToReceive);
        System.out.println("Your order total is " + myBreakfast.price + " Tomans.");
        return myBreakfast.price;

    }
}
