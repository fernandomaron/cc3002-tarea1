package game.visitor;

import game.habilidad.Ataques.Ataque;
import game.habilidad.Special.Special;

public interface VisitorAbility {
    void visitSpecial(Special s);
    void visitAttack(Ataque a);

}
