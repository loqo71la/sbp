package dev.loqo71la.bp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.loqo71la.bp.common.contant.DtoConstant;

import java.util.List;

/**
 * Wraps a generic http response for collections.
 *
 * @param totalItem   total number of items.
 * @param totalPage   total number of pages.
 * @param currentPage current page requested;
 * @param items       list of items requested.
 * @param <T>         Generic type of wrapper.
 */
public record PageDto<T>(
        @JsonProperty(value = DtoConstant.TOTAL_ITEM) int totalItem,
        @JsonProperty(value = DtoConstant.TOTAL_PAGE) int totalPage,
        @JsonProperty(value = DtoConstant.CURRENT_PAGE) int currentPage,
        @JsonProperty(value = DtoConstant.ITEMS) List<T> items
) {
}
