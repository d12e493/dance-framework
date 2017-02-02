package idv.danceframework.sql;

import java.util.ArrayList;
import java.util.List;

public class Specification {
	private List<Condition> conditionList = new ArrayList<Condition>();

	/**
	 * 
	 * @author Davis
	 *
	 * @param sql
	 *            can be null
	 * @return
	 */

	public static Specification where(Condition condition) {

		Specification spec = new Specification();
		spec.addCondition(Operator.WHERE,condition);
		return spec;
	}

	public Specification and(Condition condition) {
		addCondition(Operator.AND, condition);
		return this;
	}

	public Specification or(Condition condition) {
		addCondition(Operator.OR, condition);
		return this;
	}

	private void addCondition(Operator operator, Condition condition) {
		if (condition != null) {
			condition.setOperator(operator);
			this.conditionList.add(condition);
		}
	}

	public List<Condition> getConditionList() {
		return conditionList;
	}

	public void setConditionList(List<Condition> conditionList) {
		this.conditionList = conditionList;
	}
}
