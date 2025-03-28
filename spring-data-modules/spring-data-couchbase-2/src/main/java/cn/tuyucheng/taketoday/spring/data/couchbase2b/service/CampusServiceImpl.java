package cn.tuyucheng.taketoday.spring.data.couchbase2b.service;

import cn.tuyucheng.taketoday.spring.data.couchbase.model.Campus;
import cn.tuyucheng.taketoday.spring.data.couchbase2b.repos.CampusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class CampusServiceImpl implements CampusService {

   private CampusRepository repo;

   @Autowired
   public void setCampusRepository(CampusRepository repo) {
      this.repo = repo;
   }

   @Override
   public Optional<Campus> find(String id) {
      return repo.findById(id);
   }

   @Override
   public Set<Campus> findByName(String name) {
      return repo.findByName(name);
   }

   @Override
   public Set<Campus> findByLocationNear(Point point, Distance distance) {
      return repo.findByLocationNear(point, distance);
   }

   @Override
   public Set<Campus> findAll() {
      Set<Campus> campuses = new HashSet<>();
      for (Campus campus : repo.findAll()) {
         campuses.add(campus);
      }
      return campuses;
   }

   @Override
   public void save(Campus campus) {
      repo.save(campus);
   }
}