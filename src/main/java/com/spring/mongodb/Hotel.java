package com.spring.mongodb;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "Hotels")
public class Hotel {

  @Id private String id;
  private int pricePerNight;
  private String name;
  private Address address;
  private List<Review> reviews;

  protected Hotel() {
    reviews = new ArrayList<>();
  }

  public Hotel(String name, int pricePerNight, Address address, List<Review> reviews) {
    this.name = name;
    this.address = address;
    this.pricePerNight = pricePerNight;
    this.reviews = reviews;
  }

  public int getPricePerNight() {
    return pricePerNight;
  }

  public String getName() {
    return name;
  }

  public Address getAddress() {
    return address;
  }

  public List<Review> getReviews() {
    return reviews;
  }
}
