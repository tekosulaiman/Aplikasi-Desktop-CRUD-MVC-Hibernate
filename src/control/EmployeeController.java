package control;

import desktopui.FormEmployee;
import model.Employee;
import service.EmployeeService;
import service.impl.EmployeeServiceImpl;

/**
 * @author tombisnis@yahoo.com
 */
public class EmployeeController {
    private final FormEmployee formEmployee;
    private final EmployeeService employeeService;
    
    public EmployeeController(FormEmployee formEmployee) {
        this.formEmployee = formEmployee;
        employeeService = new EmployeeServiceImpl();
    }
    
    public void readEmployee(){
         formEmployee.getTableModelEmployee().setList(employeeService.getAllEmployees());
    }
    
    public void saveEmployee(Employee employee){
	employee.setId(formEmployee.getjTextField7().getText());
	employee.setName(formEmployee.getjTextField8().getText());
        employee.setAddress(formEmployee.getjTextField9().getText());
                
        employeeService.save(employee);
    }
    
    public void updateEmployee(Employee employee){
	employee.setId(formEmployee.getjTextField7().getText());
	employee.setName(formEmployee.getjTextField8().getText());
        employee.setAddress(formEmployee.getjTextField9().getText());
                
        employeeService.saveOrUpdate(employee);
    }
    
    public void deleteEmployee(Employee employee){
	employeeService.delete(employee);
    }
    
    public void resetEmployee(){
	formEmployee.getjTextField7().setText("");
	formEmployee.getjTextField8().setText("");
        formEmployee.getjTextField9().setText("");
    }
}