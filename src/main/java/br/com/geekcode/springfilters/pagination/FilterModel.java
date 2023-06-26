package br.com.geekcode.springfilters.pagination;


import lombok.Getter;
import java.util.Map;

import static br.com.geekcode.springfilters.constant.ApiConstants.*;

@Getter
public class FilterModel {

    private Integer limit;
    private Integer page;

    public FilterModel(Map<String, String> params) {
        this.limit = params.containsKey(LIMIT_KEY) ? Integer.valueOf(params.get(LIMIT_KEY)) :  DEFAULT_LIMIT;
        this.page = params.containsKey(PAGE_KEY) ? Integer.valueOf(params.get(PAGE_KEY)) :  DEFAULT_PAGE;
    }
}
