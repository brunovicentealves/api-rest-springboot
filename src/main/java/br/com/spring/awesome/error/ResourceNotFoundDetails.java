package br.com.spring.awesome.error;

public class ResourceNotFoundDetails {

    private String title;
    private int status;
    private String detail;
    private Long timestamp;
    private String developerMessage;

    public ResourceNotFoundDetails(String title, int status, String detail, Long timestamp, String developerMessage) {
        this.title = title;
        this.status = status;
        this.detail = detail;
        this.timestamp = timestamp;
        this.developerMessage = developerMessage;
    }

    public String getTitle() {
        return title;
    }

    public int getStatus() {
        return status;
    }

    public String getDetail() {
        return detail;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public static final class ResourceNotFoundDetailsBuilder {
        private String title;
        private int status;
        private String detail;
        private Long timestamp;
        private String developerMessage;

        private ResourceNotFoundDetailsBuilder() {
        }

        public static ResourceNotFoundDetailsBuilder newBuilder() {
            return new ResourceNotFoundDetailsBuilder();
        }

        public ResourceNotFoundDetailsBuilder title(String title) {
            this.title = title;
            return this;
        }

        public ResourceNotFoundDetailsBuilder status(int status) {
            this.status = status;
            return this;
        }

        public ResourceNotFoundDetailsBuilder detail(String detail) {
            this.detail = detail;
            return this;
        }

        public ResourceNotFoundDetailsBuilder timestamp(Long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public ResourceNotFoundDetailsBuilder developerMessage(String developerMessage) {
            this.developerMessage = developerMessage;
            return this;
        }

        public ResourceNotFoundDetails build() {
            return new ResourceNotFoundDetails(title, status, detail, timestamp, developerMessage);
        }
    }
}
