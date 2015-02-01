package com.vinxent.dao;

import java.util.List;

import com.vinxent.vo.User;

public interface UserDao {
	public int add(User user);  //���ص�ǰ�û�id
	public int delete(int id);  //-1ɾ��ʧ�ܣ�1Ϊɾ���ɹ�
	public int update(User user);  //����user
	public int updatePsw(int userId,String password);
	public List<User> queryAllUsers();
	public User queryUserById(int id);
	public User queryUserByUserName(String name);
}
