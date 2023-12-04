package com.yblog.entity;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface Page<T> extends Iterable<T> {

    int getNumber();
    int getSize();
    int getTotalPages();
    int getNumberOfElements();
    long getTotalElements();
    boolean hasPreviousPage();
    boolean isFirstPage();
    boolean hasNextPage();
    boolean isLastPage();
    Pageable nextPageable();
    Pageable previousPageable();
    List<T> getContent();
    boolean hasContent();
    Sort getSort();

}
