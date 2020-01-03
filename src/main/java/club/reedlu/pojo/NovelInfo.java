package club.reedlu.pojo;

import lombok.Data;

import java.util.Date;

@Data
public class NovelInfo {
    Integer id;
    String url;
    String name;
    String author;
    String description;
    String type;
    Integer chaptercount;
    Date updatetime;
}
