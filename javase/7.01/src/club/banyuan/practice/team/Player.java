package club.banyuan.practice.team;

import java.util.Objects;

public class Player {

    private String name;
    private int number;
    private String position;
    private int positionIndex;

    public Player(String name, int number, String position) {
        this.name = name;
        this.number = number;
        this.position = position;
        switch (position) {
            case "SG":
                positionIndex = 2;
                break;
            case "PG":
                positionIndex = 1;
                break;
            case "SF":
                positionIndex = 3;
                break;
            case "PF":
                positionIndex = 4;
                break;
            case "C":
                positionIndex = 5;
                break;
            default:
                throw new RuntimeException("不支持的位置！");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getPositionIndex() {
        return positionIndex;
    }

    public void setPositionIndex(int positionIndex) {
        this.positionIndex = positionIndex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        Player player = (Player) o;
        return number == player.number &&
                Objects.equals(name, player.name) &&
                Objects.equals(position, player.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, number, position);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", position='" + position + '\'' +
                '}';
    }
}
