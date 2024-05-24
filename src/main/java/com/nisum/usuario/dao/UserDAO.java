package com.nisum.usuario.dao;

import com.nisum.usuario.entity.Phone;
import com.nisum.usuario.entity.User;

import java.util.List;

public interface UserDAO {
    User save(User theUser);

    User getUserById(Integer id);
    List<User> findAll();

    Phone savePhone(Phone thePhone);

    List<Phone> getPhonesByUserId(Integer userId);
}
