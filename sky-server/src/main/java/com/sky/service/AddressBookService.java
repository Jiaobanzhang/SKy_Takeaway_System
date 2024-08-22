package com.sky.service;

import com.sky.entity.AddressBook;
import java.util.List;

/**
 * @autor: 我亦无他，唯手熟尔
 */
public interface AddressBookService {
    List<AddressBook> list(AddressBook addressBook);

    void save(AddressBook addressBook);

    AddressBook getById(Long id);

    void update(AddressBook addressBook);

    void setDefault(AddressBook addressBook);

    void deleteById(Long id);
}
