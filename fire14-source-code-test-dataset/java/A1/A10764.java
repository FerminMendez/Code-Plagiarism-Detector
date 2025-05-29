public class MalformedInputFileException extends Throwable {

	private static final long serialVersionUID = -6714074599343669185L;

	public MalformedInputFileException() {
		super();
	}

	public MalformedInputFileException(String message) {
		super(message);
	}

	public MalformedInputFileException(String message, Throwable cause) {
		super(message, cause);
	}

	public MalformedInputFileException(Throwable cause) {
		super(cause);
	}
}
