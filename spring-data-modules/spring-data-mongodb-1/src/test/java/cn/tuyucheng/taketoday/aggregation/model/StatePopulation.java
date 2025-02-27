package cn.tuyucheng.taketoday.aggregation.model;

import org.springframework.data.annotation.Id;

public class StatePopulation {

   @Id
   private String state;
   private Integer statePop;

   public String getState() {
      return state;
   }

   public void setState(String state) {
      this.state = state;
   }

   public Integer getStatePop() {
      return statePop;
   }

   public void setStatePop(Integer statePop) {
      this.statePop = statePop;
   }

   @Override
   public String toString() {
      return "StatePopulation [state=" +
            state +
            ", statePop=" +
            statePop +
            "]";
   }
}