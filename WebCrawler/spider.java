package WebCrawler;
import java.util.*;


public class Spider 
{
    private static final int MAX_PAGE_TO_SEARCH = 10;
    private HashSet<String> pagesVisted = new HashSet<String>();
    private LinkedList<String> pagesToVisit = new LinkedList<String>();
    
    public void search(String url, String searchWord)
    {
        while (this.pagesVisted.size() < MAX_PAGE_TO_SEARCH) 
        {
            String currentUrl;
            SpiderLeg leg = new SpiderLeg();
            if(this.pagesToVisit.isEmpty())
            {
                currentUrl = url;
                this.pagesVisted.add(url);
            }
            else
            {
                currentUrl = this.nextUrl();
            }
            leg.crawl(currentUrl);

            boolean success = leg.searchForWord(searchWord);
            if(success)
            {
                System.out.println(String.format("**Success** Word %s found at %s", searchWord, currentUrl));
                break;
            }
            this.pagesToVisit.addAll(leg.getLinks());
        }
        System.out.println(String.format("**Done** Visted %s web page(s)", this.pagesVisted.size()));
    }
    private String nextUrl()
    {
        String nextUrl;
        do{
            nextUrl = this.pagesToVisit.remove(0);
        }while(this.pagesVisted.contains(nextUrl));
        this.pagesVisted.add(nextUrl);
        return nextUrl;
    }
}
