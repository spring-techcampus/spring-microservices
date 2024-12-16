package com.alderaan.account.common.exception.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Schema(
        name = "ErrorResponseDto",
        description = "Data Transfer Object for Error Response details"
)
public class ErrorResponseDto {

    @Schema(
            description = "API path invoked by client"
    )
    private  String path;

    @Schema(
            description = "Error code representing the error happened"
    )
    private HttpStatus code;

    @Schema(
            description = "Error message representing the error happened"
    )
    private  String message;

    @Schema(
            description = "Time representing when the error happened"
    )
    private LocalDateTime time;

    public ErrorResponseDto(String path, HttpStatus code, String message, LocalDateTime time) {
        this.path = path;
        this.code = code;
        this.message = message;
        this.time = time;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public HttpStatus getCode() {
        return code;
    }

    public void setCode(HttpStatus code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
