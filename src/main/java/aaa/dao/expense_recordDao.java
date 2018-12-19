package aaa.dao;

import aaa.entity.expense_record;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface expense_recordDao
{
    /**
     * 添加消费记录
     * @param expense_record
     * @return
     */
    @Insert("insert into expense_record values(#{expenseRecordId},#{customerinfoId},#{serviceId},#{serviceName},#{servicePrice},#{expenseMoney},#{adminId},#{updateDate})")
    public Integer insert_expense_record(expense_record expense_record);

    /**
     * 查询所有消费记录或根据键值和时间查询
     * @param keyValue
     * @param updateDate
     * @return
     */
    @Select({"<script>select e.* from expense_record as e inner join customer_info as c on e.customerinfoId=c.customerinfoId where 1=1 <if test=\"null!=updateDate and ''!=updateDate\">and e.updateDate like concat('%',#{updateDate},'%')</if><if test=\"null!=keyValue and ''!=keyValue\"> and (c.customerinfoName like concat('%',#{keyValue},'%') or c.phone like concat('%',#{keyValue},'%'))</if> order by e.updateDate desc </script>"})
    public List<expense_record> find_expense_recordBykeyValueorupdateDate(@Param("updateDate") String updateDate,@Param("keyValue") String keyValue);

    /**
     * 消费金额
     * @param date
     * @return
     */
    @Select("<script>select * from expense_record <if test=\"date!=''\">where date_format(updateDate,\"%Y-%m-%d\")=#{date}</if> </script>")
    public List<expense_record> currentDayExpense(@Param("date") String date);

    /**
     * 消费统计
     * @param customName
     * @return
     */
    @Select("<script>select c.customerinfoName customerinfoName,sum(e.expenseMoney) expenseMoney," +
            "avg(c.balance) balance,count(e.expenseMoney) expenseCount from customer_info c,expense_record e " +
            "where c.customerinfoId=e.customerinfoId <if test=\"customName!=''\">and c.customerinfoName like concat('%',#{customName},'%')</if> group by c.customerinfoName</script>")
    public List<Map<String,Object>> expenseStatistics(@Param("customName") String customName);

}
