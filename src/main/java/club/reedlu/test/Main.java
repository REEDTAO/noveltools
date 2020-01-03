package club.reedlu.test;

import club.reedlu.NovelSelectorConfig;
import club.reedlu.database.DatabaseUtils;
import club.reedlu.database.mapper.NovelInfoMapper;
import club.reedlu.pojo.NovelInfo;
import club.reedlu.utils.DocumentUtils;
import club.reedlu.utils.NovelListCatch;
import org.apache.ibatis.session.SqlSession;
import org.jsoup.nodes.Document;
import java.io.IOException;
import java.util.ArrayList;



public class Main {
    public static void main(String[] args) throws IOException {
//        Document doc = DocumentUtils.getDocumentByUrl("http://www.qbiqu.com/xuanhuanxiaoshuo/1_10.html");
//        System.out.println(doc.toString());

        NovelListCatch  listCatch = new NovelListCatch();

        NovelSelectorConfig novelSelectorConfig = new NovelSelectorConfig();
        novelSelectorConfig.setNovelNameSelector("#newscontent .l .s2 a");
        novelSelectorConfig.setAuthorSelector(".s5");
        novelSelectorConfig.setNovelListNextSelector(".next");
        listCatch.setConfig(novelSelectorConfig);


        saveNovel(listCatch);

        /*
        String Home_Url = "http://www.qbiqu.com";
        HashMap<String,String> typeAndUrl = DocumentPraser.getTypeAndUrl("http://www.qbiqu.com/", ".nav ul a");

        ArrayList<NovelSite> sites = new ArrayList<NovelSite>();
        for(String string:typeAndUrl.keySet()){
            NovelSite novelSite = new NovelSite();
            novelSite.setSiteurl(Home_Url);
            novelSite.setNoveltype(string);
            novelSite.setCatchstatue("0");
            novelSite.setNoveltypeurl(Home_Url+typeAndUrl.get(string));
            sites.add(novelSite);
        }
        System.out.println(sites);
         */
    }

    private static void saveNovel(NovelListCatch listCatch) throws IOException {
        String nextUrl = "http://www.qbiqu.com/xuanhuanxiaoshuo/";

        while(!nextUrl.equals("")){
            SqlSession sqlSession = DatabaseUtils.getSqlSessionFactory().openSession();
            NovelInfoMapper mapper = sqlSession.getMapper(NovelInfoMapper.class);
            System.out.println("读取url："+nextUrl);
            Document doc = DocumentUtils.getDocumentByUrl(nextUrl);

            ArrayList<NovelInfo> novelInfos = listCatch.getNovelInfo(doc,nextUrl);
            System.out.println("解析成功，获取记录条数:"+novelInfos.size());
            mapper.saveNovelInfoList(novelInfos);

            System.out.println("保存成功");
            nextUrl = listCatch.getNextListUrl(doc);
            sqlSession.commit();
            sqlSession.close();

        }

    }
}
