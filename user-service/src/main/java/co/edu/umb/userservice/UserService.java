package co.edu.umb.userservice;

import co.edu.umb.client.exception.FindBeerException;
import co.edu.umb.client.lasting.EMessage;
import co.edu.umb.client.service.user.UserRequest;
import co.edu.umb.client.util.EmailValidator;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public record UserService(
  UserRepository userRepository
) {

  public void registerUser(UserRequest request) throws FindBeerException {
    User user = User.builder()
      .name(request.name())
      .email(request.email())
      .password(new BCryptPasswordEncoder().encode(request.password()))
      .enable(Boolean.TRUE)
      .build();
    EmailValidator.checkEmail(user.getEmail());
    User userRegistered = userRepository
      .findUserByEmail(user.getEmail())
      .orElseThrow(() -> new FindBeerException(EMessage.ERROR_USER_REGISTERED));

    if (userRegistered.getId() != null) {
      throw new FindBeerException(EMessage.ERROR_USER_REGISTERED);
    }

    userRepository.save(user);
  }

  public UserRequest loginUser(UserRequest request) throws FindBeerException {
    User user = userRepository.findUserByEmailAndPassword(request.email(), request.password())
      .orElseThrow(() -> new FindBeerException(EMessage.DATA_NOT_FOUND));
    user.setPassword("");
    return new UserRequest(user.getId(), user.getName(), user.getEmail(), user.getPassword());
  }
}
