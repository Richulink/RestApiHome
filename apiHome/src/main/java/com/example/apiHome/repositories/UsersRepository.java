package com.example.apiHome.repositories;

import com.example.apiHome.domain.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UsersRepository extends JpaRepository<Producto,Long> {

    Producto findByNombre(String nombre);
}
