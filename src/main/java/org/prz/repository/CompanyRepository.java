/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.prz.repository;

import org.prz.entity.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Ola
 */
public interface CompanyRepository extends JpaRepository<Company, Integer> {
    public Page<Company> findByNameIgnoreCaseContainingOrderByNameAsc(Pageable pageable, String name);
}