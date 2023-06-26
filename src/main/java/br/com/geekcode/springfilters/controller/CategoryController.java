package br.com.geekcode.springfilters.controller;

import br.com.geekcode.springfilters.domain.Category;
import br.com.geekcode.springfilters.pagination.FilterModel;
import br.com.geekcode.springfilters.pagination.PageModel;
import br.com.geekcode.springfilters.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "categories")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping
    public ResponseEntity<PageModel<Category>> list(@RequestParam Map<String, String> params) {
        FilterModel filter = new FilterModel(params);
        PageModel<Category> categories = service.list(filter);
        return ResponseEntity.ok(categories);
    }
}
