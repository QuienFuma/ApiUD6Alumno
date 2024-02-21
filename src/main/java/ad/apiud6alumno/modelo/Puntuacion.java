package ad.apiud6alumno.modelo;

import jakarta.persistence.*;

@Entity(name = "puntacion")
public class Puntuacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    long puntuacion;
    String modo;
    String nickJugador;
    @ManyToOne
    @JoinColumn(name="id_juego")
    private Juego juego;

    public Puntuacion() {
    }

    public Puntuacion(long puntuacion, String modo, String nickJugador) {
        this.puntuacion = puntuacion;
        this.modo = modo;
        this.nickJugador = nickJugador;
    }

    public String getModo() {
        return modo;
    }

    public void setModo(String modo) {
        this.modo = modo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(long puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getNickJugador() {
        return nickJugador;
    }

    public void setNickJugador(String nickJugador) {
        this.nickJugador = nickJugador;
    }
}
