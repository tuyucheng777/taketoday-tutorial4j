package cn.tuyucheng.taketoday.jpa.entitygraph;

import cn.tuyucheng.taketoday.jpa.entitygraph.model.Post;
import cn.tuyucheng.taketoday.jpa.entitygraph.repo.PostRepository;

public class MainApp {

   public static void main(String... args) {
      Long postId = 1L;
      Post post = null;
      PostRepository postRepository = new PostRepository();

      // Using EntityManager.find().
      post = postRepository.find(postId);
      post = postRepository.findWithEntityGraph(postId);
      post = postRepository.findWithEntityGraph2(postId);

      // Using JPQL: Query and TypedQuery
      post = postRepository.findUsingJpql(postId);

      // Using Criteria API
      post = postRepository.findUsingCriteria(postId);

      postRepository.clean();
   }
}