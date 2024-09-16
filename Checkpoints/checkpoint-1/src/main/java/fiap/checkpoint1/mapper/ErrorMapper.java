package fiap.checkpoint1.mapper;

import fiap.checkpoint1.dto.error.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.WebRequest;

public class ErrorMapper {

    public static ErrorResponseDTO mapToErrorResponseDTO(int status, String title, String detail, WebRequest request){
        return new ErrorResponseDTO(status, title, detail, request.getDescription(false).substring(4));
    }

    public static ErrorResponseDTO mapToErrorResponseDTO(HttpStatus status, String title, String detail, WebRequest request){
        return new ErrorResponseDTO(status.value(), title, detail, request.getDescription(false).substring(4));
    }
}
