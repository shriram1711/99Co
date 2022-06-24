package co.Demo.services;

import java.util.List;

import co.Demo.entity.Property;
import co.Demo.entity.User;

public interface IPublicAPIService {

	List<Property> getPublicAPIListings();

	Property createPublicAPIListings(Property list);

	User createPublicAPIUser(User user);

}
