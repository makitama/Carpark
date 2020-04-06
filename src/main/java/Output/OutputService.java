package Output;

public abstract class OutputService {

	public String getActualMethodName() {
		int methodenebene = 2;
		StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[methodenebene];
		return stackTraceElement.getMethodName();

	}

	public String getActualClassName() {
		int methodenebene = 2;
		StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[methodenebene];
		//todo testen
		String[] className = stackTraceElement.getClassName().split("\\.");
		return className[className.length - 1];
	}

}
