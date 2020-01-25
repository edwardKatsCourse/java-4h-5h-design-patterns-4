package com.company.visitor;


import java.util.Arrays;
import java.util.List;

class Main {
    public static void main(String[] args) {
        RegularEmployee regularEmployee = new RegularEmployee(10000.);
        ManagerEmployee managerEmployee = new ManagerEmployee(10000., 2.5);
        HourlyEmployee hourlyEmployee = new HourlyEmployee(10.);

        List<Employee> employees = Arrays.asList(regularEmployee, managerEmployee, hourlyEmployee);

        MonthReport monthReport = new MonthReport();

        for (Employee employee : employees) {
            //Дорогой, employee!
            //Вот тебе ссылка на отчет - передай туда всю инфу о своей З/П
            employee.accept(monthReport);
        }

        System.out.println("Salary budget per month: " + monthReport.getTotalSalary());

    }
}
//SOLID
//Open Close Principle

//interface getTotalMonthlySalary()
//          getTotalDailySalary()
//          getQuarterlySalary()

interface Employee {
    void accept(EmployeeReport employeeReport); //Visitor
}
interface EmployeeReport { //EmployeeVisitor
    void visit(HourlyEmployee hourlyEmployee);
    void visit(ManagerEmployee managerEmployee);
    void visit(RegularEmployee regularEmployee);
}



class MonthReport implements EmployeeReport {

    private Double totalSalary = 0.;
    private static final Integer DAYS_IN_MONTH = 22;
    //private daysInMonth

    public Double getTotalSalary() {
        return totalSalary;
    }

    @Override
    public void visit(HourlyEmployee hourlyEmployee) {
        //hour rate * 8 * 22
        totalSalary += hourlyEmployee.getHourRate() * 8 * DAYS_IN_MONTH;
    }

    @Override
    public void visit(ManagerEmployee managerEmployee) {
        /*                                  10,000                                  250                 */
        totalSalary += managerEmployee.getMonthSalary() + (managerEmployee.getMonthSalary() / 100 * managerEmployee.getBonusByTeamCount());
//        System.out.println(managerEmployee.getMonthSalary() + (managerEmployee.getMonthSalary() / 100 * managerEmployee.getBonusByTeamCount()));
    }

    @Override
    public void visit(RegularEmployee regularEmployee) {
        totalSalary += regularEmployee.getMonthlySalary();
    }
}

public class HourlyEmployee implements Employee {

    //10$
    private Double hourRate;

    public HourlyEmployee(Double hourRate) {
        this.hourRate = hourRate;
    }

    public Double getHourRate() {
        return hourRate;
    }

    //Когда к тебе, this, обратятся с отчетом - передай им всю инфу ("всего себя")
    @Override
    public void accept(EmployeeReport employeeReport) {

        //передача в отчет инфы о своей зарплате
        employeeReport.visit(this);
    }
}

class RegularEmployee implements Employee {
    private Double monthlySalary;

    public RegularEmployee(Double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public Double getMonthlySalary() {
        return monthlySalary;
    }

    @Override
    public void accept(EmployeeReport employeeReport) {
        employeeReport.visit(this);
    }
}

class ManagerEmployee implements Employee {
    //10 000$
    private Double monthSalary;

    //0.5% per employee * 5 = 2.5%
    private Double bonusByTeamCount;

    public ManagerEmployee(Double monthSalary, Double bonusByTeamCount) {
        this.monthSalary = monthSalary;
        this.bonusByTeamCount = bonusByTeamCount;
    }

    public Double getMonthSalary() {
        return monthSalary;
    }

    public Double getBonusByTeamCount() {
        return bonusByTeamCount;
    }

    @Override
    public void accept(EmployeeReport employeeReport) {
        employeeReport.visit(this);
    }
}