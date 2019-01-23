package aaa.dao;

import aaa.entity.expense_record;
import org.apache.ibatis.annotations.*;

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
    @Insert({"<script>insert into expense_record(expenseRecordId,customerinfoId,serviceId,serviceName,servicePrice,expenseMoney,adminId<if test=\"null!=errorCause and ''!=errorCause\">,errorCause</if><if test=\"null!=stateId and ''!=stateId\">,stateId</if>,updateDate) values(#{expenseRecordId},#{customerinfoId},#{serviceId},#{serviceName},#{servicePrice},#{expenseMoney},#{adminId}<if test=\"null!=errorCause and ''!=errorCause\">,#{errorCause}</if><if test=\"null!=stateId and ''!=stateId\">,#{stateId}</if>,#{updateDate})</script>"})
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


    /**
     * 根据消费记录编号查询消费记录
     * @param expenseRecordId
     * @return
     */
    @Select("select * from expense_record where expenseRecordId=#{expenseRecordId}")
    public expense_record find_expense_recordByexpenseRecordId(@Param("expenseRecordId")String expenseRecordId);

    /**
     * 修改消费记录
     * @param expense_record
     * @return
     */
    @Update({"<script>update expense_record set expenseRecordId=expenseRecordId<if test=\"null!=customerinfoId and ''!=customerinfoId\">,customerinfoId=#{customerinfoId}</if><if test=\"null!=serviceId and ''!=serviceId\">,serviceId=#{serviceId}</if><if test=\"null!=serviceName and ''!=serviceName\">,serviceName=#{serviceName}</if><if test=\"null!=servicePrice and ''!=servicePrice\">,servicePrice=#{servicePrice}</if><if test=\"null!=expenseMoney and ''!=expenseMoney\">,expenseMoney=#{expenseMoney}</if><if test=\"null!=adminId and ''!=adminId\">,adminId=#{adminId}</if><if test=\"null!=errorCause and ''!=errorCause\">,errorCause=#{errorCause}</if><if test=\"null!=stateId and ''!=stateId\">,stateId=#{stateId}</if><if test=\"null!=updateDate\">,updateDate=#{updateDate}</if> where expenseRecordId=#{expenseRecordId}</script>"})
    public Integer update_expense_record(expense_record expense_record);
}
