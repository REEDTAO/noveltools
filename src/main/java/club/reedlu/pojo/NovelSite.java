package club.reedlu.pojo;

import lombok.Data;

@Data
public class NovelSite {
    Integer id;
    String siteurl;
    String noveltype;
    String noveltypeurl;
    String catchstatue;//0  导入,1  爬取中,2  爬取结束
}
