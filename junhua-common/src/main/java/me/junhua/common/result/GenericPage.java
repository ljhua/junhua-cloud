package me.junhua.common.result;

import java.util.ArrayList;
import java.util.List;

public class GenericPage<T> implements Page<T> {

    public final static long DEFAULT_PAGE_SIZE = 20;

    protected long pageNo = 1;
    protected long pageSize = DEFAULT_PAGE_SIZE;
    protected long totalRows = 0;
    protected List<T> list = new ArrayList<>();

    public GenericPage() {
        super();
    }

    public GenericPage(long totalRows, List<T> list) {
        this();
        this.totalRows = totalRows;
        this.list = list;
    }

    public GenericPage(long pageSize, long totalRows, List<T> list) {
        this(totalRows, list);
        this.pageSize = pageSize;
    }

    @Override
    public long getTotalPages() {
        long totalPages = totalRows / pageSize;
        if (totalRows % pageSize > 0) {
            totalPages++;
        }
        return totalPages;
    }

    @Override
    public long getPageNo() {
        return pageNo;
    }

    public void setPageNo(long pageNo) {
        this.pageNo = pageNo;
        if (pageNo < 1) {
            this.pageNo = 1;
        }
    }

    public long getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(long totalRows) {
        this.totalRows = totalRows;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public long getPreviousPageNo() {
        if (hasPreviousPage()) {
            return pageNo - 1;
        } else {
            return pageNo;
        }
    }

    @Override
    public long getNextPageNo() {
        if (hasNextPage()) {
            return pageNo + 1;
        } else {
            return pageNo;
        }
    }

    public boolean hasPreviousPage() {
        return (pageNo - 1 >= 1);
    }

    public boolean hasNextPage() {
        return (pageNo + 1 <= getTotalPages());
    }

}