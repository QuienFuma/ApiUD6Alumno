package ad.apiud6Joel.repositorio;

import ad.apiud6Joel.modelo.Juego;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JuegoRepositorio extends JpaRepository<Juego,Long> {
    public List<Juego> findJuegoByNombre(String nombre);
}
