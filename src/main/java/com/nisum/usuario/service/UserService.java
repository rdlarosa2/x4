package com.nisum.usuario.service;

import com.nisum.usuario.vo.UserVO;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface UserService {

    List<UserVO> findAll();

    UserVO getUserById(Integer userId);

    UserVO save(UserVO theUser);
}
