package br.com.geekcode.springfilters.service;

import br.com.geekcode.springfilters.domain.Category;
import br.com.geekcode.springfilters.pagination.FilterModel;
import br.com.geekcode.springfilters.pagination.PageModel;
import br.com.geekcode.springfilters.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements IListService<Category>{

    @Autowired
    private CategoryRepository repository;

    @Override
    public List<Category> list() {
        return repository.findAll();
    }

    @Override
    public PageModel<Category> list(FilterModel filter) {
        int page = filter.getPage();
        int size = filter.getSize();

        Page<Category> categoryPage = repository.findAll(PageRequest.of(page, size));

        List<Category> categories = categoryPage.getContent();
        long totalElements = categoryPage.getTotalElements();
        int pageNumber = categoryPage.getNumber();
        int totalPages = categoryPage.getTotalPages();
        int pageSize = categoryPage.getSize();

        PageModel<Category> pageModel = new PageModel<>(totalElements, pageNumber, totalPages, pageSize, categories);

        return pageModel;
    }

}
