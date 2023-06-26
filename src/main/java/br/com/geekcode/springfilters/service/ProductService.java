package br.com.geekcode.springfilters.service;

import br.com.geekcode.springfilters.domain.Product;
import br.com.geekcode.springfilters.pagination.FilterModel;
import br.com.geekcode.springfilters.pagination.PageModel;
import br.com.geekcode.springfilters.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IListService<Product> {

    @Autowired
    private ProductRepository repository;

    @Override
    public List<Product> list() {
        List<Product> products = repository.findAll();
        return products;
    }

    @Override
    public PageModel<Product> list(FilterModel filter) {
        return null;
    }

}
