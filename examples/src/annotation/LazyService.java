package annotation;

@Service(name = "LazyServiceAnnotation")
public class LazyService {
	
	@Init
	public void lazyInit() throws Exception {
		System.out.println("Lazy Method");
	}
	
	public String methStr() {
		return "Hello";
	}

}
