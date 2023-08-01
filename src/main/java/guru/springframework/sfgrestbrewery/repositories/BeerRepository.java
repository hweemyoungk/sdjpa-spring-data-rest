package guru.springframework.sfgrestbrewery.repositories;


import guru.springframework.sfgrestbrewery.domain.Beer;
import guru.springframework.sfgrestbrewery.domain.BeerStyleEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource(
        path = "beer", // Routes to {base-path}/beer
        collectionResourceRel = "beer" // Responds entities like "beer": [{...}, ...]
)
public interface BeerRepository extends JpaRepository<Beer, UUID> {
    /*
    * Can call repository methods by:
    * {endpoint}/search/{repository method}?{query params}
    * */
    Page<Beer> findAllByBeerName(String beerName, Pageable pageable); // /api/v1/beer/search/findAllByBeerName?beerName=foo

    Page<Beer> findAllByBeerStyle(BeerStyleEnum beerStyle, Pageable pageable);

    Page<Beer> findAllByBeerNameAndBeerStyle(String beerName, BeerStyleEnum beerStyle, Pageable pageable);

    Beer findByUpc(String upc);
}
