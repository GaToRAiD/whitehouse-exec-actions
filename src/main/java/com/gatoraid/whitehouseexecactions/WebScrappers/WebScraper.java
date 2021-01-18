package com.gatoraid.whitehouseexecactions.WebScrappers;

import com.sun.webkit.WebPage;
import org.jsoup.Connection;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class WebScraper {

    private String webURL;
    private String webReturn;
    private HashMap<String, String> articles = new HashMap<String, String>();
    private Document WebPage;
    private Elements elements;
    private HashMap<String, String> diffArticles = new HashMap<String, String>();
    private String redirectURL;

    public WebScraper() {
    }

    public void getWebURL() {
        System.out.println(webURL);
    }

    public void setWebURL(String webURL) {
        this.webURL = webURL;
    }

    public Document getWebReturn() throws IOException {
        try {
            Connection.Response response = Jsoup.connect(this.webURL).followRedirects(false).execute();
            if (response.hasHeader("location")){
                redirectURL = response.header("location");
                System.out.println(redirectURL);
                this.webURL = redirectURL;
            }

            WebPage = Jsoup.connect(this.webURL).get();

        } catch (IOException e) {
            if(e instanceof HttpStatusException){
                WebPage = null;
            }
        }
        return WebPage;
    }


    public Element getArticleLink(Element link){
        return link.select("a").first();
    }

    public String getArticleText(Element article){
        return article.attr("ahref");
    }

    @Override
    public String toString() {
        return "WebScraper{" +
                "webURL='" + webURL + '\'' +
                ", articles=" + articles +
                ", elements=" + elements +
                '}';
    }

    public HashMap<String, String> getElements() {
        elements = WebPage.getElementsByClass("presidential-action__title");
        for (Element element : elements) {
            Element article = getArticleLink(element);
            if(article == null){
                continue;
            } else {
                try {
                    articles.put(article.text(), article.attr("href"));
                } catch (Exception e){
                    System.out.println("Exception" + e);
                }
            }
        }
        return articles;
    }

//    public Map<String, MapDifference.ValueDifference<String>> compareArticles() throws IOException {
//        HashMap<String, String> currentArticles = articles;
//        getWebReturn();
//        //HashMap<String, String> newArticles = getArticles();
//        MapDifference<String, String> mapDifference = Maps.difference(currentArticles, newArticles);
//        Map<String, MapDifference.ValueDifference<String>> entriesDiffernt = mapDifference.entriesDiffering();
//        if(entriesDiffernt.isEmpty()){
//            System.out.println("There are no updates");
//        } else {
//            return entriesDiffernt;
//        }
//        return null;
//    }


    public WebScraper(String webURL, String webReturn, List<String> articles) {
        this.webURL = webURL;
        this.webReturn = webReturn;
        this.articles = (HashMap<String, String>) articles;
    }

}
