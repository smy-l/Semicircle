package club.banyuan.stutent;

public class EleStudent extends Student {

    public EleStudent(String name) {
        super(name);
    }

    public EleStudent(String grade, String name) {
        super(name);
        setGrade(grade);
    }

    public String study() {
        return getGrade() + "的" + getName() + super.study();
    }

}
