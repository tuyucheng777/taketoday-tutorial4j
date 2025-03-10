package cn.tuyucheng.taketoday.mybatisplus.mapper;

import org.apache.ibatis.annotations.Mapper;

import cn.tuyucheng.taketoday.mybatisplus.entity.Client;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

@Mapper
public interface ClientMapper extends BaseMapper<Client> {
}