package cn.tuyucheng.taketoday.reducingIfElse;

public interface Rule {

   boolean evaluate(Expression expression);

   Result getResult();
}