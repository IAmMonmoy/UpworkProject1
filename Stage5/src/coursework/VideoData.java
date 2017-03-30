package coursework;

import java.util.*;
import javax.print.attribute.standard.OutputDeviceAssigned;

public class VideoData {

    private static class Item {

        private String name;
        private String director;
        private int rating;
        private int playCount;

        Item(String n, String d, int r) {
            name = n;
            director = d;
            rating = r;
        }

        @Override
        public String toString() {
            return name + " - " + director;
        }
    }
    // with a Map you use put to insert a key, value pair
    // and get(key) to retrieve the value associated with a key
    // You don't need to understand how this works!
    private static final Map<String, Item> library = new TreeMap();

    static {
        // if you want to have extra library items, put them in here
        // use the same style - keys should be 2 digit Strings library.put("01", new Item("Tom and Jerry", "Fred Quimby", 3)); library.put("02", new Item("Tweety Pie ", "Wrexler Ripmophomtofz", 5)); library.put("03", new Item("Dr. Strangelove", "Stanley Kubrick", 2)); library.put("04", new Item("Babies 1st Birthday", "Me", 10)); library.put("05", new Item("Rat Pfink a Boo Boo", "Ray Steckler", 0));
        library.put("01", new Item("Tom and Jerry", "Fred Quimby", 4));
        library.put("02", new Item("Tweety Pie", "Wrexler Ripmophomtofz", 5));
        library.put("03", new Item("Dr. Strangelove", "Stanley Kubrick", 2));
        library.put("04", new Item("Babies 1st Birthday", "Me", 1));
        library.put("05", new Item("Rat Pfink a Boo Boo", "Ray Steckler", 3));
        library.put("06", new Item("x and y", "Fred Quimby", 4));
    }

    public static String listAll() {
        String output = "";
        Iterator iterator = library.keySet().iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            Item item = library.get(key);
            output += key + " " + item.name + " - " + item.director + "\n";
        }
        return output;
    }

    public static String getName(String key) {
        Item item = library.get(key);
        if (item == null) {
            return null; // null means no such item
        } else {
            return item.name;
        }
    }

    public static String getDirector(String key) {

        Item item = library.get(key);
        if (item == null) {
            return null; // null means no such item
        } else {
            return item.director;
        }
    }
    
    

    public static String searchForName(String name) {
        String output = "";
        Iterator iterator = library.keySet().iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            Item item = library.get(key);

            if (name.equalsIgnoreCase(item.name) || name.equalsIgnoreCase(item.director)) {
                output += item.name + " - " + item.director + "\n";
                output += "Rating :" + VideoPlayer.stars(item.rating) + "\n";
                output += "Play Count :" + item.playCount + "\n";
            }
        }

        return output;
    }

    public static int getRating(String key) {
        Item item = library.get(key);
        if (item == null) {
            return -1; // negative quantity means no such item
        } else {
            return item.rating;
        }
    }

    public static void setRating(String key, int rating) {
        Item item = library.get(key);
        if (item != null) {
            item.rating = rating;
        }
    }

    public static int getPlayCount(String key) {
        Item item = library.get(key);
        if (item == null) {
            return -1; // negative quantity means no such item
        } else {
            return item.playCount;
        }
    }

    public static void incrementPlayCount(String key) {
        Item item = library.get(key);
        if (item != null) {
            item.playCount += 1;
        }
    }

    public static void close() {
        // Does nothing for this static version.
        // Write a statement to close the database when you are using one
    }
}
