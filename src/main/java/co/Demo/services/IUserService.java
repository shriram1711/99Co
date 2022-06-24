package co.Demo.services;

import java.util.List;

import co.Demo.entity.User;

public interface IUserService {

	User createUser(User user);

	User getUser(Long id);

	List<User> getUsers(Integer pageNo, Integer pageSize, String sortBy);

}
