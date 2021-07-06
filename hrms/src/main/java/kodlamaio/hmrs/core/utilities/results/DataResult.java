package kodlamaio.hmrs.core.utilities.results;

public class DataResult<T> extends Result {

		private T data;
	//Constructors
	public DataResult(T data,boolean success) {
		super(success);
		this.data = data;	
	}
	public DataResult(T data, boolean success, String message) {
		super(success,message);
		this.data = data;
	}
	//Methods
	public T getData() {
		return this.data;
	}

}
