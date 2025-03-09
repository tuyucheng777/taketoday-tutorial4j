package cn.tuyucheng.taketoday.view;

import cn.tuyucheng.taketoday.model.Post;
import com.blazebit.persistence.view.EntityView;
import com.blazebit.persistence.view.IdMapping;
import com.blazebit.persistence.view.Mapping;

@EntityView(Post.class)
public interface PostView {

   @IdMapping
   Long getId();

   @Mapping("UPPER(title)")
   String getTitle();

   String getContent();
}
