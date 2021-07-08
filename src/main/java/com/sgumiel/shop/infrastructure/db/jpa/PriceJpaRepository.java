package com.sgumiel.shop.infrastructure.db.jpa;

import com.sgumiel.shop.infrastructure.db.model.PriceEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceJpaRepository extends CrudRepository<PriceEntity, Long>, JpaSpecificationExecutor<PriceEntity> {
}
