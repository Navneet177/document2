package project.logic;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class UserDetails {


        public static String FullName(User user) {
            String fullName = user.getfName() + " " + user.getlName();

            return fullName;
        }

        public static Boolean VerifyCountry(User user) {
            String country = user.getAddress().getCountry();
            if (country == "CA") {
                return true;
            } else {
                return false;
            }
        }

        // TODO : RQ - 2
        public static Double SalaryAccumulated(User user) {
            int remainingAge = 0;

            String dob =user.getDOB();
            DateTimeFormatter Formatter1 = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            LocalDate late = LocalDate.parse( dob ,Formatter1);

            int month = late.getMonthValue();
            int dayOfMonth = late.getDayOfMonth();
            int year = late.getYear();
            LocalDate db = LocalDate.of(year,month,dayOfMonth);
            LocalDate now = LocalDate.now();
            Period gap = Period.between(db,now);
            int age = gap.getYears();
            String province = user.getAddress().getProvince();

            if(province=="Quebec"){
                remainingAge = 55 - age;

            }
            else if(province=="Ontario") {
                remainingAge = 58 - age;
            }

            double salaryHike = 0, totalSalary = 0;
            salaryHike = user.getSalary();
            for (int i = 1; i <= remainingAge; i++) {
                salaryHike = salaryHike + salaryHike * 0.02;
                totalSalary += salaryHike;
            }
            return totalSalary;
        }
    }