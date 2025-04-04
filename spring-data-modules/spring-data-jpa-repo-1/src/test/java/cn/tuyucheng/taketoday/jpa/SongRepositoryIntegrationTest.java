package cn.tuyucheng.taketoday.jpa;

import cn.tuyucheng.taketoday.jpa.domain.Song;
import cn.tuyucheng.taketoday.jpa.repository.SongRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {JpaApplication.class})
@Sql(scripts = {"/test-song-data.sql"})
@DirtiesContext
public class SongRepositoryIntegrationTest {

   @Autowired
   private SongRepository songRepository;

   @Transactional
   @Test
   public void givenSong_WhenFindLikeByName_ThenShouldReturnOne() {
      List<Song> songs = songRepository.findByNameLike("Despacito");
      assertEquals(1, songs.size());
   }

   @Transactional
   @Test
   public void givenSong_WhenFindByNameNotLike_thenShouldReturn3Songs() {
      List<Song> songs = songRepository.findByNameNotLike("Despacito");
      assertEquals(5, songs.size());
   }

   @Transactional
   @Test
   public void givenSong_WhenFindByNameStartingWith_thenShouldReturn2Songs() {
      List<Song> songs = songRepository.findByNameStartingWith("Co");
      assertEquals(2, songs.size());
   }

   @Transactional
   @Test
   public void givenSong_WhenFindByNameEndingWith_thenShouldReturn2Songs() {
      List<Song> songs = songRepository.findByNameEndingWith("Life");
      assertEquals(2, songs.size());
   }

   @Transactional
   @Test
   public void givenSong_WhenFindBySingerContaining_thenShouldReturn2Songs() {
      List<Song> songs = songRepository.findBySingerContaining("Luis");
      assertEquals(2, songs.size());
   }
}
