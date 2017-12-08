import java.util.Random;

public class DrunkBottlesOfBeerOnTheWall {
    int beersDrank = 0;

    //how many people the beers are being shared with (affects the rate at which the output "gets drunk")
    final int PEOPLE_IN_DRINKING_GROUP = 10;

    public static void main(String[] args) {

        DrunkBottlesOfBeerOnTheWall beer = new DrunkBottlesOfBeerOnTheWall();

        beer.printLinesOfBeer(99);
    }

    public void printLinesOfBeer(int bottlesOfBeer) {

        if (bottlesOfBeer <= 0) {

            printBeerLine("No bottles of beer on the wall,");
            printBeerLine("no bottles of beer,");
            printBeerLine("ya' can't take one down, ya' can't pass it around,");
            printBeerLine("'cause there are no more bottles of beer on the wall\n");

        } else if (bottlesOfBeer == 1) {

            printBeerLine(bottlesOfBeer + " bottle of beer on the wall,");
            printBeerLine(bottlesOfBeer + " bottle of beer,");
            printBeerLine("ya' take one down, ya' pass it around,");
            beersDrank++;
            printBeerLine("no more bottles of beer on the wall\n");
            printLinesOfBeer(bottlesOfBeer - 1);
        } else {
            System.out.println();
            printBeerLine(bottlesOfBeer + " bottles of beer on the wall,");
            printBeerLine(bottlesOfBeer + " bottles of beer,");
            printBeerLine("ya' take one down, ya' pass it around,");
            beersDrank++;
            printBeerLine(bottlesOfBeer - 1 + " bottles of beer on the wall\n");
            printLinesOfBeer(bottlesOfBeer - 1);
        }
    }

    public void printBeerLine(String string) {
        int timesSwapped = 0;

        while (timesSwapped < beersDrank/PEOPLE_IN_DRINKING_GROUP) {
            string = swapTwoLetters(string);
            timesSwapped++;
        }
        System.out.println(string);
    }

    public static String swapTwoLetters(String originalString) {
        int length = originalString.length();
        Random rand=new Random();
        int one = 0; int two = 0;

        //generate two random indexes which are not equal to each other.
        while(length >= 2 && one == two){
            one=rand.nextInt(length);
            two=rand.nextInt(length);
        }

        //use String builder and interchange the characters.
        StringBuilder builder = new StringBuilder(originalString);
        builder.setCharAt(one, originalString.charAt(two));
        builder.setCharAt(two, originalString.charAt(one));

        return builder.toString();
    }
}
