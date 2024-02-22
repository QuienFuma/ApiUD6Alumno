package ad.apiud6Joel.controlador;

import ad.apiud6Joel.modelo.Juego;
import ad.apiud6Joel.repositorio.JuegoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/juego")
public class JuegoControlador {
    @Autowired
    private JuegoRepositorio juegoRepositorio;

    //OBTENER Juego
    @GetMapping
    public List<Juego> obtenerJuego(){
        return juegoRepositorio.findAll();
    }

    //Obtener un juego por su ID(get)
    @GetMapping("/{id}")
    public Juego obtenerJuegoID(@PathVariable Long id){
        Optional<Juego> resultado = juegoRepositorio.findById(id);
        return resultado.orElseThrow(()->
                new RuntimeException("Juego no encontrado"));
    }
    //Crear un juego(POST)
    @PostMapping
    public Juego crearJuego(@RequestBody Juego juego){
        return juegoRepositorio.save(juego);
    }

    //actualizar juego(Put)
    @PutMapping("/{id}")
    public Juego actualizarJuego(@PathVariable Long id,@RequestBody Juego juego){
        return juegoRepositorio.findById(id)
                .map(categoriaTemp -> {
                    categoriaTemp.setNombre(juego.getNombre());
                    return juegoRepositorio.save(categoriaTemp);
                }).orElseThrow(()-> new RuntimeException("Juego no encontrado"));
    }
    //eliminar juego

    @DeleteMapping("/{id}")
    public void eliminarJuego(@PathVariable Long id){
        juegoRepositorio.deleteById(id);
    }
}
