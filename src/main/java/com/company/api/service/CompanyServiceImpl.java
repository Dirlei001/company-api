package com.company.api.service;

import com.company.api.entity.Company;
import com.company.api.repository.CompanyRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public void create(@Valid Company company) {
        log.info("Iniciando cadastro de empresa");
        try {
            company.setCreatedAt(LocalDateTime.now());
            this.companyRepository.save(company);
            log.info("Fim do cadastro da empresa");
        } catch (Exception ex) {
            log.error("Houve um erro ao tentar cadastrar");
            throw (ex);
        }
    }

    @Override
    public Page<Company> list(Integer page, Integer pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);

        return this.companyRepository.findAll(pageable);
    }
}
