import com.bjike.reborn.common.api.exception.SerException;
import com.bjike.reborn.user.bo.rbac.PermissionBO;
import com.bjike.reborn.user.entity.*;
import com.bjike.reborn.user.entity.rbac.Permission;
import com.bjike.reborn.user.entity.rbac.Role;
import com.bjike.reborn.user.entity.rbac.UserRole;
import com.bjike.reborn.user.service.*;
import com.bjike.reborn.user.service.rbac.PermissionSer;
import com.bjike.reborn.user.service.rbac.RoleSer;
import com.bjike.reborn.user.service.rbac.UserRoleSer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import user_common_code.AppConfig;

import java.time.LocalDateTime;
import java.util.List;


/**
 * 权限认证业务测试
 *
 * @Author: [liguiqin]
 * @Date: [2016-11-23 15:47]
 * @Description: []
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class RbacTest {
    @Autowired
    private UserSer userAPI;
    @Autowired
    private RoleSer roleAPI;
    @Autowired
    private UserRoleSer userRoleAPI;
    @Autowired
    private PermissionSer permissionAPI;


    /**
     * 添加角色
     *
     * @throws SerException
     */
    @Test
    public void addRole() throws SerException {
        Role root = new Role();
        root.setName("根角色１");
        root.setDescription("无描述");
        Role child = new Role();
        child.setName("子角色１");
        child.setDescription("无描述");
        child.setParent(root);
        roleAPI.save(child);
    }


    /**
     * 添加用户角色
     *
     * @throws SerException
     */
    @Test
    public void addUserRole() throws SerException {
        Role role = roleAPI.findById("524fa88b-086f-4d9c-b962-4c6a3810a454");
        User user = null;
        UserRole userRole = new UserRole();
        userRole.setRole(role);
        userRole.setUser(user);
        userRoleAPI.save(userRole);
    }

    /**
     * 添加权限资源
     *
     * @throws SerException
     */
    @Test
    public void addPermission() throws SerException {
        Permission root = new Permission();
        root.setDescription("无描述");
        root.setResource("/");
        root.setName("根资源");
        Permission child = new Permission();
        child.setDescription("无描述");
        child.setResource("/service");
        child.setName("用户资源");
        child.setParent(root);
        permissionAPI.save(child);
    }

    /**
     * 查找用户角色
     *
     * @throws SerException
     */
    @Transactional
    @Test
    public void findUserRole() throws SerException {
        List<UserRole> userRoles = userRoleAPI.findAll();
        if (null != userRoles) {
            for (UserRole userRole : userRoles) {
                System.out.println(userRole);
            }
        }
    }

    /**
     * 添加角色权限资源
     *
     * @throws SerException
     */
    @Test
    public void addRolePermission() throws SerException {

        Role role = roleAPI.findById("524fa88b-086f-4d9c-b962-4c6a3810a454");
        if (null != role) {
            List<Permission> permissions_list = permissionAPI.findAll();
            roleAPI.update(role);
        }
    }


    /**
     * 更新权限资源
     *
     * @throws SerException
     */
    @Test
    public void updatePermissions() throws SerException {

        Permission permissions = permissionAPI.findById("72ae9d8f-9a25-45c1-b068-4387b2667b31"); //儿子
        Permission permission = permissions;
        Permission parent = new Permission();
        parent.setId("99ae9d8f-9a25-45c1-b068-4387b2667b33");//更改父节点为孙节点测试
        permission.setParent(parent);
        permissionAPI.update(permission);
        System.out.println(permission);
    }


    /**
     * 查询用户所拥有的所有权限资源
     *
     * @throws SerException
     */
    @Transactional
    @Test
    public void findAllPermissionByUserId() throws SerException {

    }





}
