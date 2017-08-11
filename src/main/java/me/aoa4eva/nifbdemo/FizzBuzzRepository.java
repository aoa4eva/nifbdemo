package me.aoa4eva.nifbdemo;

import me.aoa4eva.nifbdemo.models.FizzBuzz;
import org.springframework.data.repository.CrudRepository;

public interface FizzBuzzRepository extends CrudRepository<FizzBuzz,Long> {
}
