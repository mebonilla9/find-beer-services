package co.edu.umb.client.lasting;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EMessage {

  ERROR_INVALID_EMAIL(-1, "Invalid email format"),
  ERROR_USER_REGISTERED(-1, "The user you are trying to register is already on the platform"),
  DATA_NOT_FOUND(0, "Data not found");

  private final Integer code;
  private final String message;

}
