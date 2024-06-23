package repositories;


import domain.CD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CDRepository extends JpaRepository<CD, Integer> {
    List<CD> findByArtistAndPriceLessThan(String artist, double price);

    List<CD> findByArtist(@Param("artist") String artist);

    @Query("select c from CD c where c.artist=:artist and c.price>:price")
    List<CD> findByArtistAndPriceGreaterThan(@Param("artist") String artist,@Param("price") double price);

    @Query(value = "SELECT * FROM cd WHERE ARTIST = 'U2'", nativeQuery = true)
    List<CD> findByU2();
}
