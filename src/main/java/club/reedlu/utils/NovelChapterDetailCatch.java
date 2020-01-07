package club.reedlu.utils;

import club.reedlu.NovelSelectorConfig;
import club.reedlu.pojo.Chapterdetail;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class NovelChapterDetailCatch {
    NovelSelectorConfig config;

    /**
     * 获取Document中的小说章节标题和章节内容
     * @param doc   文档对象
     * @param detail 小说章节--包含小说名id，小说章节url
     * @return 返回补全后的Chapterdetail对象
     */
    public Chapterdetail getChapterAllDetail(Document doc,Chapterdetail detail){
        Elements title = doc.select(config.getTitleSelector());
        Elements content = doc.select(config.getContent());
        detail.setContent(content.toString());
        detail.setTitle(title.text());
        return  detail;
    }

    /**
     * 创建小说章节详细内容对象
     * @param url  小说章节url
     * @param novelId  小说对应的id
     * @return
     */
    public  static Chapterdetail createChapterDetailObj(String url,Integer novelId){
        Chapterdetail chapterdetail = new Chapterdetail();
        chapterdetail.setUrl(url);
        chapterdetail.setNovelId(novelId);
        return chapterdetail;
    }
}
