package com.spring.mongodb;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class DbSeeder implements CommandLineRunner {

  private HotelRepository hotelRepository;

  public DbSeeder(HotelRepository hotelRepository) {
    this.hotelRepository = hotelRepository;
  }

  @Override
  public void run(String... args) throws Exception {
    Hotel hotel =
        new Hotel(
            "Sunlight",
            4000,
            new Address("USA", "India"),
            Arrays.asList(new Review("John", 5, false), new Review("John", 8, true)));

    Hotel star =
        new Hotel(
            "Punjab Grills",
            5000,
            new Address("Australia", "India"),
            Arrays.asList(new Review("Tom", 5, false), new Review("Tom", 8, true)));

    Hotel taj =
        new Hotel(
            "Taj Hotel",
            6000,
            new Address("Mumbai", "India"),
            Arrays.asList(new Review("Pravin", 5, false), new Review("Sreela", 8, true)));

    Hotel oberoi =
        new Hotel(
            "Oberoi Hotel",
            7000,
            new Address("Pune", "India"),
            Arrays.asList(new Review("Sreela", 5, false), new Review("Pravin", 8, true)));

    //  Drop all hotels
    this.hotelRepository.deleteAll();

    //  Add our hotels to database
    List<Hotel> hotels = Arrays.asList(hotel, star, taj, oberoi);
    this.hotelRepository.saveAll(hotels);
  }
}
