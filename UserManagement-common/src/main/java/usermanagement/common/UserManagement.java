package usermanagement.common;

import usermanagement.treeobjects.User;

import java.util.List;

public interface UserManagement {

    public Long createUser(String email, String password);
    public void deleteUser(String email);
    public void update(long key, User user);
    public List<User> readUsers();
}
