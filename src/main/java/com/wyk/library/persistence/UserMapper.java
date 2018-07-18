/**
 * 
 */
package com.wyk.library.persistence;

import org.springframework.stereotype.Repository;

import com.wyk.library.model.User;
import com.wyk.framework.mybatis.BaseMapper;

@Repository
public interface UserMapper extends BaseMapper<User> {

}
