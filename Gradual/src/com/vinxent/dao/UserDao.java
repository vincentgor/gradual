package com.vinxent.dao;

import java.util.List;

import com.vinxent.vo.User;

public interface UserDao {
	public int add(User user);  //返回当前用户id
	public int delete(int id);  //-1删除失败，1为删除成功
	public int update(User user);  //更新user
	public int updatePsw(int userId,String password);
	public List<User> queryAllUsers();
	public User queryUserById(int id);
	public User queryUserByUserName(String name);
}
