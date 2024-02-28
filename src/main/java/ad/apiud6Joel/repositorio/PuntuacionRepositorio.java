package ad.apiud6Joel.repositorio;

import ad.apiud6Joel.modelo.Juego;
import ad.apiud6Joel.modelo.Puntuacion;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PuntuacionRepositorio extends JpaRepository<Puntuacion,Long> {
    List<Puntuacion> findAllByJuego(Optional<Juego> juego);
}
