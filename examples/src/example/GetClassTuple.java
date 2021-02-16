package example;

import example.GetClassTest;;

public class GetClassTuple<T> extends GetClassTest {
	private T mObj = null;
	public GetClassTuple(T obj){
		mObj = obj;
	}
	public void control(){
		//код запускается только с применением приведения типа
		 ((GetClassInterface) mObj).someMeth();// <---- compilation error!
	} 
}
