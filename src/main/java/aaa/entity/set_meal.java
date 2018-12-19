package aaa.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class set_meal implements Serializable
{
    private String setMealId;
    private String setMealName;
    private double setMealPrice;
    private double givenPrice;
    private String adminId;
    private admin admin;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date updateDate;
    private String stateId;
}
