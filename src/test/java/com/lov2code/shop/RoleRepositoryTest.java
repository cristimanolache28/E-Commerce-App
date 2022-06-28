package com.lov2code.shop;

import com.lov2code.shop.repository.RoleRepository;
import com.lov2code.shop.entity.Role;
import com.lov2code.shop.repository.RoleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
// commit the changes after running that test
@Rollback(false)
public class RoleRepositoryTest {

    // @Autowire annotation let Spring framework inject an instance of the RoleRepository interface.
    @Autowired
    private RoleRepository roleRepository;


    @Test
    public void testCreateFirstRole() {
        Role roleAdmin = new Role("Admin", "manage everything");
        Role savedRole = roleRepository.save(roleAdmin);
        assertThat(savedRole.getId());
    }

    @Test void testCreateRestRoles() {
        Role roleSalesperson = new Role("Salesperson", "manage product price, " +
                " customers, shipping, orders and sales report");

        Role roleEditor = new Role("Editor", "manage categories, " +
                " brands, products, articles and menus");

        Role roleShipper = new Role("Shipper", "view products, view orders and update order status");

        Role roleAssistant = new Role("Assistant", "manage questions and reviews");

        Role savedRoleSalesperson = roleRepository.save(roleSalesperson);
        Role savedRoleEditor = roleRepository.save(roleEditor);
        Role savedRoleShipper = roleRepository.save(roleShipper);
        Role savedRoleAssistant = roleRepository.save(roleAssistant);

        assertThat(savedRoleSalesperson.getId());
        assertThat(savedRoleEditor.getId());
        assertThat(savedRoleShipper.getId());
        assertThat(savedRoleAssistant.getId());

    }

}

