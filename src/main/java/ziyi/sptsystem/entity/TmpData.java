package ziyi.sptsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Date;


@lombok.Data
@NoArgsConstructor
public class TmpData {

    private double ad_value;

    private int id;

    private Date date;
    public TmpData(double ad_value,Date date) {
        this.ad_value = ad_value;
        this.date=date;
    }
//    private Date date;


}
