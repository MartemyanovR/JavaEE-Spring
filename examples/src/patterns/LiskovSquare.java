package patterns;

public class LiskovSquare  implements LiskovShape {
	int width;
	public void setWidth(int width) {
		this.width = width;
		}
	public int getWidth() {
		return width;
	}
	public int getSquare() {
		return width*width;
	}
	 
}
