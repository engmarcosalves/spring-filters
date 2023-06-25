package br.com.geekcode.springfilters.service;

import br.com.geekcode.springfilters.domain.Category;
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
        var categories = repository.findAll();
        return categories;
    }

}
