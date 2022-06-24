package co.Demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import co.Demo.dao.ListRepository;
import co.Demo.dao.UserRepository;
import co.Demo.entity.Property;
import co.Demo.entity.User;

@Service
public class ListService implements IListService {

	@Autowired
	ListRepository listRepository;

	@Autowired
	UserRepository userRepository;

	@Override
	public Property createList(Property list) {
		if (list != null) {
			Long userId = list.getUserId();
			Optional<User> existingUser = userRepository.findById(userId);
			if (!existingUser.isPresent()) {
				return null;
			}

		}
		return listRepository.save(list);
	}

	@Override
	public List<Property> getLists(Integer pageNo, Integer pageSize, String sortBy) {

		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());

		Page<Property> pagedResult = listRepository.findAll(paging);

		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			return new ArrayList<Property>();
		}
	}

}
