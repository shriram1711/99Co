package co.Demo.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import co.Demo.entity.User;

@Transactional
@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

}
