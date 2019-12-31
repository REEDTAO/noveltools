package club.reedlu;


import lombok.Data;

@Data
public class NovelSelectorConfig {
    //小说类型
    String typeSelector;//类型选择器
    String typeURLSelector;//类型链接选择器

    //小说构成
    String novelNameSelector;//小说名选择器
    String novelURLSelector;//小说链接选择器
    String authorSelector;//小说作者选择器
    String descriptionSelector;//小说描述选择器
    String chaptercountSelector;//小说章节数选择器
    String updatetimeSelector;//小说更新时间选择器
    String novelListNextSelector;//小说列表下一页选择器


    //小说章节
    String titleSelector;//小说章节标题选择器
    String urlSelector;//小说章节链接选择器
    String content;//小说内容选择器
    String nextUrlSelector;//小说下一章链接选择器



}
