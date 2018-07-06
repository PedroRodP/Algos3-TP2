package main.java.vistas;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import main.java.controlador.Main;
import main.java.general.AlGoOh;
import main.java.general.Jugador;

import java.util.ArrayList;

public class EscenaJugador {


        public static AlGoOh alGoOh;
        private  Scene scene;
        private static Stage stage;
        private static ArrayList<MonstruoGeneralVista> monstruoVistaSeleccionados = new ArrayList<>();
        private static ContenedorAccionesVista contenedorAcciones;
        private static GridPane contAciones;
        private final Jugador jugador;
        private EscenaJugador escenaOponente;
        private String nombre;
        private GridPane contenedorPrincipal;



    public EscenaJugador (Stage stage, Jugador jugador, String nombre){
            this.nombre = nombre;
            this.stage = stage;
            this.jugador=jugador;



            GridPane contenedorPrincipal = new GridPane();
            RowConstraints row = new RowConstraints();
            row.setPercentHeight(100);
            contenedorPrincipal.getRowConstraints().add(row);

            ColumnConstraints col1 = new ColumnConstraints();
            col1.setPercentWidth(15);
            ColumnConstraints col2 = new ColumnConstraints();
            col2.setPercentWidth(60);
            ColumnConstraints col3 = new ColumnConstraints();
            col3.setPercentWidth(25);

            contenedorPrincipal.getColumnConstraints().addAll(col1, col2, col3);

            GridPane contenedorJugadores = new GridPane();
            contenedorJugadores.setBackground(new Background(new BackgroundFill(Color.web("#456468"), CornerRadii.EMPTY, Insets.EMPTY)));
            llenarContenedorJugadores(jugador,contenedorJugadores);
            contenedorPrincipal.add(contenedorJugadores,0,0);

            GridPane contenedorTablero = new GridPane();
            llenarContenedorTablero(jugador,contenedorTablero);
            contenedorPrincipal.add(contenedorTablero,1,0);



            this.contenedorPrincipal=contenedorPrincipal;

            scene = new Scene(contenedorPrincipal, Main.ANCHO, Main.ALTO);

        }

        public void setearEscena(){
            contenedorPrincipal.add(contAciones,2,0);
            stage.setScene(scene);

        }

        private void llenarContenedorJugadores(Jugador jugador,GridPane contenedorJugadores){
            contenedorJugadores.setAlignment(Pos.CENTER);
            VBox vidaJugadores = new VBox(100);
            vidaJugadores.setAlignment(Pos.CENTER);

            VBox pane = new VBox(100);
            vidaJugadores.getChildren().add(pane);
            new JugadorVista(jugador,pane);





            contenedorJugadores.getChildren().addAll(new Label("turno jugador"+this.obtenerNombre()),vidaJugadores);
    }

    public static void agregarAccion(AccionCartaVista accionCartaVista){
        contenedorAcciones.mostrarAccion(accionCartaVista);
    }

    public static void removerAcciones(){
        contenedorAcciones.removerAcciones();
    }

    public boolean sosEste(Jugador jugador) {
        return jugador==this.jugador;
    }

    public static void setearCampoAcciones(){
        contAciones = new GridPane();
        contenedorAcciones = new ContenedorAccionesVista(contAciones);
    }

    public void setOponente(EscenaJugador escena){
        this.escenaOponente=escena;
    }

    public String obtenerNombre() {
        return this.nombre;
    }

    private void llenarContenedorTablero(Jugador jugador,GridPane contenedorTableros){
            ColumnConstraints col = new ColumnConstraints();
            col.setPercentWidth(100);
            contenedorTableros.getColumnConstraints().add(col);

                RowConstraints fila = new RowConstraints();
                fila.setPercentHeight(100 / 2);
                contenedorTableros.getRowConstraints().add(fila);
                GridPane pane = new GridPane();
                contenedorTableros.add(pane,0,0);
                new TableroVista(jugador,pane);

                RowConstraints fila1 = new RowConstraints();
                fila1.setPercentHeight(100 / 2);
                contenedorTableros.getRowConstraints().add(fila1);
                GridPane pane1 = new GridPane();
                contenedorTableros.add(pane1,0,1);
                new TableroRivalVista(jugador,pane1);

        }

        public static void seleccionar(MonstruoGeneralVista monstruoVista){
            monstruoVistaSeleccionados.add(monstruoVista);
        }
        public static void desseleccionar(MonstruoGeneralVista monstruoVista){
            monstruoVistaSeleccionados.remove(monstruoVista);
        }
        public static void desseleccionarMonstruos(){
            for (MonstruoGeneralVista monstruoVista : monstruoVistaSeleccionados)
                monstruoVista.seleccionar();
        }

        public static ArrayList<MonstruoGeneralVista> obtenerMonstruosSeleccionados(){
            return monstruoVistaSeleccionados;
        }
    }



