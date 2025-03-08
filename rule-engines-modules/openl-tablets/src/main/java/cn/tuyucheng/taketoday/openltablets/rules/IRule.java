package cn.tuyucheng.taketoday.openltablets.rules;

import cn.tuyucheng.taketoday.openltablets.model.Case;

public interface IRule {
   void helloUser(final Case aCase, final Response response);
}