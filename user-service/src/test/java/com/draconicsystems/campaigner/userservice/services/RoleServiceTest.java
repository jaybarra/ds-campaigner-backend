package com.draconicsystems.campaigner.userservice.services;

import com.draconicsystems.campaigner.userservice.domain.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleServiceTest {

    @Autowired
    private RoleService roleService;

    @Test
    public void createRole_withNameAndDescription_roleCreated() {
        assertNotNull(roleService.createRole("FOO", "foo level administrator"));
    }

    @Test(expected = org.springframework.dao.DataIntegrityViolationException.class)
    public void createRole_withExistingRole_exceptionThrown() {
        assertNotNull(roleService.createRole("BAR", "BAR level administrator"));
        roleService.createRole("BAR", "BAR level administrator");
    }

    @Test
    public void getOrCreateRole_withName_roleCreated() {
        assertNotNull(roleService.getOrCreateRole("BAZ"));
    }

    @Test
    public void getOrCreateRole_withExistingName_roleReturned() {
        Role role = roleService.getOrCreateRole("DOG");
        assertEquals(role.getId(), roleService.getOrCreateRole("DOG").getId());
    }
}