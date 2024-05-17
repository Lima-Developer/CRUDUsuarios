package com.usuarios.CRUDUsuarios.services;

import com.usuarios.CRUDUsuarios.domains.User;
import com.usuarios.CRUDUsuarios.dtos.UserDTO;
import com.usuarios.CRUDUsuarios.repositories.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public User getById(Long id) throws Exception{
        Optional<User> user0 = userRepository.findById(id);
        if (user0.isEmpty())
            throw new Exception("User not found!");
        return user0.get();
    }

    public void saveUser(User user){
        this.userRepository.save(user);
    }

    public User createUser(UserDTO data){
        User newUser = new User(data);
        this.saveUser(newUser);
        return newUser;
    }

    public User updateUser(Long id, UserDTO data) throws Exception{
        Optional<User> user0 = userRepository.findUserById(id);
        if (user0.isEmpty())
            throw new Exception("User not found!");
        var newUser = user0.get();
        BeanUtils.copyProperties(data, newUser);
        return this.userRepository.save(newUser);

    }

    public void deleteUser(Long id) throws Exception{
        Optional<User> user0 = userRepository.findById(id);
        if (user0.isEmpty())
            throw new Exception("User not found!");
        this.userRepository.delete(user0.get());
    }
}
