package com.javastart.hellospring.service;

import com.javastart.hellospring.entity.Users;
import com.javastart.hellospring.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsersService {

    @Autowired
    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Transactional
    public void createUsers(Users users) {
        usersRepository.save(users);
    }

    @Transactional
    public List<Users> findAll(){
        return usersRepository.findAll();
    }

    @Transactional
    public Users findById(Long userId){
        return usersRepository.findById(userId).orElse(null);
    }

    @Transactional
    public List<Users> findAllByName(String name){
        return usersRepository.findAllByName(name);
    }

    @Transactional
    public List<Users> findWhereEmailIsGmail(){
        return usersRepository.findWhereEmailIsGmail();
    }

    @Transactional
    public List<Users> findWhereNameStartsFromRoman(){
        return usersRepository.findWhereNameStartsFromRoman();
    }
}