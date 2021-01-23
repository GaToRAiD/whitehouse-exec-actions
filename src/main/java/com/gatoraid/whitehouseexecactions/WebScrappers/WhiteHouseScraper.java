//package com.gatoraid.whitehouseexecactions.WebScrappers;
//
//import com.gatoraid.whitehouseexecactions.dao.BidenDAO;
//import com.gatoraid.whitehouseexecactions.entity.Biden;
//import org.jsoup.nodes.Element;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.io.IOException;
//import java.util.*;
//
//public class WhiteHouseScraper {
//    private String baseURL = "https://www.whitehouse.gov/presidential-actions/page/";
//    private int page = 1;
//
//
//    private BidenDAO bidenDAO;
//
//    @Autowired
//    public WhiteHouseScraper(BidenDAO whDAO){
//        bidenDAO = whDAO;
//    }
//
//
//    public void saveArticle(Biden theArticle){
//        if(bidenDAO.GetItem(theArticle).size() == 0){
//            bidenDAO.saveItem(theArticle);
//            System.out.println("Item Saved");
//        }
//    }
//
//    public Element getCurrentPage(String webpage) throws IOException{
//
//        WebScraper whiteHouseScraper = new WebScraper();
//        whiteHouseScraper.setWebURL(webpage);
//        whiteHouseScraper.getWebReturn();
//        Element pageStatus = whiteHouseScraper.getWebReturn();
//        return pageStatus;
//
//    }
//
//    public void getAllPages() throws IOException {
//        while(true){
//            String webpage = baseURL + page;
//            WebScraper whiteHouseScraper = new WebScraper();
//            whiteHouseScraper.setWebURL(webpage);
//            whiteHouseScraper.getWebReturn();
//            Element pageStatus = whiteHouseScraper.getWebReturn();
//            if (pageStatus == null){
//                System.out.println("No More Pages To Index");
//                break;
//            } else {
//                HashMap pageArticles = whiteHouseScraper.getElements();
//                Iterator iterator = pageArticles.entrySet().iterator();
//                while(iterator.hasNext()){
//                    Map.Entry currentArticle = (Map.Entry)iterator.next();
//                    try {
//                        //System.out.println(currentArticle.getValue());
//                        //System.out.println(currentArticle.getKey());
//                        Biden biden = new Biden();
//                        biden.setLink((String) currentArticle.getValue());
//                        biden.setText((String) currentArticle.getKey());
//                        saveArticle(biden);
//                    } catch(Exception exc) {
//                        System.out.println(exc);
//                    }
//                }
//            }
//            pageStatus.empty();
//            page++;
//        }
//    }
//
//}
