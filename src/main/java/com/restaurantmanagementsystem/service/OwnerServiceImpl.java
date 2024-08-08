package com.restaurantmanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurantmanagementsystem.entity.Owner;
import com.restaurantmanagementsystem.exception.OwnerNotFoundException;
import com.restaurantmanagementsystem.repository.OwnerRepository;

@Service
public class OwnerServiceImpl implements OwnerService {

	@Autowired
	private OwnerRepository ownerRepository;

	@Override
	public Owner createOwner(Owner owner) {
		return ownerRepository.save(owner);
	}

	@Override
	public Owner getOwnerById(Long id) {
		Optional<Owner> optionalOwner = ownerRepository.findById(id);
		return optionalOwner.orElseThrow(() -> new OwnerNotFoundException("Owner not found with id: " + id));
	}

	@Override
	public List<Owner> getAllOwners() {
		return ownerRepository.findAll();
	}

	@Override
	public Owner updateOwner(Owner owner) {
		if (ownerRepository.existsById(owner.getId())) {
			return ownerRepository.save(owner);
		} else {
			throw new OwnerNotFoundException("Owner not found with id: " + owner.getId());
		}
	}

	@Override
	public void deleteOwner(Long id) {
		if (ownerRepository.existsById(id)) {
			ownerRepository.deleteById(id);
		} else {
			throw new OwnerNotFoundException("Owner not found with id: " + id);
		}
	}
}
