package br.com.geekcode.springfilters.controller;

import br.com.geekcode.springfilters.domain.Product;
import br.com.geekcode.springfilters.pagination.FilterModel;
import br.com.geekcode.springfilters.pagination.PageModel;
import br.com.geekcode.springfilters.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public ResponseEntity<PageModel<Product>> list(@RequestParam Map<String, String> params) {
        FilterModel filter = new FilterModel(params);
        PageModel<Product> productPage = service.list(filter);
        return ResponseEntity.ok(productPage);
    }
}
