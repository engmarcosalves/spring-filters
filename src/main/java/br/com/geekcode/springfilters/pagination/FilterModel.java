package br.com.geekcode.springfilters.pagination;


import lombok.Getter;

import java.util.Map;

import static br.com.geekcode.springfilters.constant.ApiConstants.*;

@Getter
public class FilterModel {

    private int size;
    private int page;

    public FilterModel(Map<String, String> params) {
        this.size = params.containsKey(SIZE_KEY) ? Integer.valueOf(params.get(SIZE_KEY)) :  DEFAULT_SIZE;
        this.page = params.containsKey(PAGE_KEY) ? Integer.valueOf(params.get(PAGE_KEY)) :  DEFAULT_PAGE;
    }
}
