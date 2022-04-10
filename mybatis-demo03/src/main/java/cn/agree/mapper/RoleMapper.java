package cn.agree.mapper;

import cn.agree.domain.Role;

import java.util.List;

public interface RoleMapper {

    /*
    *  查询所有角色信息
    *  包括user
    *
    * */
    List<Role> findRoleUserList();

}
