package aaa.util;

import java.math.BigDecimal;

public class doubleSum {

    public static double sum(double d1,double d2){
        BigDecimal b1=new BigDecimal(Double.toString(d1));
        BigDecimal b2=new BigDecimal(Double.toString(d2));
        return b1.add(b2).doubleValue();
    }

}
