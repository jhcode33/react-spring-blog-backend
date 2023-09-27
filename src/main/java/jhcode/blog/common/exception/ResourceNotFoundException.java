package jhcode.blog.common.exception;

public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    String resourceName;
    String fieldName;
    String fieldValue;

    /**
     * RuntimeException(message)
     * @param resourceName : 찾을 수 없는 자원명
     * @param fieldName : 필드명
     * @param fieldValue : 필드값
     */
    public ResourceNotFoundException(String resourceName, String fieldName, String fieldValue) {
        super(String.format("%s is not found [%s : %s]", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
