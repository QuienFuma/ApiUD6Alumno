package ad.apiud6alumno.repositorio;

import ad.apiud6alumno.modelo.Juego;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface JuegoRepositorio extends JpaRepository<Juego,Long> {

}
