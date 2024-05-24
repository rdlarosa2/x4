package com.nisum.usuario.service;

import com.nisum.usuario.dao.UserDAO;
import com.nisum.usuario.entity.Phone;
import com.nisum.usuario.entity.User;
import com.nisum.usuario.vo.PhoneVO;
import com.nisum.usuario.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO theUserDAO) {
        this.userDAO = theUserDAO;
    }

    @Override
    public List<UserVO> findAll() {
        List<User> list = this.userDAO.findAll();
        List<UserVO> voList = new ArrayList<UserVO>();

        for (User user : list) {

            List<Phone> phones = this.userDAO.getPhonesByUserId(user.getId());
            PhoneVO[] phonesVO = new PhoneVO[phones.size()];

            for (int i = 0; i < phones.size(); i++) {
                phonesVO[i] = new PhoneVO(phones.get(i).getNumber() ,phones.get(i).getCitycode() , phones.get(i).getCountrycode() );
            }

            UserVO vo = new UserVO(user.getId(), user.getName(), user.getEmail(), user.getPassword(), phonesVO );
            voList.add(vo);
        }
        return voList;
    }

    @Override
    public UserVO getUserById(Integer userId) {
        User theUser = this.userDAO.getUserById(userId);
        List<Phone> phones = this.userDAO.getPhonesByUserId(userId);
        PhoneVO[] phonesVO = new PhoneVO[phones.size()];

        for (int i=0; i<phones.size(); i++) {
            phonesVO[i] = new PhoneVO(phones.get(i).getNumber() ,phones.get(i).getCitycode() , phones.get(i).getCountrycode() );
        }

        return new UserVO( userId, theUser.getName(), theUser.getEmail(), theUser.getPassword(), phonesVO);
    }

    @Override
    public UserVO save(UserVO theUser) {

        User user = new User(theUser.getName(), theUser.getPassword(), theUser.getEmail());
        this.userDAO.save(user);

        PhoneVO[] arrayPhones = new PhoneVO[theUser.getPhones().length];
        for (int i=0 ; i < theUser.getPhones().length ; i++ ) {
            Phone phone = new Phone(user.getId(), theUser.getPhones()[i].getNumber(), theUser.getPhones()[i].getCitycode(), theUser.getPhones()[i].getCountrycode());
            this.userDAO.savePhone(phone);
            arrayPhones[i] = new PhoneVO(phone.getNumber(), phone.getCitycode(), phone.getCountrycode());
        }

        UserVO theUserVOResp = new UserVO(user.getId(), user.getName(),user.getPassword(), user.getEmail(),arrayPhones);
        return theUserVOResp;
    }
}
