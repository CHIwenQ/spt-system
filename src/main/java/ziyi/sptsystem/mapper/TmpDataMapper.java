package ziyi.sptsystem.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import ziyi.sptsystem.entity.TmpData;

import java.util.List;

@Mapper
@Repository
public interface TmpDataMapper {

    List<TmpData> queryTmpDataList();

    int addTmpData(TmpData tmpData);


}
