package co.edu.edu.breweryservice;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BreweryRepository extends JpaRepository<Brewery, Integer> {

  Optional<Brewery> findBreweryById(Integer id);

}
