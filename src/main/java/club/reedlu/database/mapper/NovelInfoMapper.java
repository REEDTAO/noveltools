package club.reedlu.database.mapper;

import club.reedlu.pojo.NovelInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NovelInfoMapper {
    void saveNovelInfoList(List<NovelInfo> list);
}
