package club.reedlu.utils;

import club.reedlu.NovelSelectorConfig;
import club.reedlu.pojo.NovelInfo;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class NovelListCatch {
     NovelSelectorConfig config;
    ArrayList<NovelInfo> list = new ArrayList<NovelInfo>();
    public ArrayList<NovelInfo> getNovelInfo(Document doc){
        Elements nameSelect = doc.select(config.getNovelNameSelector());
        Elements authors = doc.select(config.getAuthorSelector());
        NovelInfo novel = null;
        for(int i = 0;i<nameSelect.size();i++){
            novel = new NovelInfo();
            novel.setName(nameSelect.get(i).text());
            novel.setUrl(nameSelect.get(i).attr("href"));
            novel.setAuthor(authors.get(i).text());
            list.add(novel);
        }
        return list;
    }

    public void setConfig(NovelSelectorConfig config){
        this.config = config;
    }
}
