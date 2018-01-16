package com.itcast.hr.service.imp;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.itcast.hr.basedao.imp.DaoSupportImp;
import com.itcast.hr.entity.Role;
import com.itcast.hr.service.IRoleService;
@Service("roleService")
@Transactional // 开启事务
public class RoleserviceImp extends DaoSupportImp<Role> implements IRoleService {


}
