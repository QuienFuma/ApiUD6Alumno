package ad.apiud6Joel.repositorio;

import ad.apiud6Joel.modelo.Puntuacion;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface PuntuacionRepositorio extends JpaRepository<Puntuacion,Long> {

}
