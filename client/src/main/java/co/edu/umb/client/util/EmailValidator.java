package co.edu.umb.client.util;

import co.edu.umb.client.exception.FindBeerException;
import co.edu.umb.client.lasting.EMessage;

import java.util.regex.Pattern;

public class EmailValidator {

  private static final String regex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
    + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

  public static void checkEmail(String email) throws FindBeerException {
    if (!Pattern.compile(regex).matcher(email).matches()){
      throw new FindBeerException(EMessage.ERROR_INVALID_EMAIL);
    }
  }
}
