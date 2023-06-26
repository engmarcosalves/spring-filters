package br.com.geekcode.springfilters.pagination;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Getter
public class PageModel<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private long totalElements;
    private int pageNumber;
    private int totalPages;
    private int pageSize;
    private List<T> elements;
}
