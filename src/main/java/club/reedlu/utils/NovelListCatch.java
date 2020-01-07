package club.reedlu.utils;

import club.reedlu.NovelSelectorConfig;
import club.reedlu.pojo.NovelInfo;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class NovelListCatch {
     NovelSelectorConfig config;
    ArrayList<NovelInfo> list ;

    /**
     * 获取小说列表
     * @param doc
     * @return
     */
    public ArrayList<NovelInfo> getNovelInfo(Document doc,String nextUrl){
        Elements nameSelect = doc.select(config.getNovelNameSelector());
        Elements authors = doc.select(config.getAuthorSelector());
        NovelInfo novel = null;
        if(nameSelect.size()==0)return null;
        list  = new ArrayList<NovelInfo>();
        for(int i = 0;i<nameSelect.size();i++){
            novel = new NovelInfo();
            novel.setName(nameSelect.get(i).text());
            novel.setUrl(nameSelect.get(i).attr("href"));
            novel.setAuthor(authors.get(i).text());
            novel.setDescription(nameSelect.get(i).toString());
            list.add(novel);
        }
        return list;
    }

    /**
     * 获取下一页url
     * @param doc 文档对象
     * @return 返回下页列表url
     */
    public String  getNextListUrl(Document doc){
        Elements select = doc.select(config.getNovelListNextSelector());
        return  select.size()>0?
                doc.select(config.getNovelListNextSelector()).get(0).attr("href"):
                "";
    }

    /**
     * 获取下一章详细内容url
     * @param doc 文档对象
     * @return 返回下一章url
     */
    public String getNexeChapterUrl(Document doc){
        Elements select = doc.select(config.getNextUrlSelector());
        return  select.size()>0?
                doc.select(config.getNovelListNextSelector()).get(0).attr("href"):
                "";
    }

    public void setConfig(NovelSelectorConfig config){
        this.config = config;
    }
}
