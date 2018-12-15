package aaa.entity;

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
    private Date updateDate;
    private String stateId;
}
