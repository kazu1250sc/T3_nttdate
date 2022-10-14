package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.UserSearchRequest;
import com.example.demo.entity.User;

/**
 * ユーザー情報 Mapper
 */
@Mapper
public interface UserMapper {
    /**
     * ユーザー情報検索
     * @param user 検索用リクエストデータ
     * @return ユーザー情報
     */
    List<User> search(UserSearchRequest user);
    
    
    /**
     * ユーザー情報の画像パスの検索
     * @param user 検索用リクエストデータ
     * @return パス情報
     */
    List<String> path(UserSearchRequest user);
}