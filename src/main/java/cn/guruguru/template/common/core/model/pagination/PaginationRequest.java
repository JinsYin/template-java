package cn.guruguru.template.common.core.model.pagination;

import lombok.AllArgsConstructor;
import lombok.Data;

/** 分页及搜索通用模型 */
@Data
@AllArgsConstructor
public class PaginationRequest {
    /**
     * 页号，从 1 开始
     */
    private Integer pageNo;
    /**
     * 页大小
     */
    private Integer pageSize;
    /**
     * 搜索词
     */
    private String keyword;

    /**
     * A static method
     *
     * @param pageNo page no
     * @param pageSize page size
     * @param keyword search keyword
     * @return a {@link PaginationRequest}
     */
    public static PaginationRequest of(Integer pageNo, Integer pageSize, String keyword) {
        return new PaginationRequest(pageNo, pageSize, keyword);
    }
}
