package me.junhua.common.result;

public interface Page<T> {

    long getTotalPages();

    long getPageNo();

    long getPreviousPageNo();

    long getNextPageNo();
}
