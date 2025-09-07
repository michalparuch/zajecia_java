package basics.o11.oop.orlen;

import java.util.ArrayList;
import java.util.List;

public class Shift {
    private static List<Shift> extension = new ArrayList<>();

    private Integer shiftType;
    private Instalation instalation;
    private Employee supervisor;
    private List<Employee> employees = new ArrayList<>();

    public Shift(Integer shiftType, Instalation instalation, Employee supervisor) {
        this.shiftType = shiftType;
        this.instalation = instalation;
        this.supervisor = supervisor;
        extension.add(this);
    }

    public void addEmployee(Employee employee) {
        if (employees.size() < 4) {
            employees.add(employee);
        } else {
            throw new IllegalArgumentException("You have already entered 4 employees in this shift");
        }
    }

    public void setInstallation(Instalation instalation) {
        this.instalation = instalation;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public Instalation getInstalation() {
        return instalation;
    }

    public Double getShiftEfficiency(){
        Double efficiency = 0.00;
        for (Employee employee : employees){
            efficiency +=employee.getEfficiency();
        }
        return efficiency;
    }

    public static Shift getBestShiftFromInstallation(Instalation instalation){
        Shift bestShiftFromInstallation = null;

        for (Shift shift : extension){
            if(shift.getInstalation().equals(instalation)){
                if(bestShiftFromInstallation== null){
                    bestShiftFromInstallation = shift;
                } else if (bestShiftFromInstallation.getShiftEfficiency() < shift.getShiftEfficiency()) {
                    bestShiftFromInstallation = shift;
                }
            }
        }
        return bestShiftFromInstallation;
    }

    public static Shift getBestShift(){
        Shift bestShift = extension.getFirst();

        for(Shift shift : extension){
            if(shift.getShiftEfficiency()>bestShift.getShiftEfficiency()){
                bestShift = shift;
            }
        }
        return bestShift;
    }

    @Override
    public String toString() {
        return "Shift{" +
                "supervisor=" + supervisor +
                ", instalation=" + instalation +
                ", shiftType=" + shiftType +
                '}';
    }
}
