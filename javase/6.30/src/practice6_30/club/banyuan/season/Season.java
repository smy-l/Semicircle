package practice6_30.club.banyuan.season;

public enum Season {
    SPRING,
    SUMMER,
    AUTUMN,
    WINTER,

    ;

    public void getMonthRange() {
        switch (this) {
            case SPRING:
                System.out.println("春季月份为3~5");
                break;
            case SUMMER:
                System.out.println("夏季月份为6~8");
                break;
            case AUTUMN:
                System.out.println("秋季月份为9~11");
                break;
            case WINTER:
                System.out.println("冬季月份为12~2");
                break;
        }
    }

}
