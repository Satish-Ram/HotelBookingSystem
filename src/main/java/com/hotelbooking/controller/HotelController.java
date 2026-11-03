
package com.hotelbooking.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.hotelbooking.entity.Hotel;
import com.hotelbooking.service.HotelService;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    // Add Hotel
    @PostMapping
    public Hotel addHotel(@RequestBody Hotel hotel) {
        return hotelService.saveHotel(hotel);
    }

    // Get All Hotels
    @GetMapping
    public List<Hotel> getAllHotels() {
        return hotelService.getAllHotels();
    }

    // Get Hotel By ID
    @GetMapping("/{id}")
    public Hotel getHotelById(@PathVariable Long id) {
        return hotelService.getHotelById(id);
    }

    // Update Hotel
    @PutMapping("/{id}")
    public Hotel updateHotel(@PathVariable Long id,
                             @RequestBody Hotel hotel) 
    {
    	hotel.setId(id);
        return hotelService.saveHotel(hotel);
    }

    // Delete Hotel
    @DeleteMapping("/{id}")
    public String deleteHotel(@PathVariable Long id) 
    {
        hotelService.deleteHotel(id);
        return "Hotel deleted successfully!";
    }
}
