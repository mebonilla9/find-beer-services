package co.edu.umb.client.exception;

import co.edu.umb.client.lasting.EMessage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FindBeerException extends Exception{

  private Integer code;
  private String message;

  public FindBeerException(EMessage message) {
    this.code = message.getCode();
    this.message = message.getMessage();
  }
}
