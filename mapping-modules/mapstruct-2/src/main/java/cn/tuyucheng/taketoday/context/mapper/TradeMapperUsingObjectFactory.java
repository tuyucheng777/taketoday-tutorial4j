package cn.tuyucheng.taketoday.context.mapper;

import cn.tuyucheng.taketoday.context.entity.Trade;
import cn.tuyucheng.taketoday.context.entity.TradeDto;
import cn.tuyucheng.taketoday.context.service.TradeDtoFactory;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mapper(uses = TradeDtoFactory.class)
public abstract class TradeMapperUsingObjectFactory {
   final Logger logger = LoggerFactory.getLogger(TradeMapperUsingObjectFactory.class);

   public static TradeMapperUsingObjectFactory getInstance() {
      return Mappers.getMapper(TradeMapperUsingObjectFactory.class);
   }

   protected abstract TradeDto toTradeDto(Trade trade, @Context String identifierType);
}