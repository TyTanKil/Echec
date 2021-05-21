
public class Position {

	public int x;
	public int y;

	public Position(int x, int y){
		this.x = x;
		this.y = y;
	}

	public Position(){
		this(0,0);
	}

	public Position(int xy){
		this(xy, xy);
	}

	public void set(int x, int y){
		this.x = x;
		this.y = y;
	}

	public String toString(){
		return "["+x+", "+y+"]";
	}
}