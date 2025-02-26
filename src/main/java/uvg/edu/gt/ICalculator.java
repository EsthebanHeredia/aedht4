package uvg.edu.gt;

/**
 * Interfaz que define la funcionalidad de una calculadora capaz de evaluar expresiones.
 */
public interface ICalculator {

    /**
     * Evalúa una expresión matemática y devuelve el resultado.
     *
     * @param expression Expresión en formato postfix a evaluar.
     * @return Resultado de la evaluación.
     * @throws Exception Si la expresión es inválida o hay un error en la operación.
     */
    int evaluate(String expression) throws Exception;
}
