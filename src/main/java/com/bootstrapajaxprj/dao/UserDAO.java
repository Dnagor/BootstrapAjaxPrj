package com.bootstrapajaxprj.dao;

import com.bootstrapajaxprj.domain.User;
import com.bootstrapajaxprj.shared.AbstractCRUD;

public interface UserDAO extends AbstractCRUD<User> {
    User readUserByEmail(String email);
}
