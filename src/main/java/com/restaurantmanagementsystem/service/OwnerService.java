package com.restaurantmanagementsystem.service;

import java.util.List;

import com.restaurantmanagementsystem.entity.Owner;

public interface OwnerService {

	Owner createOwner(Owner owner);

	Owner getOwnerById(Long id);

	List<Owner> getAllOwners();

	Owner updateOwner(Owner owner);

	void deleteOwner(Long id);
}
