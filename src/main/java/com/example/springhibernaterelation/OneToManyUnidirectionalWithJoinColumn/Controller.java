package com.example.springhibernaterelation.OneToManyUnidirectionalWithJoinColumn;

import com.example.springhibernaterelation.GenericRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

@Profile("3")
@RestController
public class Controller {

  @Autowired
  GenericRepository<Person, Long> repository;

  @RequestMapping(value = "/do")
  @ResponseBody
  @Transactional
  public Object make() {

    // one table person and one table car and one table for person_car

    Person person = new Person();
    person.setName("erfan");
    List<Car> cars = new ArrayList<>();

    Car car21 = new Car();
    car21.setCarName("BMW");
    Car car = new Car();
    car.setCarName("Benz");
    Car car23 = new Car();
    car23.setCarName("Tiba");

    cars.add(car21);
    cars.add(car);
    cars.add(car23);

    person.setCarList(cars);

    repository.save(person);

    return true;
  }
}
