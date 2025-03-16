package cn.tuyucheng.taketoday.listvsset;

import cn.tuyucheng.taketoday.listvsset.eager.list.fulldomain.*;
import cn.tuyucheng.taketoday.listvsset.util.JsonUtils;
import cn.tuyucheng.taketoday.listvsset.util.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = {Application.class, TestConfig.class})
class JsonUtilUnitTest {

   @Autowired
   private JsonUtils jsonUtils;

   @Test
   void givenFileWhenConvertingToUsersThenConversionIsCorrect() {
      List<User> users = jsonUtils.getUsers(User.class);
      assertThat(users).isNotEmpty();
      boolean wentThroughEverything = false;
      for (User user : users) {
         assertThat(user.getGroups()).isNotNull();
         Profile profile = user.getProfile();
         if (profile != null) {
            assertThat(user.getId()).isEqualTo(profile.getUser().getId());
         }
         for (Post post : user.getPosts()) {
            assertThat(user.getId()).isEqualTo(post.getAuthor().getId());
            if (post.getComments() != null) {
               wentThroughEverything = true;
               for (Comment comment : post.getComments()) {
                  assertThat(post.getId()).isEqualTo(comment.getPost().getId());
               }
            }
         }
      }
      assertTrue(wentThroughEverything);
   }

   @Test
   void givenFileWhenConvertingToGroupsThenConversionIsCorrect() {
      List<Group> groups = jsonUtils.getGroups(Group.class);
      assertThat(groups).isNotEmpty();
   }


}
