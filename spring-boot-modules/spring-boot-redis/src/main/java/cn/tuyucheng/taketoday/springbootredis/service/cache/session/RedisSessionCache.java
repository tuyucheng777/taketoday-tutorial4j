package cn.tuyucheng.taketoday.springbootredis.service.cache.session;

import cn.tuyucheng.taketoday.springbootredis.exception.session.SessionNotFoundException;
import cn.tuyucheng.taketoday.springbootredis.model.Session;
import cn.tuyucheng.taketoday.springbootredis.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

@Service
public class RedisSessionCache implements SessionCache {
   @Autowired
   private SessionRepository sessionRepository;

   @Override
   public Session createASession(Session session) {
      return sessionRepository.save(session);
   }

   @Override
   public Session getSession(String id) {
      return sessionRepository.findById(id)
            .orElseThrow(() -> new SessionNotFoundException(id));
   }

   @Override
   public List<Session> getAllSessions() {
      return Stream.iterate(sessionRepository.findAll().iterator(), Iterator::hasNext, UnaryOperator.identity())
            .map(Iterator::next)
            .toList();
   }
}