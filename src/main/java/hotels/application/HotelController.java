package hotels.application;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by chaelee on 2017. 3. 7..
 */
@RestController
@RequestMapping(value = "/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @RequestMapping(value = "", method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
    public void createHotel(@RequestBody Hotel hotel, HttpServletRequest request, HttpServletResponse response) {
        Hotel createdHotel = this.hotelService.createHotel(hotel);
        response.setHeader("Location", request.getRequestURL().append("/").append(createdHotel.getId()).toString());
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = {"application/json"})
    public @ResponseBody
    Page<Hotel> getAllHotel(
        @RequestParam(value = "page", required = true) Integer page,
        @RequestParam(value = "size", required = true) Integer size,
        HttpServletRequest request, HttpServletResponse response) {
        return this.hotelService.getAllHotels(page, size);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {"application/json"})
    public @ResponseBody
    Hotel getHotel(@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Hotel hotel = this.hotelService.getHotel(id);
        return hotel;
    }
}
