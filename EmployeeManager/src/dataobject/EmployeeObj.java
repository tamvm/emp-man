/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dataobject;

import java.util.Date;

/**
 *
 * @author TRONG
 */
public class EmployeeObj {

    public String fname;
    public String lname;
    public String pos;
    public Date bday;
    public Date hireday;
    public boolean sex;
    public int salary;
    public int bonus;

    /**
     * @return the fname
     */
    public String getFname() {
        return fname;
    }

    /**
     * @param fname the fname to set
     */
    public void setFname(String fname) {
        this.fname = fname;
    }

    /**
     * @return the lname
     */
    public String getLname() {
        return lname;
    }

    /**
     * @param lname the lname to set
     */
    public void setLname(String lname) {
        this.lname = lname;
    }

    /**
     * @return the pos
     */
    public String getPos() {
        return pos;
    }

    /**
     * @param pos the pos to set
     */
    public void setPos(String pos) {
        this.pos = pos;
    }

    /**
     * @return the bday
     */
    public Date getBday() {
        return bday;
    }

    /**
     * @param bday the bday to set
     */
    public void setBday(Date bday) {
        this.bday = bday;
    }

    /**
     * @return the hireday
     */
    public Date getHireday() {
        return hireday;
    }

    /**
     * @param hireday the hireday to set
     */
    public void setHireday(Date hireday) {
        this.hireday = hireday;
    }

    /**
     * @return the sex
     */
    public boolean isSex() {
        return sex;
    }

    /**
     * @param sex the sex to set
     */
    public void setSex(boolean sex) {
        this.sex = sex;
    }

    /**
     * @return the salary
     */
    public int getSalary() {
        return salary;
    }

    /**
     * @param salary the salary to set
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }

    /**
     * @return the bonus
     */
    public int getBonus() {
        return bonus;
    }

    /**
     * @param bonus the bonus to set
     */
    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
}
