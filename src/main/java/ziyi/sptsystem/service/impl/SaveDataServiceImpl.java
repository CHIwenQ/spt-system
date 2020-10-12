package ziyi.sptsystem.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ziyi.sptsystem.entity.TmpData;
import ziyi.sptsystem.mapper.TmpDataMapper;
import ziyi.sptsystem.service.SaveDataService;
import java.util.List;


@Service
public class SaveDataServiceImpl implements SaveDataService {

    @Autowired
    TmpDataMapper tmpDataMapper;

    @Override
    public boolean saveAdValue(TmpData tmpData) {
        try {
            tmpDataMapper.addTmpData(tmpData);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<TmpData> findAllData() {
        List<TmpData> dataList = tmpDataMapper.queryTmpDataList();
        return dataList;
    }
}
