package exception;

import java.io.EOFException;
import java.io.IOException;
import java.sql.SQLException;

public class SubClassException extends SuperClassExc implements InterfaceExcaption {

	public SubClassException(String name) throws IOException, EOFException {
		super(name);		
	}

	@Override
	public String getName()  throws EOFException {
		return "";
	}
	
	public String getName1()  throws  SQLException {
		return "";
	}
	
	public String getNameSub(int i) throws IOException  {
		if(i < 0) throw new EOFException();
		return "_";
	}
	//можно обьявлять но не перехватывать
	public String getNameSub2(int i) throws IOException  {		
		return "_";
	}

}
