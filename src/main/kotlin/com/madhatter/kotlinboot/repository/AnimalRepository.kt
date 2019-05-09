package com.madhatter.kotlinboot.repository

import com.madhatter.kotlinboot.model.*
import org.springframework.data.repository.CrudRepository

interface AnimalRepository : CrudRepository<Animal, Long>
interface OrderRepository : CrudRepository<AnimalOrder, Long>
interface ClassRepository : CrudRepository<AnimalClass, Long>
