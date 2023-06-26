package br.com.geekcode.springfilters.service;

import br.com.geekcode.springfilters.pagination.FilterModel;
import br.com.geekcode.springfilters.pagination.PageModel;

import java.util.List;

public interface IListService<T> {

    public List<T> list();

    public PageModel<T> list(FilterModel filter);
}
