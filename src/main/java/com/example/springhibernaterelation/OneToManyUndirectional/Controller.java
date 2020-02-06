package com.example.springhibernaterelation.OneToManyUndirectional;

import com.example.springhibernaterelation.GenericRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

@RestController
@Profile("2")
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

    Car car1 = new Car();
    car1.setCarName("BMW");
    Car car2 = new Car();
    car2.setCarName("Benz");
    Car car3 = new Car();
    car3.setCarName("Tiba");

    cars.add(car1);
    cars.add(car2);
    cars.add(car3);

    person.setCarList(cars);

    repository.save(person);

    return true;
  }
}
