package br.com.geekcode.springfilters.service;

import br.com.geekcode.springfilters.domain.Supplier;
import br.com.geekcode.springfilters.pagination.FilterModel;
import br.com.geekcode.springfilters.pagination.PageModel;
import br.com.geekcode.springfilters.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService implements IListService<Supplier>{

    @Autowired
    private SupplierRepository repository;

    @Override
    public List<Supplier> list()  {
        return repository.findAll();
    }

    @Override
    public PageModel<Supplier> list(FilterModel filter) {
        return null;
    }

}
