package cn.guruguru.template.base.model.pagination;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Collection;

/**
 * General data transfer object (DTO) that contains totals and another DTO collection.
 *
 * @param <T> Class to wrap
 */
@Getter
@AllArgsConstructor
public class PaginationResult<T> {

    private final long total;
    private final Collection<T> collection;

    // ~ static methods -----------------------------------

    /**
     * A static method
     *
     * @param total total amount
     * @param collection a collection
     * @param <T> class
     * @return a {@link PaginationResult}
     */
    public static <T> PaginationResult<T> of(long total, Collection<T> collection) {
        return new PaginationResult<>(total, collection);
    }
}
