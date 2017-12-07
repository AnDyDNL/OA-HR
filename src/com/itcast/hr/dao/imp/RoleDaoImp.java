package com.itcast.hr.dao.imp;
import org.springframework.stereotype.Component;

import com.itcast.hr.basedao.imp.BaseDaoImp;
import com.itcast.hr.dao.IRoleDao;
import com.itcast.hr.entity.Role;
@Component("roleDao")
public class RoleDaoImp extends BaseDaoImp<Role> implements IRoleDao{

}
