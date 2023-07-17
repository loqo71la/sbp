package dev.loqo71la.bp.common.contant;

/**
 * Constants for HTTP Responses.
 */
public final class ResponseConstant {


    /**
     * Stores the pattern message for 'already exist' error.
     */
    public static final String ALREADY_EXIST = "Registro con %s [%s] ya existe.";

    /**
     * Stores the pattern message for 'not found' error.
     */
    public static final String NOT_FOUND = "Registro con %s [%s] no fue encontrado.";

    /**
     * Stores the pattern message for 'required property' error.
     */
    public static final String REQUIRED_PROPERTY = "La propiedad [%s] es requerida.";

    /**
     * Stores the pattern message for 'not found' error.
     */
    public static final String INVALID_TYPE = "El tipo de %s es invalido. Por favor utilize [%s].";

    /**
     * Stores the pattern message for 'not available' error.
     */
    public static final String BALANCE_NOT_AVAILABLE = "Saldo no disponible";

    /**
     * Stores the pattern message for 'limit exceeded' error.
     */
    public static final String DAILY_LIMIT_EXCEEDED = "Cupo diario Excedido";

    /**
     * Stores the pattern message of successfully action.
     */
    public static final String SUCCESSFULLY = "Registro ha sido %s correctamente.";

    /**
     * Stores the constant 'success'.
     */
    public static final String SUCCESS = "éxito";

    /**
     * Stores the constant 'error'.
     */
    public static final String ERROR = "error";

    /**
     * Stores the constant 'create'.
     */
    public static final String CREATE = "creado";

    /**
     * Stores the constant 'update'.
     */
    public static final String UPDATE = "actualizado";

    /**
     * Stores the constant 'remove'.
     */
    public static final String REMOVE = "eliminado";

    public static final String DEPOSIT = "Deposito";
    public static final String WITHDRAWAL = "Retiro";
    public static final String CHECKING = "Corriente";
    public static final String SAVINGS = "Ahorro";

    /**
     * Default Constructor.
     */
    private ResponseConstant() {
    }
}
