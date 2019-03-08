package convert.currency.controller;


public class Response {
	private int status;
	private String error;
	private String message;
	private Double factorValue;
	private Double ConvertedValue;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Double getFactorValue() {
		return factorValue;
	}

	public void setFactorValue(Double factorValue) {
		this.factorValue = factorValue;
	}

	public Double getConvertedValue() {
		return ConvertedValue;
	}

	public void setConvertedValue(Double convertedValue) {
		ConvertedValue = convertedValue;
	}

	@Override
	public String toString() {
		return "Response [status=" + status + ", error=" + error + ", message=" + message + ", factorValue="
				+ factorValue + ", ConvertedValue=" + ConvertedValue + "]";
	}

}