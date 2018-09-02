package com.draconicsystems.campaigner.userservice.services;

import com.draconicsystems.campaigner.userservice.domain.Permission;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PermissionServiceTest {

    @Autowired
    PermissionService permissionService;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void createPermission_withNameAndDescription_permissionCreated() {
        Permission permission = permissionService.createPermission("CREATE_CHARACTER", "Can create a character");
        assertEquals("CREATE_CHARACTER", permission.getName());
        assertEquals("Can create a character", permission.getDescription());
    }
}