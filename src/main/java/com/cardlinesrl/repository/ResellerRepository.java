package com.cardlinesrl.repository;


import com.cardlinesrl.domain.Reseller;
import org.springframework.data.repository.CrudRepository;

//@Repository
public interface ResellerRepository extends CrudRepository<Reseller, Integer> {

    // Reseller findByPlataformaId(Integer resellerId);

}
