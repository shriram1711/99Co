package co.Demo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import co.Demo.entity.Property;
import co.Demo.entity.User;

@Service
public class PublicAPIService implements IPublicAPIService {

	@Override
	public List<Property> getPublicAPIListings() {
		return null;
	}

	@Override
	public Property createPublicAPIListings(Property list) {
		return null;
	}

	@Override
	public User createPublicAPIUser(User user) {
		return null;
	}

}
