package club.banyuan.practice.dataSet;

import club.banyuan.practice.dataSet.Measurable;

public class Country implements Measurable {

  private int population;

  public Country(int population) {
    this.population = population;
  }

  public int getPopulation() {
    return population;
  }

  public void setPopulation(int population) {
    this.population = population;
  }

  @Override
  public double getMeasure() {
    return population;
  }
}
