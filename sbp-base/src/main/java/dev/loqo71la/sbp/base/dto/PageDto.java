package dev.loqo71la.sbp.base.dto;

import java.util.List;

public record PageDto<T>(int totalItems, int totalPages, int currentPage, List<T> items) {
}
