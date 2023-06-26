package br.com.geekcode.springfilters.service;

import br.com.geekcode.springfilters.domain.Category;
import br.com.geekcode.springfilters.pagination.FilterModel;
import br.com.geekcode.springfilters.pagination.PageModel;
import br.com.geekcode.springfilters.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        return new PageModel<>(repository.findAll(filter.toSprintPageable()));
    }

}
