package ad.apiud6alumno.repositorio;

import ad.apiud6alumno.modelo.Puntuacion;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface PuntuacionRepositorio extends JpaRepository<Puntuacion,Long> {

}
