package com.company.api.service;

import com.company.api.entity.Company;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CompanyService {
    void create(Company company);
    Page<Company> list(Integer page, Integer pageSize);
}
