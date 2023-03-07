package cloud.ffeng.common.result;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Page<T> implements Serializable {

    private Integer pageNum;
    private Integer pageSize;
    private Long totalSize;
    private Integer currPageSize;
    private List<T> dataList;

}
