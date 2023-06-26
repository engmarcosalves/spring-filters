package br.com.geekcode.springfilters.pagination;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Getter
public class PageModel<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long totalElements;
    private Integer currentPage;
    private Integer totalPages;
    private Integer pageSize;
    private List<T> elements;
}
