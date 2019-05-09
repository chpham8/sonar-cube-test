package com.madhatter.kotlinboot.controller

import com.madhatter.kotlinboot.model.Animal
import com.madhatter.kotlinboot.model.AnimalClass
import com.madhatter.kotlinboot.model.AnimalOrder
import com.madhatter.kotlinboot.repository.*
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin
@RequestMapping("/animal")
class AnimalController (private val animalRepo: AnimalRepository){

    @GetMapping
    fun findAllAnimals(): Iterable<Animal>{
        return animalRepo.findAll()
    }

    @PostMapping("/create")
    fun createAnimal(@RequestBody newAnimal: Animal): Iterable<Animal>{
        animalRepo.save(newAnimal)
        return animalRepo.findAll()
    }
}

@RestController
@CrossOrigin
@RequestMapping("/order")
class OrderController(private val orderRepo: OrderRepository){
    @GetMapping
    fun findAllOrders(): Iterable<AnimalOrder>{
        return orderRepo.findAll()
    }

    @PostMapping("/create")
    fun createOrder(@RequestBody newOrder: AnimalOrder): Iterable<AnimalOrder>{
        orderRepo.save(newOrder)
        return orderRepo.findAll()
    }
}

@RestController
@CrossOrigin
@RequestMapping("/class")
class ClassController(private val classRepo: ClassRepository){
    @GetMapping
    fun findAllClasses(): Iterable<AnimalClass>{
        return classRepo.findAll()
    }

    @PostMapping("/create")
    fun createClass(@RequestBody newClass: AnimalClass): Iterable<AnimalClass>{
        classRepo.save(newClass)
        return classRepo.findAll()
    }
}
