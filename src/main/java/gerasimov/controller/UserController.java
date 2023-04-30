package gerasimov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import gerasimov.repository.UserRepository;
import gerasimov.model.User;

/**
 * Controller class.
 */
@RestController
@RequestMapping(value = "/hibernate", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    UserRepository repository;

    @Autowired
    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    /**
     * Get User without CreditCard.
     * @param id
     * @return Json User
     */
    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable int id) {
        return repository.getUserById(id);
    }

    /**
     * Get user with CreditCards.
     * @param id
     * @return Json User.
     */
    @GetMapping("/userWithCards/{id}")
    public User getUserWithCardsById(@PathVariable int id) {
        User user = repository.getUserWithCardsById(id);
        System.out.println(user.getCards());
        return user;
    }
}
