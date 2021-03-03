package com.example.apiHome.services;


import com.example.apiHome.domain.Producto;
import com.example.apiHome.repositories.ProdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class OperaService {

  private ProdRepository prodRepository;
    private Producto producto;

    public OperaService(@Autowired ProdRepository prodRepository, @Autowired Producto producto) {
        this.prodRepository = prodRepository;
        this.producto = producto;
    }

     public List<Producto> getProduto() {
         return prodRepository.findAll();
     }

    public Optional<Producto> getProductoById(long id){
     return prodRepository.findById(id);
    }
    public Producto getProductoByNonmbre (String nombre){
        return prodRepository.findByNombre(nombre);
    }

    public Producto addProducto(Producto producto) {
        return prodRepository.save(producto);
    }
    
    public Producto actualizarProducto(Producto producto,Long id) {
        return prodRepository.save(producto);
    }


    public String deleteById(Long id) {
        prodRepository.deleteById(id);
        return "producto borrado" + id;
    }
    public String deleteAll(Producto producto) {
        prodRepository.deleteAll();
        return "todos los productos han sido borrados" + producto;
    }
}
