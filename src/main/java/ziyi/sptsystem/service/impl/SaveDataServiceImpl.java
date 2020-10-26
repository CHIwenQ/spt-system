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
    public boolean saveAdValue(TmpData tmpData,int id) {
        try {
            if (id==0){
                tmpDataMapper.addTmpData0(tmpData);
                return true;
            }else if (id==1){
                tmpDataMapper.addTmpData1(tmpData);
                return true;
            }else if (id==2){
                tmpDataMapper.addTmpData2(tmpData);
                return true;
            }
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
