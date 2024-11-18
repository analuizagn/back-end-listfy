package projeto.listify.exception;

import java.time.LocalDateTime;
import java.util.Map;

public class ExceptionDetails {
    private String title;
    private LocalDateTime timestamp;
    private int status;
    private String exception;
    private Map<String, String> details;

    public ExceptionDetails(String title, LocalDateTime timestamp, int status, String exception, Map<String, String> details) {
        this.title = title;
        this.timestamp = timestamp;
        this.status = status;
        this.exception = exception;
        this.details = details;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }

    public int getStatus() { return status; }
    public void setStatus(int status) { this.status = status; }

    public String getException() { return exception; }
    public void setException(String exception) { this.exception = exception; }

    public Map<String, String> getDetails() { return details; }
    public void setDetails(Map<String, String> details) { this.details = details; }
}
