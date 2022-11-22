package co.edu.edu.breweryservice;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "brewery")
public class Brewery {

  @Id
  @SequenceGenerator(
    name = "brewery_id_sequence",
    sequenceName = "brewery_id_sequence"
  )
  @GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "brewery_id_sequence"
  )
  private Integer id;
  private String name;
  private String location;
  private String image;
  private String address;
  private String phone;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    Brewery brewery = (Brewery) o;
    return id != null && Objects.equals(id, brewery.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
