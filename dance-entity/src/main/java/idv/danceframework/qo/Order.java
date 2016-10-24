package idv.danceframework.qo;

public class Order {
	public enum Direction {
		ASC, DESC;
	}

	private Direction direction = Direction.ASC;

	private String column;

	public Order() {
	}

	public Order(Direction direction, String column) {
		super();
		this.direction = direction;
		this.column = column;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public void setDir(String direction) {
		if (direction.equalsIgnoreCase(Direction.DESC.name())) {
			this.direction = Direction.DESC;
		}
	}
}
