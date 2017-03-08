package hotels.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * Created by chaelee on 2017. 3. 7..
 */
@Service
public class HotelService {
    private static final Logger log = LoggerFactory.getLogger(HotelService.class);

    @Autowired
    private HotelRepository hotelRepository;

    public HotelService() {}

    public Hotel createHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public Hotel getHotel(long id) {
        return hotelRepository.findOne(id);
    }

    public void updateHotel(Hotel hotel) {
        hotelRepository.save(hotel);
    }

    public Page<Hotel> getAllHotels(Integer page, Integer size) {
        Page pageOfHotels = hotelRepository.findAll(new PageRequest(page, size));

        return pageOfHotels;
    }
}

