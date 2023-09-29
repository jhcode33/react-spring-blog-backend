package jhcode.blog.common.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
public class MemberException extends RuntimeException {

    private HttpStatus status;
    private String message;

    public MemberException(String message, HttpStatus status) {
        super(message);
        this.message = message;
        this.status = status;
    }
}
