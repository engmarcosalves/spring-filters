package br.com.geekcode.springfilters.pagination;


import lombok.Getter;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static br.com.geekcode.springfilters.constant.ApiConstants.*;

@Getter
public class FilterModel {

    private Integer size;
    private Integer page;
    private String sort;

    public FilterModel(Map<String, String> params) {
        this.size = params.containsKey(SIZE_KEY) ? Integer.valueOf(params.get(SIZE_KEY)) : DEFAULT_SIZE;
        this.page = params.containsKey(PAGE_KEY) ? Integer.valueOf(params.get(PAGE_KEY)) : DEFAULT_PAGE;
        this.sort = params.containsKey(SORT_KEY) ? String.valueOf(params.get(SORT_KEY)) : DEFAULT_SORT;
    }

    public Pageable toSprintPageable() {
        List<Order> orders = getOrders();
        return PageRequest.of(page, size, Sort.by(orders));
    }

    private List<Order> getOrders() {
        List<Order> orders = new ArrayList<>();

        String[] properties = sort.split(",");

        for (String property: properties) {
            if (!property.trim().isEmpty()) {
                String column = "";

                if (property.startsWith("-")) {
                    column = property.replace("-","").trim();
                    orders.add(Order.desc(column));
                } else {
                    column = property.trim();
                    orders.add(Order.asc(column));
                }
            }
        }
        return orders;
    }
}
