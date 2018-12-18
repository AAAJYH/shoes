package aaa.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class customer_info
{
    private String customerinfoId;
    private String customerinfoName;
    private String phone;
    private double rechargeAmount;
    private double balance;
    private String adminId;
    private admin admin;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateDate;
}
