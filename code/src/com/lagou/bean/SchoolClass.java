package com.lagou.bean;

/**
 * @author baiaohou
 * @create 2020-09-20 11:41 PM
 */
public class SchoolClass {
    private String cname;
    private String grade;
    private String teacher;
    private String slogan;
    private String people_count;

    public SchoolClass() {
    }

    public SchoolClass(String cname, String grade, String teacher, String slogan) {
        this.cname = cname;
        this.grade = grade;
        this.teacher = teacher;
        this.slogan = slogan;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getPeople_count() {
        return people_count;
    }

    public void setPeople_count(String people_count) {
        this.people_count = people_count;
    }

    @Override
    public String toString() {
        return "Class{" +
                "cname='" + cname + '\'' +
                ", grade='" + grade + '\'' +
                ", teacher='" + teacher + '\'' +
                ", slogan='" + slogan + '\'' +
                ", people_count='" + people_count + '\'' +
                '}';
    }

    public String toStringRow() {
        return "<tr>" +
                "<td>" + cname + "</td>" +
                "<td>" + grade + "</td>" +
                "<td>" + teacher + "</td>" +
                "<td>" + slogan + "</td>" +
                "<td>" + people_count + "</td>" +
                "</tr>";
    }

    public String toStringRowBold() {
        return "<tr>" +
                "<td><b><u>" + cname + "</td>" +
                "<td><b><u>" + grade + "</td>" +
                "<td><b><u>" + teacher + "</td>" +
                "<td><b><u>" + slogan + "</td>" +
                "<td><b><u>" + people_count + "</td>" +
                "</tr>";
    }
}
