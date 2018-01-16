package com.itcast.hr.dao.imp;
import org.springframework.stereotype.Component;

import com.itcast.hr.basedao.imp.DaoSupportImp;
import com.itcast.hr.dao.IRoleDao;
import com.itcast.hr.entity.Role;
@Component("roleDao")
@Deprecated
public class RoleDaoImp extends DaoSupportImp<Role> implements IRoleDao{

}
