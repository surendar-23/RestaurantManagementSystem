package com.restaurantmanagementsystem.service;

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

	public OwnerServiceImpl(OwnerRepository ownerRepository) {
		super();
		this.ownerRepository = ownerRepository;
	}

	@Override
	public Owner createOwner(Owner owner) {
		return ownerRepository.save(owner);
	}

	@Override
	public Owner getOwnerById(Long id) throws OwnerNotFoundException {
		Optional<Owner> optionalOwner = ownerRepository.findById(id);
		Owner owner;
		if (optionalOwner.isPresent()) {
			owner = optionalOwner.get();
		} else {
			throw new OwnerNotFoundException("Owner id not found : " + id);
		}
		return owner;
	}

	@Override
	public Owner updateOwner(Owner owner) {
		return ownerRepository.save(owner);
	}

	@Override
	public void deleteOwner(Long id) throws OwnerNotFoundException {
		if (ownerRepository.existsById(id)) {
			ownerRepository.deleteById(id);
		} else {
			throw new OwnerNotFoundException("Owner with ID : " + id + " not found");
		}
	}
}
