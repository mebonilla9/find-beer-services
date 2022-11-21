package co.edu.umb.userservice;

import co.edu.umb.client.exception.FindBeerException;
import co.edu.umb.client.service.user.UserRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/v1/users")
public record UserController(
  UserService userService
) {

  @PostMapping("/register")
  public ResponseEntity<?> registerUser(@RequestBody UserRequest request) throws FindBeerException {
    userService.registerUser(request);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @PostMapping("/login")
  public ResponseEntity<?> loginUser(@RequestBody UserRequest request) throws FindBeerException {
    UserRequest user = userService.loginUser(request);
    return new ResponseEntity<>(user, HttpStatus.OK);
  }
}
