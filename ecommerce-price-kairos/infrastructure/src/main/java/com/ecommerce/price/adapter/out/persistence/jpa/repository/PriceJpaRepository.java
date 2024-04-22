package com.ecommerce.price.adapter.out.persistence.jpa.repository;

import java.time.LocalDateTime;
import java.util.Collection;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.ecommerce.price.Price;
import com.ecommerce.price.adapter.out.persistence.jpa.mapper.PriceMapper;
import com.ecommerce.price.adapter.out.persistence.jpa.repository.base.BaseJpaRepository;
import com.ecommerce.price.repository.PriceRepository;


@Repository
public class PriceJpaRepository implements PriceRepository {

	private final BaseJpaRepository repository;
	private final PriceMapper mapper;

	@Inject
	public PriceJpaRepository(BaseJpaRepository repository, PriceMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public Collection<Price> findPriorityPriceByBrandProductAndDate(Integer brandId, Long productId, LocalDateTime selectedDate) {
		return this.mapper.mapTo(this.repository.findByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqual(
				brandId, productId, selectedDate, selectedDate));
	}

}
