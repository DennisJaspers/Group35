import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        try {
            User newUser = userService.registerUser(user);
            return ResponseEntity.ok(newUser);
        } catch (UserAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("/{email}")
    public ResponseEntity<User> updateUser(@PathVariable String email, @RequestBody User user) {
        try {
            User updatedUser = userService.updateUser(email, user);
            return ResponseEntity.ok(updatedUser);
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        } catch (DomainException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/age/{min}/{max}")
    public List<User> getUsersByAgeRange(@RequestParam int min, @RequestParam int max) {
        return userService.getUsersByAgeRange(min, max);
    }

    @GetMapping
    public List<User> getUsersByName(@RequestParam(required = false) String name) {
        if (name == null || name.isEmpty()) {
            return userService.getAllUsers();
        } else {
            return userService.getUsersByName(name);
        }
    }
    
    @DeleteMapping("/{email}/loans")
    public ResponseEntity<String> deleteLoansOfUser(@PathVariable String email) {
        try {
            userService.deleteLoansOfUser(email);
            return ResponseEntity.ok("Loans of user successfully deleted.");
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User does not exist.");
        } catch (ActiveLoansExistException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User has active loans.");
        } catch (NoLoansFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User has no loans.");
        }
    }

}
