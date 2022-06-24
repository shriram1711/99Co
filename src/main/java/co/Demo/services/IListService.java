package co.Demo.services;

import java.util.List;

import co.Demo.entity.Property;

public interface IListService {

	Property createList(Property list);

	List<Property> getLists(Integer page, Integer size, String sortBy);

}
