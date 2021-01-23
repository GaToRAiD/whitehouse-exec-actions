package com.gatoraid.whitehouseexecactions.WebScrappers;


import org.jsoup.Connection;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.HashMap;

@Component
public class WebScraper {

    private String webURL;
    private String webReturn;
    private HashMap<String, String> articles = new HashMap<String, String>();
    private Document WebPage;
    private Elements elements;
    private HashMap<String, String> diffArticles = new HashMap<String, String>();
    private String redirectURL;
    private String className;

    public void getWebURL() {
        System.out.println(webURL);
    }

    public void setWebURL(String webURL) {
        this.webURL = webURL;
    }

    public void setClassName(String className){
        this.className = className;
    }

    public Document getWebReturn() throws IOException {
        try {
            Connection.Response response = Jsoup.connect(this.webURL).followRedirects(false).execute();
            if (response.hasHeader("location")){
                System.out.println(response.header("location"));
                redirectURL = response.header("location");
                this.webURL = redirectURL;
            }
            if(response.statusCode() == 404){
                WebPage = null;
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
        elements = WebPage.getElementsByClass(className);
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

}
