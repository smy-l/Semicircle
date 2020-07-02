package practice6_29.club.banyuan.fg.refine;

public enum PlayerType {
    HUMAN("玩家"),
    COMPUTER1("电脑1"),
    COMPUTER2("电脑2"),
    COMPUTER3("电脑3"),
    COMPUTER4("电脑4"),
    ;

    private String type;
    private FingerPattern pattern;
    private boolean isOut = true;
//    private String name;

    PlayerType(String type) {
        this.type = type;
    }

    public FingerPattern getPattern() {
        return pattern;
    }

    public void setPattern(FingerPattern pattern) {
        this.pattern = pattern;
    }

    public boolean isOut() {
        return isOut;
    }

    public void setOut(boolean out) {
        isOut = out;
    }

    public String getName() {
        return type;
    }



}
