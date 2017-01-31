package idv.danceframework.qo;

public class Order {
	public enum Direction {
		ASC, DESC;
	}

	private String column;
	private Direction dir = Direction.ASC;

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public Direction getDir() {
		return dir;
	}

	public void setDir(Direction dir) {
		this.dir = dir;
	}
}
