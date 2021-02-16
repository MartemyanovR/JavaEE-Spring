package patterns;

public class FacadeComp {		//класс фасад
		private FacadeCPU cpu;
		private FacadeMemory mem;
		
		public FacadeComp() {
			this.cpu = new FacadeCPU();
			this.mem = new FacadeMemory();
		}
		
		public void startComputer() {
			cpu.freezer();
			mem.loader("load");
		}
}
