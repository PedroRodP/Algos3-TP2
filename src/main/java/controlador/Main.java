package main.java.controlador;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import main.java.general.AlGoOh;
import main.java.general.Jugador;
import main.java.vistas.*;
//import org.mortbay.log.Log;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Observer;

public class Main extends Application {
    private final static int ANCHO = 1300;
    private final static int ALTO = 700;
    public static AlGoOh alGoOh;

    private static ArrayList<MonstruoGeneralVista> monstruoVistaSeleccionados = new ArrayList<>();
    private static ContenedorAccionesVista contenedorAcciones;
    private ContenedorTableros contenedorTableros;
    private ContenedorJugadores contenedorJugadores;
    private Jugador jugadorActual;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        LinkedList<String> nombres = Alerta.menuPrincipal();

        System.out.println(nombres.getFirst());
        stage.setTitle("Yu Gi Oh");

        alGoOh = new AlGoOh();
        jugadorActual = alGoOh.turnoActual();

        GridPane contAciones = new GridPane();
        contenedorAcciones = new ContenedorAccionesVista(contAciones);

        GridPane contenedorPrincipal = new GridPane();
        contenedorPrincipal.setBackground(new Background(new BackgroundImage(
                new Image("main/java/imagenes/otras/fondo5.jpg",0,0,false,true),
                null, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(0,0,false,
                false,false,true)
        )));
        setRowAndColumnConstraints(contenedorPrincipal);

        Pane pane = new Pane();
        contenedorPrincipal.add(pane,0,0);
        contenedorJugadores = new ContenedorJugadores(pane,alGoOh.obtenerJugadores(),nombres);

        GridPane contenedorTablero = new GridPane();
        contenedorPrincipal.add(contenedorTablero,1,0);
        contenedorTableros = new ContenedorTableros(alGoOh.obtenerJugadores(),contenedorTablero);

        contenedorPrincipal.add(contAciones,2,0);

        alGoOh.addObserver((o, arg) -> {
            removerAcciones();
            if (!jugadorActual.equals(alGoOh.turnoActual())){
                jugadorActual = alGoOh.turnoActual();
                contenedorTableros.cambiarTablero(jugadorActual);
                contenedorJugadores.cambiarJugador(jugadorActual);
                JugadorVista jugadorVista = contenedorJugadores.obtenerJugadorVista(jugadorActual);
                Alerta.display("Cambio de turno",
                        new Label("Turno de "+jugadorVista.obtenerNombre())
                );
            }
        });

        contenedorTableros.cambiarTablero(alGoOh.turnoActual());
        contenedorJugadores.cambiarJugador(alGoOh.turnoActual());


        Scene scene = new Scene(contenedorPrincipal, ANCHO, ALTO);
        stage.setScene(scene);
        stage.show();
    }

    private void setRowAndColumnConstraints(GridPane contenedorPrincipal){
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
    }

    public static void agregarAccion(AccionCartaVista accionCartaVista){
        contenedorAcciones.mostrarAccion(accionCartaVista);
    }

    public static void removerAcciones(){
        contenedorAcciones.removerAcciones();
    }


    public static void seleccionar(MonstruoGeneralVista monstruoVista){
        monstruoVistaSeleccionados.add(monstruoVista);
    }
    public static void desseleccionar(MonstruoGeneralVista monstruoVista){
        monstruoVistaSeleccionados.remove(monstruoVista);
    }
    public static void desseleccionarMonstruos(){
        ArrayList<MonstruoGeneralVista> clone = (ArrayList<MonstruoGeneralVista>) monstruoVistaSeleccionados.clone();
        for (MonstruoGeneralVista mv : clone)
            mv.deseleccionar();
    }

    public static ArrayList<MonstruoGeneralVista> obtenerMonstruosSeleccionados(){
        return monstruoVistaSeleccionados;
    }

    public static boolean estaEnFasePreparacion(){
        return alGoOh.obtenerNombreDeFase().equals(AlGoOh.FASE_PREPARACION);
    }
    public static boolean estaEnFaseAtaque(){
        return alGoOh.obtenerNombreDeFase().equals(AlGoOh.FASE_ATAQUE);
    }
    public static boolean estaEnFaseMagica(){
        return alGoOh.obtenerNombreDeFase().equals(AlGoOh.FASE_MAGICA);
    }
}

