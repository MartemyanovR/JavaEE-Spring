package enumeration;

  enum EnumEmployee {
		A("One"){
			public String abcd() {
				return "This A";
			}
		}
		,B("Two"){
			public String abcd() {
				return "This B";
			}
		},
			C("Three"){
				public String abcd() {
					return "This C";
				}
		}
			,D("Four"){
				public String abcd() {
					return "This D";
				}
				};
			
	  private String s;
	  
	  private EnumEmployee(String s) {
		  this.s=s;
	  }
	  
	  String getEmployee() {
		  return s;
	  }
	  
	  public String getString() {
		  return getClass().getName() + " name = " + s; 
	  }
	  public abstract String abcd();
}
