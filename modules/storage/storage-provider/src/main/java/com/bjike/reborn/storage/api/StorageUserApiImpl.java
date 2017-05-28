package com.bjike.reborn.storage.api;

import com.bjike.reborn.common.api.exception.SerException;
import com.bjike.reborn.storage.bo.StorageUserBO;
import com.bjike.reborn.storage.service.StorageUserSer;
import com.bjike.reborn.storage.to.StorageUserTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 存储模块用户业务接口实现
 *
 * @Author: [ liguiqin ]
 * @Date: [ 2017-03-30 09:39 ]
 * @Description: [ 存储模块用户业务接口实现 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [ com.bjike ]
 */
@Service("storageUserApiImpl")
public class StorageUserApiImpl implements StorageUserAPI {

    @Autowired
    private StorageUserSer storageUserSer;

    @Override
    public StorageUserBO register(StorageUserTO storageUserTO) throws SerException {
        return storageUserSer.register(storageUserTO);
    }

    @Override
    public String login(StorageUserTO storageUserTO) throws SerException {
        return storageUserSer.login(storageUserTO);
    }

    @Override
    public Boolean signOut(String storageToken) throws SerException {
        return storageUserSer.signOut(storageToken);
    }

    @Override
    public StorageUserBO getCurrentUser(String storageToken) throws SerException {
        return storageUserSer.getCurrentUser(storageToken);
    }

    @Override
    public String getCurrentModule(String storageToken) throws SerException {
        return storageUserSer.getCurrentModule(storageToken);
    }
    @Override
    public String getCurrentSysNO(String storageToken) throws SerException {
        return storageUserSer.getCurrentSysNO(storageToken);
    }

}