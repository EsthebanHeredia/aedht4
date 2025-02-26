package uvg.edu.gt;

/**
 * Interfaz que define la funcionalidad de la calcu
 */
public interface ICalculator {

    /**
     * Evalúa una expresión matemática y devuelve el resultado
     *
     * @param expression formato Postfix 
     * @return Resultado 
     * @throws Exception Si la expresión es inválida o hay un error en la operación
     */
    int evaluate(String expression) throws Exception;
}
