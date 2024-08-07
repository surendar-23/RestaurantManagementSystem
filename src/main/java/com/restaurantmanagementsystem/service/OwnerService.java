package com.restaurantmanagementsystem.service;

import com.restaurantmanagementsystem.entity.Owner;
import com.restaurantmanagementsystem.exception.OwnerNotFoundException;

public interface OwnerService {

	Owner createOwner(Owner owner);

	Owner getOwnerById(Long id) throws OwnerNotFoundException;

	Owner updateOwner(Owner owner);

	void deleteOwner(Long id) throws OwnerNotFoundException;
}
