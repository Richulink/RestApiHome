package com.example.apiHome.services;


import com.example.apiHome.domain.Producto;
import com.example.apiHome.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OperaService {

  private UsersRepository usersRepository;
    private Producto producto;

    public OperaService(@Autowired UsersRepository usersRepository, @Autowired Producto producto) {
        this.usersRepository = usersRepository;
        this.producto = producto;
    }

     public List<Producto> getUser() {
         return usersRepository.findAll();


     }


    public Optional<Producto> getProductoById(long id){
     return usersRepository.findById(id);
    }
    public Producto getProductoByNonmbre (String nombre){
        return usersRepository.findByNombre(nombre);
    }

    public Producto addProducto(Producto producto) {
        return usersRepository.save(producto);
    }
    
    public Producto actualizarProducto(Producto producto,Long id) {
        return usersRepository.save(producto);
    }


    public String deleteById(Long id) {
        usersRepository.deleteById(id);
        return "producto borrado" + id;
    }
    public String deleteAll(Producto producto) {
        usersRepository.deleteAll();
        return "todos los productos han sido borrados" + producto;
    }
}
