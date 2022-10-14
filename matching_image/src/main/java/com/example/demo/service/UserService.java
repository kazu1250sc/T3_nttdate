package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserSearchRequest;
import com.example.demo.entity.User;
import com.example.demo.repository.UserMapper;

/**
 * ユーザー情報 Service
 */
@Service
public class UserService {
    /**
     * ユーザー情報 Mapper
     */
    @Autowired
    private UserMapper userMapper;

    /**
     * ユーザー情報検索
　　　* @param userSearchRequest リクエストデータ
     * @return 検索結果
     */
    public List<User> search(UserSearchRequest userSearchRequest) {
    //public User search(UserSearchRequest userSearchRequest) {
        return userMapper.search(userSearchRequest);
    }
    
    /**
     * パス情報検索
　　　* @param userSearchRequest リクエストデータ
     * @return 検索結果（パス情報）
     */
    public List<String> path(UserSearchRequest userSearchRequest) {
    //public User search(UserSearchRequest userSearchRequest) {
        return userMapper.path(userSearchRequest);
    }
}