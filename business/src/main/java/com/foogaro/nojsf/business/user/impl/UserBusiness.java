package com.foogaro.nojsf.business.user.impl;

import com.foogaro.nojsf.business.ACRUDBusiness;
import com.foogaro.nojsf.business.exception.BusinessException;
import com.foogaro.nojsf.business.user.IUserBusiness;
import com.foogaro.nojsf.model.UserDTO;
import com.foogaro.nojsf.persistence.exception.PersistenceException;
import com.foogaro.nojsf.persistence.user.IUserPersistence;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Dependent
@Named
public class UserBusiness extends ACRUDBusiness<UserDTO> implements IUserBusiness {

    @Inject
    private IUserPersistence userPersistence;

    @Override
    public List<UserDTO> findAll() throws BusinessException {
        try {
            return userPersistence.findAll();
        } catch (PersistenceException e) {
            throw new BusinessException(e);
        }
    }
}
