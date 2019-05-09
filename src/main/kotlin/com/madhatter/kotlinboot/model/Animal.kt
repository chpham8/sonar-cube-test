package com.madhatter.kotlinboot.model

import javax.persistence.*

@Entity
@Table(name = "animal")
data class Animal(
        @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
        val id: Long,
        val name: String,
        val sciName: String,
        val lifespan: String,
        val mass: Long,
        val length: Long,
        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name="animalOrder_id")
        val orderName: AnimalOrder? = null,
        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name="animalClass_id")
        val aniClass: AnimalClass? = null
){
        override fun toString(): String{
                return "{id: ${this.id}, name: ${this.name}, order: ${orderName?.aniOrder}}"
        }
}

@Entity
@Table(name = "animalOrder")
data class AnimalOrder(
        @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
        val id: Long,
        val aniOrder: String
){
        override fun toString(): String{
                return "{order: ${this.aniOrder}}"
        }
}

@Entity
@Table(name = "animalClass")
data class AnimalClass(
        @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
        val id: Long,
        val aniClass: String
){
        override fun toString(): String{
                return "{class: ${this.aniClass}}"
        }
}
