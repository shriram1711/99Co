package co.Demo.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.Demo.entity.Property;

@Transactional
@Repository
public interface ListRepository extends PagingAndSortingRepository<Property, Long> {

}
