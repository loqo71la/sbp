package dev.loqo71la.sbp.base.config;

//import com.fasterxml.jackson.databind.JsonMappingException;

import dev.loqo71la.sbp.base.dto.ResponseDto;
import dev.loqo71la.sbp.base.exception.AlreadyExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static dev.loqo71la.sbp.base.util.HttpUtil.error;

/**
 * Handles exceptions related to invalid data.
 */
public class GlobalExceptionHandler {

    /**
     * Handler for json mapping exception.
     *
     * @param ex json mapping instance.
     * @return ResponseEntity with custom exception
     */
//    @ExceptionHandler(JsonMappingException.class)
//    public ResponseEntity<ResponseDto> handleJsonMappingException(JsonMappingException ex) {
//        String propertyName = ex.getPath().get(0).getFieldName();
//        String errorMessage = String.format(ResponseConstant.REQUIRED_PROPERTY, propertyName);
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                .body(buildResultInfo(errorMessage));
//    }

    /**
     * Handler for bad request exception.
     *
     * @param ex bad request instance.
     * @return ResponseEntity with custom exception
     */
//    @ExceptionHandler(BadRequestException.class)
//    public ResponseEntity<ResponseDto> handleBadRequestException(BadRequestException ex) {
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                .body(buildResultInfo(ex.getMessage()));
//    }

    /**
     * Handler for invalid type exception.
     *
     * @param ex invalid type instance.
     * @return ResponseEntity with custom exception
     */
//    @ExceptionHandler(InvalidTypeException.class)
//    public ResponseEntity<ResponseDto> handleBadRequestException(InvalidTypeException ex) {
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                .body(buildResultInfo(ex.getMessage()));
//    }

    /**
     * Handler for item not found exception.
     *
     * @param ex item not found instance.
     * @return ResponseEntity with custom exception.
     */
//    @ExceptionHandler(NotFoundException.class)
//    public ResponseEntity<ResponseDto> handleItemNotFoundException(NotFoundException ex) {
//        return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                .body(buildResultInfo(ex.getMessage()));
//    }

    /**
     * Handler for already exist exception.
     *
     * @param exception already exist instance.
     * @return ResponseEntity with custom exception.
     */
    @ExceptionHandler(AlreadyExistException.class)
    public ResponseEntity<ResponseDto> handleAlreadyExistException(AlreadyExistException exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(error(exception));
    }
}
