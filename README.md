# Pokemon TCG

## Resumen

Se implemento una version base del juego de cartas de pokemon, para esto se debio seguir algunas ideas que cimentaron la construccion del programa. En primera instancia nos definimos cuales serian los elementos que estarian en esta version del programa. Una instancia de Entrenador, el cual debe actuar como un primer escalon para la creacion de una intancia que el jugador controle. Cartas las cuales se dividieron en energias y pokemones.

Hablaremos primero de las energias, estas son cartas que se adieren a los pokemones para que estos despues puedan realizar sus acciones. Una energia sirve para indicar el coste de estas habilidades, por lo que si un pokemon no tiene las suficientes energias no podra realizar la accion deseada.

Las cartas de pokemon son las que realizan la mayor cantidad de acciones junto al entrenador, estas deben ser capaces de usar sus habilidades contra alguna otra carta de pokemon, poder tener conocimiento de las energias que poseen, como tambien tener registro de la vida restante que le queda.

El entrenador debe ser capaz de jugar esta distintas cartas al campo de juego y utilizarlas debidamente, es decir, si se ha jugado un pokemon, que este vaya a la banca del entrenador que lo ha jugado. Si juega una carta de energia, que esta se añada a la lista de energias del pokemon activo que se tiene en ese momento. Como tambien poder hacer la llamada a alguna de las habilidades que su pokemon activo posee.

## Patrones de diseño

Para tener este diseño se utilizo en gran parte homomorfismo, ya que se tenian muchos objetos distintos que debian llamarse por un mismo metodo, es por esto que se crearon las interfaces y clases abstractas necesarias para facilitar esto. Llamando desde los metodos a estas, cuando realmente estamos entrgando alguna de sus subclases. 

Ademas de esto se utilizo double dispatch para el uso de habilidades, o el saber que carta es la que se ha usado por el entrenador. Como tambien en los tipos de ataque a realizar, ataque es una de las sublcases de habilidad. Esto ultimo fue lo mas dificili de pensar, ya que debia saber mucho de quien estaba realizando una accion, quien era afectado, y por que ataque estaba siendo, valga la redundancia, atacado. Perogracias a una buena implementacion de double dispatch, se logro el objetivo.
