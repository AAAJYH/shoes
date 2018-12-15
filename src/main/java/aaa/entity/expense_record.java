package aaa.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class expense_record
{
    private String expenseRecordId;
    private String customerinfoId;
    private customer_info customer_info;
    private String serviceId;
    private String serviceName;
    private double servicePrice;
    private double expenseMoney;
    private String adminId;
    private admin admin;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateDate;
}
