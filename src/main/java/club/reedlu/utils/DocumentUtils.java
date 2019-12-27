package club.reedlu.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class DocumentUtils {
    public static Document getDocumentByUrl(String url) throws IOException {
        if(url.equals("")||url==null)return null;
        return Jsoup.connect(url)
                .timeout(4000)
                .userAgent("Mozilla")
                .ignoreContentType(true)
                .get();
    }
}
