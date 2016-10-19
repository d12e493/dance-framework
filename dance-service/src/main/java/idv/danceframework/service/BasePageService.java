package idv.danceframework.service;

import idv.danceframework.lo.PageResult;
import idv.danceframework.qo.PageRequest;

public interface BasePageService<QueryObject, ListObject> {

	PageResult<ListObject> findAll(QueryObject queryObject, PageRequest pageRequest);
}
