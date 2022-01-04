package com.marticus.dao;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.util.List;  
import org.springframework.jdbc.core.BeanPropertyRowMapper;  
import org.springframework.jdbc.core.JdbcTemplate;  
import org.springframework.jdbc.core.RowMapper;  
import com.marticus.employees.Emp;  
  
public class EmpDao {  
JdbcTemplate template;  
  
public void setTemplate(JdbcTemplate template) {  
    this.template = template;  
}  
public int save(Emp p){  
    String sql="insert into Emp99(empId,name,salary,age,aadhar,department) values('"+p.getEmpId()+"','"+p.getName()+"',"+p.getSalary()+",'"+p.getAge()+"','"+p.getAadhar()+"','"+p.getDepartment()+"')";  
    return template.update(sql);  
}  
public int update(Emp p){  
    String sql="update Emp99 set empId='"+p.getEmpId()+"', name='"+p.getName()+"', salary="+p.getSalary()+", age='"+p.getAge()+"', aadhar='"+p.getAadhar()+"', designation='"+p.getDepartment()+"' where id="+p.getId()+"";  
    return template.update(sql);  
}  
public int delete(int id){  
    String sql="delete from Emp99 where id="+id+"";  
    return template.update(sql);  
}  

@SuppressWarnings("deprecation")
public Emp getEmpById(int id){  
    String sql="select * from Emp99 where id=?";  
    return template.queryForObject(sql, new Object[]{id},new BeanPropertyRowMapper<Emp>(Emp.class));  
}  
public List<Emp> getEmployees(){  
    return template.query("select * from Emp99",new RowMapper<Emp>(){  
        public Emp mapRow(ResultSet rs, int row) throws SQLException {  
            Emp e=new Emp();  
            e.setId(rs.getInt(1));  
            e.setEmpId(rs.getInt(2));
            e.setName(rs.getString(3));  
            e.setSalary(rs.getFloat(4));  
            e.setAge(rs.getInt(5));
            e.setAadhar(rs.getInt(6));
            e.setDepartment(rs.getString(7));  
            return e;  
        }  
    });  
}  
}  