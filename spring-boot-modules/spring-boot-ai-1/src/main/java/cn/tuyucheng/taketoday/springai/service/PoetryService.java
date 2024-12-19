package cn.tuyucheng.taketoday.springai.service;

import cn.tuyucheng.taketoday.springai.dto.PoetryDto;

public interface PoetryService {

   String getCatHaiku();

   PoetryDto getPoetryByGenreAndTheme(String genre, String theme);
}