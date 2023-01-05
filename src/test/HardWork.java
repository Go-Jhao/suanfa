package test;

/**
 * @BelongsProject: suanfa
 * @BelongsPackage: test6
 * @Author: GuoJHao
 * @CreateTime: 2022-11-01  15:27
 * @Description: TODO
 * @Version: 1.0
 */

import  java.util.Scanner;
abstract  class  Employee  {
    abstract public int earnings();
}
class  YearWorker  extends  Employee  {
    private int salary;

    public YearWorker() {
    }

    public YearWorker(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public int earnings() {
        return salary;
    }
}
class  MonthWorker  extends  Employee  {
    private int salary;

    public MonthWorker() {
    }

    public MonthWorker(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public int earnings() {
        return 12*salary;
    }
}
class  WeekWorker  extends  Employee  {
    private int salary;

    public WeekWorker() {
    }

    public WeekWorker(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public int earnings() {
        return 52*salary;
    }
}
class  Company  {
    Employee[  ]  employee;
    double  salaries=0;
    Company(Employee[  ]  employee)  {
        this.employee=employee;
    }
    public  double  salariesPay(  )  {
        for(Employee one : employee){
            salaries += one.earnings();
        }
        return salaries;
    }
}
public  class  HardWork  {
    public  static  void  main(String  args[  ])  {
        Scanner in = new Scanner(System.in);
        int year = in.nextInt();
        int Mouth = in.nextInt();
        int week = in.nextInt();
        int sum = in.nextInt();
        Employee[] employee = new Employee[sum];

        int num1 = in.nextInt();
        for (int j = 0; j < num1; j++) {
            employee[sum-1] = new WeekWorker(week);
            sum -= 1;
        }

        int num2 = in.nextInt();
        for (int j = 0; j < num1; j++) {
            employee[sum-1] = new MonthWorker(Mouth);
            sum -= 1;
        }

        int num3 = in.nextInt();
        for (int j = 0; j < num1; j++) {
            employee[sum-1] = new YearWorker(year);
            sum -= 1;
        }

        Company  company=new  Company(employee);

        System.out.println(String.format("%.0f", company.salariesPay()));
    }
}
