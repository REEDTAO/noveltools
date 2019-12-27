package club.reedlu.test;

import club.reedlu.utils.DocumentPraser;
import club.reedlu.utils.DocumentUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        Document doc = DocumentUtils.getDocumentByUrl("http://www.qbiqu.com/modules/article/bookcase.php");
        //System.out.println(doc.toString());
        HashMap<String,String> typeAndUrl = DocumentPraser.getTypeAndUrl("http://www.qbiqu.com/", ".nav ul a");


        typeAndUrl.values();
        for(String string:typeAndUrl.keySet()){
            System.out.println(string+"  "+typeAndUrl.get(string));
        }

    }
}
