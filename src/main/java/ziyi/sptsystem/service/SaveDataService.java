package ziyi.sptsystem.service;

import org.springframework.stereotype.Service;
import ziyi.sptsystem.entity.TmpData;

import java.util.List;


public interface SaveDataService {
    public boolean saveAdValue(TmpData tmpData,int id);//保存AD值

    List<TmpData> findAllData();


}
