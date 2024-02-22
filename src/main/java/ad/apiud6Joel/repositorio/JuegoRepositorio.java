package ad.apiud6Joel.repositorio;

import ad.apiud6Joel.modelo.Juego;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface JuegoRepositorio extends JpaRepository<Juego,Long> {

}
