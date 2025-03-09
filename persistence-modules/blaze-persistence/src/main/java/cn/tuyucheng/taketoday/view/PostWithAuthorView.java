package cn.tuyucheng.taketoday.view;

import cn.tuyucheng.taketoday.model.Post;
import com.blazebit.persistence.view.EntityView;

@EntityView(Post.class)
public interface PostWithAuthorView extends PostView {
   PersonView getAuthor();

}
