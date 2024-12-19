package cn.tuyucheng.taketoday.listvsset.eager.set.lazy.moderatedomain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class GroupService {

   private final GroupRepository groupRepository;

   @Autowired
   public GroupService(GroupRepository groupRepository) {
      this.groupRepository = groupRepository;
   }

   public Optional<Group> findById(Long aLong) {
      return groupRepository.findById(aLong);
   }

   public List<Group> findAll() {
      return groupRepository.findAll();
   }

   public void save(Group group) {
      groupRepository.save(group);
   }
}