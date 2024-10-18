package com.company.api.controller;

import com.company.api.entity.Company;
import com.company.api.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/company")
public class CompanyRestController {
    @Autowired
    private CompanyService companyService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Company company){
        this.companyService.create(company);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<Page<Company>> list(@RequestParam Integer page, @RequestParam Integer pageSize){
        return ResponseEntity.ok(this.companyService.list(page, pageSize));
    }
}
