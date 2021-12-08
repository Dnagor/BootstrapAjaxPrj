package com.bootstrapajaxprj.service;

import com.bootstrapajaxprj.domain.User;
import com.bootstrapajaxprj.shared.AbstractCRUD;

public interface UserService extends AbstractCRUD<User> {
    User readUserByEmail(String email);
}
