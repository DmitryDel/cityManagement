package com.shendyuk.cityManagement.service;

import com.shendyuk.cityManagement.exception.EntityNotFoundException;
import com.shendyuk.cityManagement.exception.HomeAlreadyExistsException;
import com.shendyuk.cityManagement.model.Home;
import com.shendyuk.cityManagement.repository.HomeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HomeService {
    private final HomeRepository homeRepository;

    /**
     * Retrieves all Home entities.
     * This method returns a list of all Home entities stored in the database.
     *
     * @return A list of all Home entities.
     */
    public List<Home> findAll() {
        return homeRepository.findAll();
    }

    /**
     * Retrieves a Home entity by its ID.
     * This method attempts to find a Home entity by its ID. If the entity does not exist,
     * it throws an {@link EntityNotFoundException} with a message indicating that the
     * Home was not found.
     *
     * @param id The ID of the Home entity to find.
     * @return The Home entity associated with the specified ID.
     * @throws EntityNotFoundException if a Home with the specified ID does not exist.
     */
    public Home findById(Long id) {
        return homeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Дом по указанному ID: " + id + " не найден."));
    }

    /**
     * Saves a new Home entity to the database.
     * This method checks if a Home with the same street and number already exists.
     * If a Home with the same address exists, it throws a {@link HomeAlreadyExistsException}.
     *
     * @param home The Home entity to be saved. It must contain the street and number.
     * @return The saved Home entity.
     * @throws HomeAlreadyExistsException if a Home with the same street and number already exists.
     */
    public Home save(Home home) {
        if(isAddressExists(home.getStreet(), home.getNumber())) {
            throw new HomeAlreadyExistsException("Дом с указанным адресом уже существует:  " + home.getStreet() +
                    ", " + home.getNumber());
        }
        return homeRepository.save(home);
    }

    /**
     * Checks if a Home with the specified street and number already exists in the database.
     *
     * @param street The street of the Home to check.
     * @param number The number of the Home to check.
     * @return true if a Home with the specified street and number exists; false otherwise.
     */
    public boolean isAddressExists(String street, int number) {
        return homeRepository.existsByStreetAndNumber(street, number);
    }

    /**
     * Deletes a Home entity by its ID.
     * This method verifies if a Home with the given ID exists.
     * If so, it deletes the Home entity. If not, it throws an
     * {@link EntityNotFoundException} with a message indicating
     * that the Home was not found.
     *
     * @param id The ID of the Home entity to be deleted.
     * @throws EntityNotFoundException if a Home with the specified ID does not exist.
     */
    public void deleteById(Long id) {
        if(homeRepository.existsById(id)) {
            homeRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Дом по указанному ID: " + id + " не найден.");
        }
    }

    /**
     * Finds a Home by its street and number.
     *
     * @param street the street of the home
     * @param number the number of the home
     * @return the Home instance if found, or null if not found
     * @throws IllegalArgumentException if the street is null or empty
     */
    public Home findHome(String street, int number) {
        if(street == null || street.isEmpty()) {
            throw new IllegalArgumentException("Название улицы не может быть пустым.");
        } else if (number == 0) {
            throw new IllegalArgumentException("Номер дома не может быть равным нулю.");
        } else return homeRepository.findByStreetAndNumber(street, number);
    }
}
