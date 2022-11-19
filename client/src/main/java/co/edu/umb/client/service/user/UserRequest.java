package co.edu.umb.client.service.user;

public record UserRequest(
  Integer id,
  String name,
  String email,
  String password
) {
}
