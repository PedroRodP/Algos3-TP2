-Campo lo llamamos Tablero para evitar confusión con las cartas de campo.
-Consideramos que un Monstruo en Modo Defensa no puede realizar un ataque.
-Por default, los monstruos se inicializan en Modo Defensa. Puede cambiarse apenas se crea llamando al método colocarEnModoAtaque().
-Tomamos como supuesto que si un Monstruo ataca a otro Monstruo que se encuentre en Modo Defensa, éste no infligirá daño a su Jugador pero sí puede infligir daño al Jugador atacante (por estar en Modo Ataque).
-Utilizamos los patrones Strategy, State y Double Dispatch.

2da entrega:

-BocaArriba y BocaAbajo funcionan con booleanos para evitar generalizaciones. No todas las cartas hacen lo mismo al estar BocaArriba.
-Utilizamos Factory Method para la creación de cartas y las tomamos aleatoriamente para generar un Mazo.
-Cuando se seleccionan los Monstruos a sacrificar, se evalúa solamente que la cantidad sea la necesaria. Si hay más, se sacrificarán los necesarios y se destruirán los demás.
-Le delegamos la responsabilidad de colocarseEnTablero a los Monstruos ya que DragonBlancoDeOjosAzules tiene una forma propia de solicitar sacrificios.

-A Monstruo le paso Jugador (y no un objeto Vida) para notificar al Jugador que está siendo atacado y éste poder cambiar el EstadoDeJuego a Terminado declarando ganador al oponente (finalizarConGanador(ganador)).
