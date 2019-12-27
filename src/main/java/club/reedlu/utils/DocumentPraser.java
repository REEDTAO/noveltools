package club.reedlu.utils;

import club.reedlu.rule.Rule;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;

public class DocumentPraser {
    /**
     * 通过css选择器返回Element
     * @param document
     * @param selector
     * @return
     */
    public static Elements getElementBySelector(Document document,String selector){
        return document.select(selector);
    }

    public static HashMap<String ,String> getNovelTypeAndUrlByAElement(Elements eles){
        HashMap<String,String> map = new HashMap();
        for(Element element:eles){
            if(Rule.typePraser(element.text(),element.attr("href"))){
                if(element.attr("href").startsWith("/"))
                map.put(element.text(),element.attr("href"));
            }
        }
        return map;
    }

    public static HashMap<String,String> getTypeAndUrl(String homeUrl,String selector) throws IOException {
        return getNovelTypeAndUrlByAElement(
                getElementBySelector(
                        DocumentUtils.getDocumentByUrl(homeUrl),
                        selector)
        );
    }

}
