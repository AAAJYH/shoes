package aaa.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class recharge_record {
    private String rechargeRecordId;
    private String customerinfoId;
    private customer_info customer_info;
    private String setMealId;
    private set_meal set_meal;
    private double setMealPrice;
    private double givenPrice;
    private double rechargeMoney;
    private String adminId;
    private admin admin;
    private String errorCause;
    private String stateId;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateDate;
}
