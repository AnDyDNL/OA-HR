package com.itcast.hr.basedao;
import java.util.List;
public interface IBaseDao<T> {
	/**
	 * 保存
	 * @param t
	 */
	void save(T t);
	/**
	 * 删除
	 * @param t
	 */
	void delete(Long id);
	/**
	 * 删除
	 * @param id
	 */
	void update(T t);
	/**
	 * id查询
	 * @param id
	 * @return
	 */
	T getById(Long id);
	/**
	 * 查询所有
	 */
	List<T> getAll();
	/**
	 * id查询多个
	 * @param ids
	 * @return
	 */
	List<T> getByIds(Long[] ids);
}
