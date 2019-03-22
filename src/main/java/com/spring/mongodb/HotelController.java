package com.spring.mongodb;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hotels")
public class HotelController {

  private HotelRepository hotelRepository;

  public HotelController(HotelRepository hotelRepository) {
    this.hotelRepository = hotelRepository;
  }

  @GetMapping("/")
  public List<Hotel> getAll() {
    return this.hotelRepository.findAll();
  }

  @GetMapping("/{id}")
  public Optional<Hotel> findByIds(@PathVariable("id") String id) {
    return this.hotelRepository.findById(id);
  }

  // put method to insert in database "only data is required in the body no id"
  @PutMapping
  public void insert(@RequestBody Hotel hotel) {
    this.hotelRepository.insert(hotel);
  }

  // Post method to insert in database "data & id both is required in the body"
  @PostMapping
  public void update(@RequestBody Hotel hotel) {
    this.hotelRepository.save(hotel);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable("id") String id) {
    this.hotelRepository.deleteById(id);
  }

  // filter by price - Less than ("findBy(PropertyName=PricePerNight)(Filter=LessThan)")
  @GetMapping("/price/{maxPrice}")
  public List<Hotel> getByPricePerNight(@PathVariable("maxPrice") int maxPrice) {
    return this.hotelRepository.findByPricePerNightLessThan(maxPrice);
  }

  // filter by address - query
  @GetMapping("/address/{city}")
  public List<Hotel> getByCity(@PathVariable("city") String city) {
    return this.hotelRepository.findByCity(city);
  }
}
