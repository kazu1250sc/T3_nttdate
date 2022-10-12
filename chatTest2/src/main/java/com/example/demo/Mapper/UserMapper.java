package com.example.demo.Mapper;

@Mapper
public interface UserMapper {

    /**ログインユーザー以外のユーザー取得(複数件)*/
    public List<MUser> findMany(int id);
}