package ad.apiud6Joel.controlador;

import ad.apiud6Joel.modelo.Juego;
import ad.apiud6Joel.modelo.Puntuacion;
import ad.apiud6Joel.repositorio.JuegoRepositorio;
import ad.apiud6Joel.repositorio.PuntuacionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("api/puntuacion")
public class PuntuacionControlador {
    @Autowired
    private PuntuacionRepositorio puntuacionRepositorio;
    @Autowired
    private JuegoRepositorio juegoRepositorio;

    //Todos las puntuaciones
    @GetMapping
    public List<Puntuacion> obtenerPuntuacion(){
        return puntuacionRepositorio.findAll();
    }
    //Obtener una puntuacion por su id
    @GetMapping("/{id}")
    public Puntuacion obtenerPuntuacionesId(@PathVariable Long id){
        Optional<Puntuacion> resultado = puntuacionRepositorio.findById(id);
        return resultado.orElseThrow(()->
                new RuntimeException("Puntuacion no encontrada"));
    }

    //Todos las puntuaciones de una categoria
      @GetMapping("/categoria/{id}")
    public List<Puntuacion> obtenerPuntuacionesPorCategoria(@PathVariable Long id){
        Optional<Juego> juego = juegoRepositorio.findById(id);
        List<Puntuacion> resultado = puntuacionRepositorio.findAllByJuego(juego);
        return resultado;
    }

    //Crear puntuacion
    @PostMapping("/juego/{id}")
    public Puntuacion crearPuntuacion(@PathVariable Long id,@RequestBody Puntuacion puntuacion){
        Puntuacion rec = juegoRepositorio.findById(id).map(
                juego -> {
                    puntuacion.setJuego(juego);
                    return puntuacionRepositorio.save(puntuacion);
                }
        ).orElseThrow(() -> new RuntimeException("Recurso no encontrada"));
        return rec;
    }


    //actualizar una puntuacion
    @PutMapping("/{id}")
    public Puntuacion actualizarPuntuacion(@PathVariable Long id, @RequestBody Puntuacion puntuacion){
        return puntuacionRepositorio.findById(id)
                .map(puntuacionTemp ->{
                    puntuacionTemp.setPuntuacion((puntuacion.getPuntuacion()));
                    puntuacionTemp.setModo(puntuacion.getModo());
                    puntuacionTemp.setNickJugador(puntuacion.getNickJugador());
                    return puntuacionRepositorio.save(puntuacionTemp);
                }).orElseThrow(() -> new RuntimeException("Juego no encontrado"));
    }
    //eliminar puntuacion

    @DeleteMapping("/{id}")
    public void eliminarPuntuacion(@PathVariable Long id){
        puntuacionRepositorio.deleteById(id);
    }

}
