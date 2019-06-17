# Pokemon TCG

## Resumen

Se implemento una version base del juego de cartas de pokemon, para esto se debio seguir algunas ideas que cimentaron la construccion del programa. En primera instancia nos definimos cuales serian los elementos que estarian en esta version del programa. Una instancia de Entrenador, el cual mantiene los datos de un jugador. Cartas las cuales se dividieron en energias, pokemones, objetos, estadio y soporte, las cuales llaman a un visitor para realizar sus distintas funciones. Y un controlador, el cual verifica el funcionamiento del juego, el paso de los turnos, y el elemento con elcual se controla el flujo del juego.

Hablaremos un poco acerca del controlador primero, este es el elemento que será entregado al usuario, con una instancia de este se puede simular un juego completo con los cambios de turno, algunas de las reglas básicas y manteniendo siempre la información necesaria.

El entrenador es una instancia que permite mantener información acerca de las cartas que tiene un jugador, mano, mazo, pila de descarte, banca, pokemon activo. Toda esta información la mantiene la instancia de entrenador y es capaz de jugar cartas si es que el controlador se lo permite, como también activar una habilidad de su pokemon activo.

Pokemon, estos mantiene información acerca de su vida, sus contadores de daño, habilidades que posee y energias a su disposición. Los pokemones son capaces de utilizar sus habilidades en contra de un pokemon objetivo. También dependiendo de si es un pokemon básico, fase 1 o fase 2, son jugados de distinta manera por el visitor. Tanto los fase 1 como los fase 2 mantienen el id del pokemon que es su anteevolución.

Objeto, son cartas que llaman al visitor para realizar un efecto sobre el pokemon objetivo del entrenador que la jugó.

Soporte, al igual que las objeto realizan un efecto sobre el pokemon objetivo del entrenador que la jugó, pero solo puede jugarse una de estas por turno.

Energía, cartas que le permiten a los pokemones realizar sus habilidades.

Estadio, durante un juego solo puede haber un estadio activo, por lo que el visitor al ver una nueva carta de estadio reemplaza la ya existente. El controlador es capaz de llamar al efecto del estadio sobre el entrenador que esta jugando el turno.

##Patrones utilizados

Se utilizó mucho el patrón de template, ya que muchos elementos compartian similitudes. Como lo son por ejemplo los distintos pokemones.

También se utilizó el visitor pattern para realizar el llamado a distintos metodos dependiendo de la carta que el entrenador jugaba.

Se utilizó un observer en el controlador, el cual observa a las habilidades de los pokemons que son jugados. Si un pokemon utiliza un ataque, esto informa al observer para que termine el turno del jugador y pase al siguiente turno.

Por último el controlador se puede ver como un gran adapter que proporciona control sobre el entrenador y sus metodos.
