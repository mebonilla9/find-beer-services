package co.edu.umb.client.service.brewery;

public record BreweryRequest(
  Integer id,
  String name,
  String location,
  String image,
  String address,
  String phone
) {
}
