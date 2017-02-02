package idv.danceframework.sql;

import idv.danceframework.lo.PageResult;
import idv.danceframework.qo.PageRequest;

public class PageQueryWrapper<T> {

	private StringBuffer customNativeSQL = new StringBuffer();

	private StringBuffer conditionSQL = new StringBuffer();

	private StringBuffer completeSQL = new StringBuffer();

	private SpecificationFactory<T> factory;

	private Specification specs;

	private Class<T> queryClass;

	private PageRequest<T> request;

	private PageResult result;

	public PageQueryWrapper(Class<T> clazz) {

		this.queryClass = clazz;
		
		this.factory = new SpecificationFactory<T>(clazz);
		
		process();
	}

	private void process() {
		
		CustomNativeQuery customNativeQuery = queryClass.getAnnotation(CustomNativeQuery.class);
		
		if(customNativeQuery == null){
			throw new NullPointerException(queryClass.getName()+" need declare @CustomNativeQuery !!! ");
		}
		
		this.customNativeSQL.append(customNativeQuery.query());

		if (specs != null && specs.getConditionList() != null && specs.getConditionList().size() > 0) {
			for (Condition condition : specs.getConditionList()) {

				if (condition.getOperator() != Operator.WHERE) {
					this.conditionSQL.append(" " + condition.getOperator() + " ");
				}
				this.conditionSQL.append(condition.getSql() + " ");
			}
		}

		this.completeSQL.append(this.customNativeSQL);

		if (conditionSQL.length() > 0) {
			this.completeSQL.append(" WHERE " + this.getConditionSQL() + " ");
		}
	}

	public SpecificationFactory<T> getFactory() {
		return factory;
	}

	public void setFactory(SpecificationFactory<T> factory) {
		this.factory = factory;
	}

	public Class<T> getQueryClass() {
		return queryClass;
	}

	public void setQueryClass(Class<T> queryClass) {
		this.queryClass = queryClass;
	}

	public PageRequest<T> getRequest() {
		return request;
	}

	public void setRequest(PageRequest<T> request) {
		this.request = request;
	}

	public PageResult getResult() {
		return result;
	}

	public void setResult(PageResult result) {
		this.result = result;
	}

	public StringBuffer getCustomNativeSQL() {
		return customNativeSQL;
	}

	public void setCustomNativeSQL(StringBuffer customNativeSQL) {
		this.customNativeSQL = customNativeSQL;
	}

	public Specification getSpecs() {
		return specs;
	}

	public void setSpecs(Specification specs) {
		this.specs = specs;
	}

	public StringBuffer getConditionSQL() {
		return conditionSQL;
	}

	public void setConditionSQL(StringBuffer conditionSQL) {
		this.conditionSQL = conditionSQL;
	}

	public StringBuffer getCompleteSQL() {
		return completeSQL;
	}

	public void setCompleteSQL(StringBuffer completeSQL) {
		this.completeSQL = completeSQL;
	}

}
