package aaa.dao;

import aaa.entity.expense_record;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

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
}
