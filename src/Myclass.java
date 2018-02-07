
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class Myclass {
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString ( final String url){
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }
    public static int wordCount(String line) {


        String[] words = line.split("\\s+");
        return words.length;

    }

    public static int specificwordcount (String line , String searchword){
        int counter = 0;
        String[] words = line.split("\\s+");
        for (String word : words )
            if (word.equals(searchword)){
            counter++;
            }
        return counter;
    }

    public static void main(String[] array) {
        String line = urlToString("http://erdani.com/tdpl/hamlet.txt");
        System.out.println(wordCount(line));
        System.out.println(specificwordcount(line,"Hamlet"));
    }


}
