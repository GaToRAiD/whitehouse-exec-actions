package com.gatoraid.whitehouseexecactions.WebScrappers;

import com.gatoraid.whitehouseexecactions.dao.BidenDAO;
import com.gatoraid.whitehouseexecactions.discord.DiscordAPI;
import com.gatoraid.whitehouseexecactions.entity.Biden;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Component
public class BidenScraper {

    @Value("${biden.url}")
    private String url;

    @Value("${biden.classname}")
    private String classname;
    private int page = 1;

    @Autowired
    private BidenDAO bidenDAO;

    @Autowired
    private WebScraper scraper;

    DiscordAPI dsapi = new DiscordAPI();

    public void BidenScraper(){
    }

    public void setUrl() {
        scraper.setWebURL(this.url);
    }

    public void setClassname() {
        scraper.setClassName(this.classname);
    }


    public boolean saveArticle(Biden theArticle){
        if(bidenDAO.GetItem(theArticle).size() == 0){
            bidenDAO.saveItem(theArticle);
            System.out.println("Item Saved");
            return true;
        }
        return false;
    }

    @Scheduled(initialDelay = 60 * 1000, fixedRate = 4 * 60 * 60 * 1000)
    public boolean checkForUpdate() throws IOException{
        String webpage = url + "page/" + page + "/";
        System.out.println(webpage);
        scraper.setWebURL(webpage);
        Element pageStatus = getCurrentPage();
        if (pageStatus == null){
            System.out.println("No More Pages To Index");
            return false;
        } else {
            HashMap pageArticles = scraper.getElements();
            Iterator iterator = pageArticles.entrySet().iterator();
            while(iterator.hasNext()){
                Map.Entry currentArticle = (Map.Entry)iterator.next();
                try {
                    Biden biden = new Biden();
                    biden.setLink((String) currentArticle.getValue());
                    biden.setText((String) currentArticle.getKey());
                    if(saveArticle(biden) == false) {
                        System.out.println(webpage);
                        System.out.println("No new articles");
                    }

                } catch(Exception exc) {
                    System.out.println(exc);
                }
            }
        }
        pageStatus.empty();
        return true;
    }

    public Element getCurrentPage() throws IOException{
        Element pageStatus = scraper.getWebReturn();
        return pageStatus;
    }

        public void getAllPages() throws IOException {
            while(true){
                if(checkForUpdate()){
                    page++;
                } else {
                    page = 1;
                    break;
                }

            }
    }




}
