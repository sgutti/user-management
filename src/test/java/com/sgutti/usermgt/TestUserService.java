/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.sgutti.usermgt;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sgutti.core.exception.ApplicationException;
import com.sgutti.usermgt.data.RoleData;
import com.sgutti.usermgt.data.UserData;

/**
 * @author Shanmu
 * @date Jul 7, 2014 7:22:25 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserService extends BaseTransactionTest {
    // --------------------------------------------------------------- Constants
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    @Autowired
    private UserService userService;

    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>TestUserService</code>
     */
    public TestUserService() {
        super();
    }

    // ---------------------------------------------------------- Public Methods
    /**
     * @throws ApplicationException
     */
    @Test
    public void testRetrieveAllUsers() throws ApplicationException {
        List<UserData> userData = userService.retrieveAllUsers(-1, "test",
                "test", true);
        Assert.assertNotNull(userData);
    }

    @Test
    public void testRetrieveAllUsersNegative() throws ApplicationException {
        List<UserData> userData = userService.retrieveAllUsers(-1, null, null,
                false);
        Assert.assertNotNull(userData);
    }

    @Test
    public void testCreateRole() throws ApplicationException {
        RoleData roleData = new RoleData();
        roleData.setName("role1");
        roleData.setDescription("role1");
        boolean flag = userService.createRole(-1, "sgutti", roleData);
        Assert.assertTrue(flag);
    }

    @Test
    public void testUpdateRole() throws ApplicationException {
        RoleData roleData = userService.retrieveRole(-1, 1);
        List<Long> permissionIDs = new ArrayList<Long>();
        for (int i = 0; i < 24; i++) {
            permissionIDs.add(Long.valueOf(i));
        }
        roleData.setPermissionIDs(permissionIDs);
        userService.updateRole(-1, "sgutti", roleData);
    }

    @Test
    public void testUpdateAdminRole() throws ApplicationException {
        RoleData roleData = userService.retrieveRole(-1, 1);
        boolean result = userService.updateRole(-1, "sgutti", roleData);
        Assert.assertTrue(result);
    }

    @Test
    public void testUpdateSupportRole() throws ApplicationException {
        RoleData roleData = userService.retrieveRole(-1, 1);
        boolean result = userService.updateRole(-1, "sgutti", roleData);
        Assert.assertTrue(result);
    }

    @Test
    public void testUsers() throws ApplicationException {
        List<UserData> users = userService.retrieveAllUsers(-1, "", "", false);
        Assert.assertNotNull(users);
    }
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
