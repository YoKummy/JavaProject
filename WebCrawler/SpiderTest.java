package WebCrawler;
import java.util.*;
public class SpiderTest {
    public static void main(String[] args) 
    {
        while (true) 
        {
            Scanner scn = new Scanner(System.in);
            System.out.println("Please enter your website first: ");
            String webSite = scn.nextLine();
            System.out.println("Please enter your word next: ");
            String Search = scn.nextLine();
            Spider spider = new Spider();
            spider.search(webSite, Search);
            scn.close();
        }
    }
}
