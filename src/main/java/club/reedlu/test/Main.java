package club.reedlu.test;

import club.reedlu.pojo.NovelSite;
import club.reedlu.utils.DocumentPraser;
import club.reedlu.utils.DocumentUtils;
import org.jsoup.nodes.Document;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class Main {
    public static void main(String[] args) throws IOException {
        //Document doc = DocumentUtils.getDocumentByUrl("http://www.qbiqu.com/modules/article/bookcase.php");
        //System.out.println(doc.toString());
        HashMap<String,String> typeAndUrl = DocumentPraser.getTypeAndUrl("http://www.qbiqu.com/", ".nav ul a");

        ArrayList<NovelSite> sites = new ArrayList<NovelSite>();
        for(String string:typeAndUrl.keySet()){
            NovelSite novelSite = new NovelSite();
            novelSite.setSiteurl("http://www.qbiqu.com/");
            novelSite.setNoveltype(string);
            novelSite.setCatchstatue("0");
            novelSite.setNoveltypeurl(typeAndUrl.get(string));
        }
        System.out.println(sites);

    }
}
