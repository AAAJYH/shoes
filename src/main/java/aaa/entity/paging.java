package aaa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * 分页实体
 * @param <T>
 */
@Data
@AllArgsConstructor
public class paging<T> {

    private Integer total;
    private List<T> rows;

}
