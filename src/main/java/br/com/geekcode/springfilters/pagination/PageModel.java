package br.com.geekcode.springfilters.pagination;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.domain.Page;

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

    public PageModel(Page<T> page) {
        this.elements = page.getContent();
        this.totalElements = page.getTotalElements();
        this.pageNumber = page.getNumber();
        this.totalPages = page.getTotalPages();
        this.pageSize = page.getSize();
    }
}
