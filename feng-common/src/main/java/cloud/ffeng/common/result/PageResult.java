package cloud.ffeng.common.result;

import cloud.ffeng.common.support.TraceContext;

import java.util.List;

public class PageResult<T> extends Result<Page<T>> {

    public static <T> PageResult<T> page(Integer pageNum, Integer pageSize, Long totalSize, List<T> dataList) {
        PageResult<T> pageResult = new PageResult<>();
        Page<T> page = new Page<>();
        page.setPageNum(pageNum);
        page.setPageSize(pageSize);
        page.setTotalSize(totalSize);
        page.setCurrPageSize(dataList == null ? 0 : dataList.size());
        page.setDataList(dataList);
        pageResult.setData(page);

        pageResult.setStatus(ResultStatus.SUCCESS.getStatus());
        pageResult.setCode(ResultStatus.SUCCESS.getCode());
        pageResult.setMessage(null);
        pageResult.setTraceId(TraceContext.getTraceId());
        return pageResult;
    }

}
