package idv.danceframework.sql;

public class Condition {
	private Operator operator;
	private String sql;

	public Condition() {

	}

	public Condition(String sql) {
		this.sql = sql;
	}

	public Condition(Operator operator, String sql) {
		this.operator = operator;
		this.sql = sql;
	}

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}
}
