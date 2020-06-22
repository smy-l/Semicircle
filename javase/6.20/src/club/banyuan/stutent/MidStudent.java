package club.banyuan.stutent;

public class MidStudent extends Student {
    public MidStudent(String name) {
        super(name);
    }

    public MidStudent(String grade, String name) {
        super(name);
        setGrade(grade);
    }

    public String study() {
        return getGrade() + "的" + getName() + super.study();
    }
}
