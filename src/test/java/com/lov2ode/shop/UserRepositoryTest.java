package com.lov2ode.shop;

import com.lov2ode.shop.entity.Role;
import com.lov2ode.shop.entity.User;
import com.lov2ode.shop.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

//It is used to test JPA repositories
@DataJpaTest
// Don't replace the application default DataSource.
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@Rollback(false)
public class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateUserWithOneRole() {
        Role roleAdmin = entityManager.find(Role.class, 1);
        User user = new User("Florin", "Radu", "florin@yahoo.com", "");
        user.addRole(roleAdmin);

        User savedAdminUser = repository.save(user);

        assertThat(savedAdminUser.getId()).isGreaterThan(0);
    }

    @Test
    public void testCreateNewUserWithTwoRole() {
        User user = new User("Cristian", "Manolache", "cristianmanolache0@gmail.com", "");
        Role roleEditor = new Role(3);
        Role roleAssistant = new Role(5);

        user.addRole(roleEditor);
        user.addRole(roleAssistant);

        User savedUser = repository.save(user);
        assertThat(savedUser.getId()).isGreaterThan(0);
    }

    @Test
    public void testListAllUsers() {
        Iterable<User> listUsers = repository.findAll();
        listUsers.forEach(System.out::println);
    }

    @Test
    public void testGetUserById() {
        User findUser = repository.findById(1).get();
        System.out.println(findUser);
        assertThat(findUser).isNotNull();
    }

    @Test
    public void testUpdateUserDetails() {
        User userFlorin = repository.findById(1).get();
        userFlorin.setFirstName("Florinel");
        userFlorin.setEmail("raduradu@yahoo.com");

        repository.save(userFlorin);
    }

    @Test
    public void testUpdateUserRoles() {
        User user = repository.findById(1).get();
        Role roleAssistant = new Role(5);
        Role roleSalesperson = new Role(2);

        user.getRoles().remove(roleAssistant);
        user.addRole(roleSalesperson);
    }

    @Test
    public void testDeleteUser() {
        Integer userId = 2;
        repository.deleteById(userId);
        repository.findById(userId);
    }

}
