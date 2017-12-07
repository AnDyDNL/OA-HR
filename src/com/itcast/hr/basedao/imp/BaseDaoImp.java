package com.itcast.hr.basedao.imp;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.annotation.Resource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.itcast.hr.basedao.IBaseDao;
@SuppressWarnings("unchecked")
public class BaseDaoImp<T> implements IBaseDao<T>{
	@Resource
	private SessionFactory sessionFactory;
	private Class<T> clazz;
	/**
	 * 用（调用者的类）实现类的类型获取当前的类类型
	 */
	public BaseDaoImp(){
		//this.getClass() 子类的类型    反射技术得到T的真实类型
		ParameterizedType pt = (ParameterizedType)this.getClass()
				.getGenericSuperclass();//获取当前new的对象的泛型父类类型
		this.clazz=(Class<T>) pt.getActualTypeArguments()[0];//获取第一个类型参数的真实类型
	}
	/**
	 * 让子类也能获取当前session
	 * @return
	 */
	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	@Override
	public void save(T entity) {
		getSession().save(entity);
	}

	@Override
	public void delete(Long id) {
		System.out.println("BaseDaoImp.delete()");
		Object obj=getById(id);
		System.out.println(obj.toString());
		if(obj!=null){
			//删除一个对象
			getSession().delete(obj);
		}
		
	}
	@Override
	public void update(T t) {
		getSession().update(t);
	}

	@Override
	public T getById(Long id) {
		if(id==null){
			return null;
		}
		return (T) getSession().get(clazz, id);
	}
	@Override
	public List<T> getAll() {
		return  getSession().createQuery("FROM "
				+clazz.getSimpleName())
				.list();
	}
	@Override
	public List<T> getByIds(Long[] ids) {
		//id是个数组设置parameterList参数
		return getSession().createQuery("FORM User where id IN(:ids)"
				).setParameterList("ids", ids)
				.list();
	}
}
