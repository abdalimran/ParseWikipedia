import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.PrintWriter;

/*
* This is simple web scrapper which scraps the "In the news" section's headlines.
* This scrapper uses jsoup library. (https://jsoup.org/)
* */

public class ParseWikipedia{

    public static void main(String[] args) throws Exception {
        final Document doc = Jsoup.connect("http://en.wikipedia.org/").get();
        final Elements newsHeadlines = doc.select("#mp-itn b a");
        final PrintWriter export = new PrintWriter("WikipediaHeadlines.txt");

        for (Element headline : newsHeadlines){
            String printresult=headline.attr("title")+"\n";
            System.out.print(printresult);
            export.write(printresult);
        }

        export.close();
    }

}
