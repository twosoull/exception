package hello.exception.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason="error.bad") //BAD_REQUEST는 400이다. 더 다양한걸 보고 싶으면 클릭해서 뜯어볼 것
public class BadRequestException extends RuntimeException{


}
