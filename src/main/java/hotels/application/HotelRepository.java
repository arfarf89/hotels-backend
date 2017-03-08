package hotels.application;

import hotels.application.Hotel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by chaelee on 2017. 3. 7..
 */
@RepositoryRestResource(collectionResourceRel = "hotels", path = "hotels")
public interface HotelRepository extends PagingAndSortingRepository<Hotel, Long> {

    Hotel findHotelByCity(String city);
    Page findAll(Pageable pageable);
}
