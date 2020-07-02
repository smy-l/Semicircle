package ptratice6_19.club.banyuan.stutent;

public class HighStudent extends Student {

    public HighStudent(String name) {
        super(name);
    }

    public HighStudent(String grade, String name) {
        super(name);
        setGrade(grade);
    }

    public String study() {
        return getGrade() + "的" + getName() + super.study();
    }

}
