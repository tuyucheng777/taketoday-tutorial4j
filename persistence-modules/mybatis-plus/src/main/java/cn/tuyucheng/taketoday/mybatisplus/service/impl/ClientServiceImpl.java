package cn.tuyucheng.taketoday.mybatisplus.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tuyucheng.taketoday.mybatisplus.entity.Client;
import cn.tuyucheng.taketoday.mybatisplus.mapper.ClientMapper;
import cn.tuyucheng.taketoday.mybatisplus.service.ClientService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

@Service
public class ClientServiceImpl extends ServiceImpl<ClientMapper, Client> implements ClientService {

   @Autowired
   private ClientMapper clientMapper;
}