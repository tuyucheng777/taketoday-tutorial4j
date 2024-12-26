package cn.tuyucheng.taketoday.service;

import cn.tuyucheng.taketoday.action.ActionEnum;
import cn.tuyucheng.taketoday.user.CmsUser;

public interface AuthorizationService {
   boolean authorize(CmsUser user, ActionEnum actionEnum);
}