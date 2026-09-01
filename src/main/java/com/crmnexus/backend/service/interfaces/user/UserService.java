package com.crmnexus.backend.service.interfaces.user;



public interface UserService {

void updateUser();
void changePassword(String oldPassword, String newPassword);
void deleteUser();
}
