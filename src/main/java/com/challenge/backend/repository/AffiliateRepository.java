package com.challenge.backend.repository;

import com.challenge.backend.entity.Affiliate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface que contiene el CRUD con Spring JPA para la tabla de affiliate.
 *
 * @author Edison Restrepo - edisonestival@gmail.com
 * @version 1.0.0 2022-11-29
 * @since 1.0.0
 */
@Repository
public interface AffiliateRepository extends CrudRepository<Affiliate, Integer> {
}
