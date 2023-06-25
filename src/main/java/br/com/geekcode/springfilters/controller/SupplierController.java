package br.com.geekcode.springfilters.controller;

import br.com.geekcode.springfilters.domain.Supplier;
import br.com.geekcode.springfilters.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "suppliers")
public class SupplierController {

    @Autowired
    private SupplierService service;

    @GetMapping
    public ResponseEntity<List<Supplier>> list() {
        List<Supplier> suppliers = service.list();
        return ResponseEntity.ok(suppliers);
    }
}
