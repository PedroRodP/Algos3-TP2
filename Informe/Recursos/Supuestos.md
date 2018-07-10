-Campo lo llamamos Tablero para evitar confusi�n con las cartas de campo.
-Consideramos que un Monstruo en Modo Defensa no puede realizar un ataque.
-Por default, los monstruos se inicializan en Modo Defensa. Puede cambiarse apenas se crea llamando al m�todo colocarEnModoAtaque().
-Tomamos como supuesto que si un Monstruo ataca a otro Monstruo que se encuentre en Modo Defensa, �ste no infligir� da�o a su Jugador pero s� puede infligir da�o al Jugador atacante (por estar en Modo Ataque).
-Utilizamos los patrones Strategy, State y Double Dispatch.

2da entrega:

-BocaArriba y BocaAbajo funcionan con booleanos para evitar generalizaciones. No todas las cartas hacen lo mismo al estar BocaArriba.
-Utilizamos Factory Method para la creaci�n de cartas y las tomamos aleatoriamente para generar un Mazo.
-Cuando se seleccionan los Monstruos a sacrificar, se eval�a solamente que la cantidad sea la necesaria. Si hay m�s, se sacrificar�n los necesarios y se destruir�n los dem�s.
-Le delegamos la responsabilidad de colocarseEnTablero a los Monstruos ya que DragonBlancoDeOjosAzules tiene una forma propia de solicitar sacrificios.

-A Monstruo le paso Jugador (y no un objeto Vida) para notificar al Jugador que est� siendo atacado y �ste poder cambiar el EstadoDeJuego a Terminado declarando ganador al oponente (finalizarConGanador(ganador)).
