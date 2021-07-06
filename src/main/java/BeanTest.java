import java.util.ArrayList;

public class BeanTest {
    public static void main(String[] args) {
        Album twentyFourKMagic = new Album(1,"Bruno Mars", "24k Magic", 2016, 3, "Pop,Funk, R&B");
        Author hDT = new Author(1, "Henry David", "Thoreau");
        Quote quoteOfTheDay = new Quote(1, "Go confidently in the direction of your dreams! Live the life you've imagined.", hDT);

        System.out.println(quoteOfTheDay.getContent());
        System.out.println(quoteOfTheDay.getAuthor().getFirstName());
        System.out.println(twentyFourKMagic.getGenre());

        ArrayList<Quote> quotes = new ArrayList<>();
        quotes.add(quoteOfTheDay);
        quotes.add(new Quote(2,"Better out than in, I always say", new Author(2,"Shrek", "The Ogre")));
        quotes.add(new Quote(3, "Success usually comes to those who are too busy to be looking for it.", hDT));

        for (Quote quote : quotes) {
            System.out.println("Here's a quote for ya'! ***************");
            System.out.printf("\"%s\"%n  - %s %s%n", quote.getContent(), quote.getAuthor().getFirstName(), quote.getAuthor().getLastName());
        }
    }
}
