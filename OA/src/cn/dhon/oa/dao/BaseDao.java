package cn.dhon.oa.dao;

import java.util.List;

public interface BaseDao<T> {
	/**
	 * 保存实体
	 * @param entity
	 */
	void save(T entity);
	/**
	 * 根据id删除实体
	 * @param id
	 */
	void delete(Long id);
	/**
	 * 更新实体
	 * @param entity
	 */
	void update(T entity);
	/**
	 * 根据id查找
	 * @param id
	 * @return 返回实体
	 */
	T getById(Long id);
	/**
	 * 根据id数组查找多个实体
	 * @param id
	 * @return 返回实体集合
	 */
	List<T> getByIds(Long[] id);
	/**
	 * 查找所有实体
	 * @return 返回所有实体
	 */
	List<T> getAll();
}
