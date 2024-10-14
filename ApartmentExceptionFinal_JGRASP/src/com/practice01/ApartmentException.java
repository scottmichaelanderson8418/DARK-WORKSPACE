


//A class that represents user-defined exception
public class ApartmentException extends Exception {

	public ApartmentException() {

		super("MyException was caught!! ");
	}

	public ApartmentException(String s) {

		// call constructor of parent Exception
		super(s);

	}

}
