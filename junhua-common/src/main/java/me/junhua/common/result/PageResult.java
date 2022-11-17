package me.junhua.common.result;

import java.util.List;

public class PageResult<T> {
    public static <T> GenericPage<T> data(long total, List<T> records) {
        return new GenericPage(total, records);
    }
}
